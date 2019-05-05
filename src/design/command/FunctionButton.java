package design.command;

public class FunctionButton {
    private String name;
    private Command command;

    public FunctionButton(String name){
        this.name = name;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    //发送请求的方法
    public void onClick() {
        System.out.print("点击功能键：" + name);
        command.execute();
    }

    public String getName() {
        return this.name;
    }


}
