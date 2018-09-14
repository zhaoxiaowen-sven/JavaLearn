package command;

public class MinimizeCommand extends Command {

    private WindowHandler whObj; //维持对请求接收者的引用

    public MinimizeCommand() {
        whObj = new WindowHandler();
    }

    @Override
    public void execute() {
        whObj.minimize();
    }
}
