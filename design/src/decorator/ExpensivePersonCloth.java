package decorator;

public class ExpensivePersonCloth extends PersonCloth {
    public ExpensivePersonCloth(Person p) {
        super(p);
    }

    @Override
    public void dressed() {
        super.dressed();
        dressExpensive();
    }

    private void dressExpensive() {
        System.out.println("dressExpensive");
    }
}
