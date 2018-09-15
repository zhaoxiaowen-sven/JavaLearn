package state.sw;

abstract class State {
    public abstract void on(TestSwitch s);
    public abstract void off(TestSwitch s);
}
