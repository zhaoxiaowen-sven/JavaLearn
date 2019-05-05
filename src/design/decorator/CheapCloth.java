package design.decorator;

public class CheapCloth extends Cloth{
    public CheapCloth(Person p) {
        super(p);
    }

    @Override
    public void dressed() {
        super.dressed();
        dressCheap();

    }

    private void dressCheap(){
        System.out.println("dress Cheap");
    }
}
