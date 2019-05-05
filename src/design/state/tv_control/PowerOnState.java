package design.state.tv_control;

public class PowerOnState implements TvState {
    @Override
    public void turnUp() {
        System.out.println("turnUp");
    }

    @Override
    public void turnDown() {
        System.out.println("turnDown");
    }

    @Override
    public void nextChannel() {
        System.out.println("nextChannel");
    }

    @Override
    public void lastChannel() {
        System.out.println("lastChannel");
    }
}
