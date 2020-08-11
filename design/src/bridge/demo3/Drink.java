package bridge.demo3;

public abstract class Drink {
    protected Flavor flavor;

    public Drink(Flavor flavor) {
        this.flavor = flavor;
    }

    abstract void drink();
}
