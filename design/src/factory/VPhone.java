package factory;

public class VPhone implements Phone {
    @Override
    public void call() {
        System.out.println("VPhone call");
    }
}
