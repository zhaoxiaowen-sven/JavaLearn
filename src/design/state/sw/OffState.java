package design.state.sw;

class OffState extends State {
    public void on(TestSwitch s) {
        System.out.println("打开！");
        s.setState(TestSwitch.getState("on"));
    }
    public void off(TestSwitch s) {
        System.out.println("已经关闭！");
    }
}

