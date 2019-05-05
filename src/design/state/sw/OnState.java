package design.state.sw;

class OnState extends State {
    public void on(TestSwitch s) {
        System.out.println("已经打开！");
    }
    public void off(TestSwitch s) {
        System.out.println("关闭！");
        s.setState(TestSwitch.getState("off"));
    }
}

