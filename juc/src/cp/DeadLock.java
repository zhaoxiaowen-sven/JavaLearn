package cp;

public class DeadLock {
    private static final Object obj1 = new Object();
    private static final Object obj2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                synchronized (obj1) {
                    System.out.println("get obj1");
                    synchronized (obj2) {
                        System.out.println("get obj2");
                    }
                    System.out.println("release obj2");
                }
                System.out.println("release obj1");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        // lambda 表达式
        new Thread(() -> {
            while (true) {
                synchronized (obj2) {
                    System.out.println("get obj2222");
                    synchronized (obj1) {
                        System.out.println("get obj11111");
                    }
                    System.out.println("release obj11111");
                }
                System.out.println("release obj2222");

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
