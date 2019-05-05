package design.bridge.demo1;

public abstract class AbstractFileParser {
    Db dbImpl;

    public void setDbImpl(Db dbImpl) {
        this.dbImpl = dbImpl;
    }

    public abstract void parse();
}
