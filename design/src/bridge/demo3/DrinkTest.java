package bridge.demo3;

public class DrinkTest {
    public static void test() {
        Flavor flavor = new AppleFlavor();
        Drink drink = new Coffee(flavor);
        drink.drink();
    }
}
