package bridge.demo2;

public abstract class AbstractReporter {
    DataCollect dataCollectImpl;

    public void setDataCollectImpl(DataCollect dataCollectImpl) {
        this.dataCollectImpl = dataCollectImpl;
    }

    public abstract void report();
}
