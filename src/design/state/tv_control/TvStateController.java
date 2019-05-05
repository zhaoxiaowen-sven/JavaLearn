package design.state.tv_control;

public class TvStateController {
    private static TvState sCurrentState, sOnState, sOffState;

    public TvStateController() {
        sOnState = new PowerOnState();
        sOffState = new PowerOffState();
        sCurrentState = sOnState;
    }

    public void powerOn() {
        sCurrentState = sOnState;
    }

    public void powerOff() {
        sCurrentState = sOffState;
    }

    public void turnUp() {
        sCurrentState.turnUp();
    }

    public void turnDown() {
        sCurrentState.turnDown();
    }

    public void nextChannel() {
        sCurrentState.nextChannel();
    }

    public void lastChannel() {
        sCurrentState.lastChannel();
    }

}
