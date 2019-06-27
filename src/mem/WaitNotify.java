package mem;

public class WaitNotify {

    static boolean flag = true;

    static Object lock = new Object();

    public static void test() {
        Thread thread = new Thread(new Wait());
        thread.start();

        Thread notify = new Thread(new Notify());
        notify.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("wait hold lock");
                while (flag) {
                    System.out.println("flag = true ");
                    try {
                        lock.wait();
                        System.out.println("wait finished ");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("flag = false ");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                System.out.println("hold lock");
                lock.notify();
                flag = false;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (lock) {
                System.out.println("hold lock again");
            }
        }
    }
}
