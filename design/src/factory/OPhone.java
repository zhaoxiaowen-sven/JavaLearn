package factory;

public class OPhone implements Phone {
    @Override
    public void call() {
        System.out.println("OPhone call");
    }
}
