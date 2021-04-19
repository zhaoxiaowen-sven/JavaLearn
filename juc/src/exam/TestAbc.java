package exam;

public class TestAbc {

    static final int n = 10;
    static volatile int count = 0;
    private static final Object object = new Object();

    public TestAbc() {

    }

    public static void main(String[] args) {

        TestAbc testAbc = new TestAbc();
        Thread tA = new Thread(new Runnable() {
            @Override
            public void run() {
                testAbc.print("A", 0);
            }
        });

        Thread tB = new Thread(new Runnable() {
            @Override
            public void run() {
                testAbc.print("B", 1);
            }
        });

        Thread tC = new Thread(new Runnable() {
            @Override
            public void run() {
                testAbc.print("C", 2);
            }
        });

        tA.start();
        tB.start();
        tC.start();
    }

    private void print(String a, int state) {
        while (count < n) {
            synchronized (object) {
                while (count % 3 != state) {
                    try {
                        object.wait();
                    } catch (InterruptedException e) {

                    }
                }
                System.out.print(a);
                count++;
                object.notifyAll();
            }
        }

    }

}
