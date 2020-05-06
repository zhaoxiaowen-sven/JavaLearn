package bridge.demo1;

public class PdfParser extends AbstractFileParser {
    @Override
    public void parse() {
        System.out.println("PdfParser " + dbImpl.getDbFile().dbFileName);
    }
}

