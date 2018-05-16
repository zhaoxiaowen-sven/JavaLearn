package factory;

public class Test {
    public static void main(String[] args){
        Factory vivoFactory = new VivoFactory();
        vivoFactory.createMobile().call();
        vivoFactory.createTv().play();
    }
}
