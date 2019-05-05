package design.adapter;

/*
 *  单一接口适配器
 */
public class Adapter4 extends AbstractAdapter implements ITarget {

    @Override
    public void requestA() {
        specialRequestA();
    }

    @Override
    public void requestB() {
        specialRequestA();

    }
}
