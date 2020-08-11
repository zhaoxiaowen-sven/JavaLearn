package bridge.demo3;

public class AppleFlavor implements Flavor {
    @Override
    public void add(String drink) {
        System.out.println("make apple flavor " + drink );
    }
}
