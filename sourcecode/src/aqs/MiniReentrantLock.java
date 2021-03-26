package aqs;


import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.locks.LockSupport;

public class MiniReentrantLock implements MiniLock {

    static final Unsafe unsafe;
    static final long stateOffset;
    static final long headOffset;
    static final long tailOffset;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            stateOffset = unsafe.objectFieldOffset(MiniReentrantLock.class.getDeclaredField("state"));
            headOffset = unsafe.objectFieldOffset(MiniReentrantLock.class.getDeclaredField("head"));
            tailOffset = unsafe.objectFieldOffset(MiniReentrantLock.class.getDeclaredField("tail"));
        } catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new Error(ex);
        }
    }

    private boolean compareAndSetHead(Node update) {
        return unsafe.compareAndSwapObject(this, headOffset, null, update);
    }

    private boolean compareAndSetTail(Node except, Node update) {
        return unsafe.compareAndSwapObject(this, tailOffset, except, update);
    }

    private boolean compareAndSetState(int except, int update) {
        return unsafe.compareAndSwapInt(this, stateOffset, except, update);
    }


    /**
     * 0 -> no lock
     * 1 -> locked
     */
    private volatile int state;

    /**
     * 独占：只有一个线程可以持有锁
     */
    private Thread exclusiveOwnerThread;

    /**
     * 阻塞的线程封装到FIFO的队列中
     * head节点的线程是当前占用锁的线程
     */
    Node head;
    Node tail;

    /**
     * 线程节点
     */
    static class Node {
        Thread thread;

        Node prev;

        Node next;

        public Node(Thread thread) {
            this.thread = thread;
        }

        public Node() {
        }
    }

    @Override
    public void lock() {
        // 第一次抢占成功 state设置为1，第n次重入时设置为n
        acquire(1);
    }

    /**
     * 1、尝试获取锁
     * 2、失败
     */
    private void acquire(int arg) {
        if (!tryAcquire(arg)) {
            // 1.当前节点入队
            Node node = addWaiter();
            // 2.有线程调用时，都是尝试去唤醒下head的下一个节点
            acquiredQueue(node, arg);
        }
    }

    private boolean tryAcquire(int arg) {
        Thread current = Thread.currentThread();
        // 没有等待的线程
        if (state == 0) {
            // 没有阻塞的节点
            if (!hasQueuedPredecessors()
                    // 抢锁成功
                    && compareAndSetState(0, arg)) {
                exclusiveOwnerThread = current;
                return true;
            }
            // 锁被占用了
        } else if (current == exclusiveOwnerThread) {
            // 只有当前加锁线程才能进入该段代码
            int c = getState();
            c = c + arg;
            state = c;
            System.out.println("state = " + state);
            return true;
        }
        return false;
    }

    private void acquiredQueue(Node node, int arg) {
        // 只有当前线程成功获取到锁以后才会跳出自旋
        for (; ; ) {
            //什么情况下当前node被唤醒之后可以取尝试获取锁，当前node是head.next
            Node pred = node.prev;
            if (pred == head && tryAcquire(arg)) {
                // 说明当前线程竞争锁成功了
                setHead(node);
                pred.next = null;// pred 已经赋值给head了，再将pred.next 置为null
                return;
            }
            // 将当前线程挂起
            System.out.println(Thread.currentThread().getName() + " 挂起 ");
            LockSupport.park();
            System.out.println(Thread.currentThread().getName() + " 唤醒 ");
        }
    }

    /**
     * 1.尝试抢锁失败，
     * 1.需要将当前线程封装成node，加入阻塞队列中
     * 2.挂起当前线程
     * 2.尝试唤醒：
     * 1.检查当前节点是否是HEAD.next 拥有抢占权限，当然也不一定能抢占到
     * 2.抢占失败
     * 抢占成功：将当前线程设置为excluThread，head.prev出队
     * 抢占失败：等待唤醒
     * <p>
     * === 1、加入阻塞队列addWaiter
     * === 2、竞争资源逻辑 acquiredQueue()
     */
    private Node addWaiter() {
        Node newNode = new Node(Thread.currentThread());
        Node pred = tail;
        if (pred != null) {
            newNode.prev = pred;
            if (compareAndSetTail(pred, newNode)) {
                pred.next = newNode;
                return newNode;
            }
        }
        // 1.tail == null
        // 2.cas 失败
        enqNode(newNode);
        return newNode;
    }

    /**
     * enqNode 循环添加节点到队列中
     */
    private void enqNode(Node newNode) {
        for (; ; ) {
            // 1.队列是空队列，第一个抢占锁失败的线程
            if (tail == null) {
                if (compareAndSetHead(new Node())) { // ? 空节点？
                    tail = head; // 空队列的情况下，先添加一个空节点，再循环一次，进入else中，添加真实的节点
                }
            } else {
                Node pred = tail;
                if (pred != null) {
                    newNode.prev = pred;
                    if (compareAndSetTail(pred, newNode)) {
                        pred.next = newNode;
                        // 入队成功后
                        return;
                    }
                }
            }
        }
    }


    public int getState() {
        return state;
    }

    /**
     * true -> 当前线程前有等待的线程
     * false -> 当前线程前没有等待的线程
     * <p>
     * lock -> acquire -> tryAcquire -> hasQueuedPredecessors
     * acquiredQueue -> tryAcquire
     * <p>
     * 返回false的情况:
     * 1.当前队列为空
     * 2.head.next？？
     */
    private boolean hasQueuedPredecessors() {
        // 1.
        Node h = head;
        Node t = tail;
        Node s;

        // 1.h!= t, 排除 h==t == null 和 h == t == head 的情况，说明不是空队列
        // 2.不是队列的的情况下
        //   2.1、极端情况，第一个获取锁失败的线程 enqNode中 1、compareAndSetTail 成功，pred（Head）->next = node 未执行时，出现并发导致
        // 其他线程执行到这里，此时tail ！= head，队列中已经哟2个节点了，也不是空队列
        //   2.2、head.next 线程不是当前线程，要等待，否则说明是当前线程，线程要回去竞争锁了
        return h != t &&
                //
                ((s = h.next) == null || s.thread != Thread.currentThread());
    }

    @Override
    public void unlock() {
        release(1);
    }

    private void release(int args) {
        // 线程已经完全释放，唤醒其他节点的线程，公平锁
        if (tryRelease(args)) {
            Node head = this.head;
            if (head != null) {
                // 走到acquireQueued中
                unparkSuccessor(head);
            }
        }
    }

    private void unparkSuccessor(Node head) {
        Node node = head.next;
        if (node != null && node.thread != null) {
            LockSupport.unpark(node.thread);
        }
    }

    private boolean tryRelease(int arg) {
        if (exclusiveOwnerThread != Thread.currentThread()) {
            throw new RuntimeException("should lock before");
        }
        // 这里不存在并发，
        int c = getState() - arg;
        System.out.println("state = " + c);
        if (c == 0) {
            this.exclusiveOwnerThread = null;
            this.state = c;
            return true;
        }
        this.state = c;
        return false;
    }


    public void setHead(Node node) {
        this.head = node;
        // thread 后续不可能被sleep或中断，可以将node的thread 置为null
        node.thread = null;
        // head没有前驱
        node.prev = null;
    }
}
