package decorator;

public class CheapPersonCloth extends PersonCloth {

    public CheapPersonCloth(Person p) {
        super(p);
    }

    @Override
    public void dressed() {
        super.dressed();
        dressCheap();
    }

    private void dressCheap() {
        System.out.println("dress Cheap");
    }
}
