package bridge.demo2;

public class DbDataCollect implements DataCollect{

    @Override
    public Data collectData() {
        return new Data("DbDataCollect ");
    }
}
