package design.adapter;

/*
 *  双向适配器
 */
public class Adapter2 implements ITarget,IAdaptee {
    ITarget target;
    IAdaptee adaptee;

    public Adapter2(ITarget target, IAdaptee adaptee){
        this.target = target;
        this.adaptee = adaptee;
    }

    @Override
    public void requestA() {
        adaptee.specialRequestA();

    }

    @Override
    public void requestB() {
        adaptee.specialRequestB();
    }

    @Override
    public void specialRequestA() {
        target.requestA();
    }

    @Override
    public void specialRequestB() {
        target.requestB();
    }
}
