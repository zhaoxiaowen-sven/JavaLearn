public class JvmTest {

    static {
        i = 30;

//        system.out.println(i); // 可以赋值，但是不能调用
    }

    static int i = 15;

    int x = 20;

    public JvmTest() {
        x = 10;
    }

    public static void main(String[] args) {
//        System.out.println("jvmtest");

//        ClassLoaderTest.test();

//        new DynamicLinkingTest().methodB();

        new AnimalTest().test();
    }
}
