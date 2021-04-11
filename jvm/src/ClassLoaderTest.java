import java.net.URLClassLoader;

public class ClassLoaderTest {

    public static void test() {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);
        System.out.println(ClassLoaderTest.class.getClassLoader());


    }
}
