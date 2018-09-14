package command;

public class MinimizeCommand extends Command {

    private WindowHanlder whObj; //维持对请求接收者的引用

    public MinimizeCommand() {
        whObj = new WindowHanlder();
    }

    @Override
    public void execute() {
        whObj.minimize();
    }
}
