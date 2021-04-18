package classloader;

public class NoInitialization {

    public static void main(String[] args) {
        SuperClass value = new SuperClass();
        System.out.println(InitClass.x);
    }
}
