package design.decorator;

public class ExpensiveCloth extends Cloth {
    public ExpensiveCloth(Person p) {
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
