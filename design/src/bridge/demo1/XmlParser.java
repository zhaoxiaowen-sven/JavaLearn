package bridge.demo1;

public class XmlParser extends AbstractFileParser {
    @Override
    public void parse() {
        System.out.println("XmlParser " + dbImpl.getDbFile().dbFileName);
    }
}
