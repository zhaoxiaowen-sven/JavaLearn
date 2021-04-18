package classloader;

public class SuperClass implements InitClass{

    static int i = 11;
    static {
        System.out.println("Super class init");
    }

    @Override
    public void init() {

    }
}
