package design.bridge.demo1;

public class MySqlDb implements Db {
    @Override
    public DbFile getDbFile() {
        return new DbFile("MySqlDb file");
    }
}
