package design.factory;

public class VivoPhone implements Phone {
    @Override
    public void call() {
        System.out.println("VivoPhone call");
    }
}
