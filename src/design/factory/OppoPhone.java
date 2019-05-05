package design.factory;

public class OppoPhone implements Phone {
    @Override
    public void call() {
        System.out.println("OppoPhone call");
    }
}
