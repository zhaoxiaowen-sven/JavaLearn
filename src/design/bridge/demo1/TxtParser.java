package design.bridge.demo1;

public class TxtParser extends AbstractFileParser {
    @Override
    public void parse() {
        System.out.println("TxtParser " + dbImpl.getDbFile().dbFileName);

    }
}
