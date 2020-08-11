import java.util.Random;

public class Test2 {

    public void test() {

//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    long wait = new Random().nextInt(10);
//                    System.out.println("wait = " + wait);
//                    synchronized (Test2.this) {
//                        try {
//                            Test2.this.wait(wait *1000, 10000);
//                        } catch (InterruptedException e) {
//
//                        }
//                    }
//
//                }
//            }
//        };
//        new Thread(runnable).start();

        int FLAG_INFO = 1;
        int FLAG_COMPACT = 1 << 1;
        int FLAG_NET = 1 << 2;
        int FLAG_SPACE = 1 << 3;
        int FLAG_TASK = 1 << 4;

        int FLAG_FULL = FLAG_INFO | FLAG_COMPACT | FLAG_NET | FLAG_SPACE | FLAG_TASK;
        int FLAG_NONE = ~ FLAG_FULL;

        System.out.println("full = " + (FLAG_FULL & ~FLAG_NET) + " noene" + FLAG_NONE);
    }
}
