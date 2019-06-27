package mem;

public class Test {
    private static volatile int i = 0;

    static int a = 0;
    private static Runnable runnable = () -> {


        i++;
        System.out.println("i = " + i);
//        FinalKeyWord.writer();
    };

    private static synchronized void writer() {
        for (int i = 0; i < 1000; i++) {
            a++;
        }
    }

    private static synchronized void reader() {
        int b = a;
        System.out.println("b = " + a);
    }

    public static void main(String[] args) throws InterruptedException {
//        Thread a = new Thread(runnable);
//        Thread b = new Thread(runnable);
//        a.start();
//        try {
//            a.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        b.start();

//        new Thread(() -> writer()).start();
//        new Thread(()-> reader()).start();

//        new Thread(() -> FinalKeyWord.writer()).start();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        new Thread(()-> FinalKeyWord.reader()).start();
//        System.out.println("i = "+ i);

//        WaitNotify.testBarrier();

        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                writer();
            }
        });

        b.start();
//        try {
//            b.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

//        Thread x = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                writer();
//            }
//        });
//        x.start();
//        System.out.println("a = " + a);

//        AtomApiTest.test4();
        SyncUtilApiTest.testBarrier();
//        SyncUtilApiTest.testExchanger();
    }
}
