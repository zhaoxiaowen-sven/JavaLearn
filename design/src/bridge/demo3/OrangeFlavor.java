package bridge.demo3;

public class OrangeFlavor implements Flavor{
    @Override
    public void add(String drink) {
        System.out.println("make orange flavor " + drink );
    }
}
