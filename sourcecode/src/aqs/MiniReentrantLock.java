package aqs;


import sun.misc.Unsafe;

import java.lang.reflect.Field;

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
    }

    @Override
    public void lock() {
        if (state == 0) {

        }
//        else if (state > 0 )

    }

    /**
     * 1、尝试获取锁
     * 2、失败
     */
    private void acquire(int arg) {

    }

    private boolean tryAcquire(int arg) {
        Thread current = Thread.currentThread();
        if (state == 0) {
            // 从队列中获取
            if (!hasQueuedPredecessors() && compareAndSetState(0, arg)) {
                exclusiveOwnerThread = current;
                return true;
            }
            // 锁被占用了
        } else if (current == exclusiveOwnerThread) {
            // 只有当前加锁线程才能进入该段代码
            int c = getState();
            c  = c + arg;
            state = c;
            return true;
        }
        return false;
    }

    public int getState() {
        return state;
    }

    private boolean hasQueuedPredecessors() {

        return false;
    }

    @Override
    public void unlock() {

    }

    public void setHead(Node node) {
        this.head = node;
        node.thread = null;
        node.prev = null;
    }
}
