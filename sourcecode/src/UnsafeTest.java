import sun.misc.Unsafe;

public class UnsafeTest {

    static Unsafe u;
    static {
        try {
            u = getUnsafe();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static sun.misc.Unsafe getUnsafe() throws Exception {
        java.lang.reflect.Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe=(Unsafe) field.get(null);
        return unsafe;
    }

    public static void testUnSafe() {

    }
}
