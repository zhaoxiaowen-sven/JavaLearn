import java.awt.*;
import java.util.HashMap;

public class SourceCodeTest {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();

        int oldCap = 10;
        int newCap;

        if ((newCap = oldCap << 1) < 10) {

        }
        System.out.println("newCap " + newCap);
    }
}
