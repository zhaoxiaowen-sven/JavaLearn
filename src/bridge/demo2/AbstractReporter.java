package bridge.demo2;


/**
 * 桥接模式+适配器模式
 */
public abstract class AbstractReporter {
    DataCollect dataCollectImpl;

    public void setDataCollectImpl(DataCollect dataCollectImpl) {
        this.dataCollectImpl = dataCollectImpl;
    }

    public abstract void report();
}
