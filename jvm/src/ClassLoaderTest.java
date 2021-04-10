import java.net.URLClassLoader;

public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = systemClassLoader.getParent();


        ClassLoader bootstrapClassLoader = extClassLoader.getParent();


        ClassLoaderTest.class.getClassLoader();

//        URLClassLoader
    }
}
