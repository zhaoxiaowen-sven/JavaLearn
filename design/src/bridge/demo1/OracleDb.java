package bridge.demo1;

public class OracleDb implements Db {
    @Override
    public DbFile getDbFile() {
        return new DbFile("OracleDb file");
    }
}
