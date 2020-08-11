package bridge.demo3;

public class Tea extends Drink {
    public Tea(Flavor flavor) {
        super(flavor);
    }

    @Override
    void drink() {
        flavor.add("tea");
    }
}
