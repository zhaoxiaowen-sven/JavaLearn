package adapter;

public class Adapter3 extends AdapteeA implements ITarget {

    @Override
    public void requestA() {
        specialRequestA();
    }

    @Override
    public void requestB() {

    }


}
