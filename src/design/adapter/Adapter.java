package design.adapter;

public class Adapter implements ITarget {
    AdapteeA adapteeA;
    AdapteeB adapteeB;

    public Adapter(){
        adapteeA = new AdapteeA();
        adapteeB = new AdapteeB();
    }

    @Override
    public void requestA() {
        adapteeA.specialRequestA();
    }

    @Override
    public void requestB() {
        adapteeB.specialRequestB();
    }
}
