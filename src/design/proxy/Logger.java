package design.proxy;

public class Logger {

    public void log(String userId, boolean status) {
        System.out.println("userId = " + userId + ", status = " + status);
    }
}
