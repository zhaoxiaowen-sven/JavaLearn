package runtimearea;

public class StaticFieldTest {
    private static byte[] arr = new byte[1024 * 1024 * 100]; //100MB

    public static void main(String[] args) {
        System.out.println(StaticFieldTest.arr);
    }
}
