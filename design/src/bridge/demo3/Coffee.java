package bridge.demo3;

public class Coffee extends Drink {
    public Coffee(Flavor flavor) {
        super(flavor);
    }

    @Override
    void drink() {
        flavor.add("coffee");
    }
}
