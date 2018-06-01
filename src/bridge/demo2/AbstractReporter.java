package bridge.demo2;

<<<<<<< HEAD
/**
 * 桥接模式+适配器模式
 */
=======
>>>>>>> f775a6926a6e14805d6f57e622971a4fd565334a
public abstract class AbstractReporter {
    DataCollect dataCollectImpl;

    public void setDataCollectImpl(DataCollect dataCollectImpl) {
        this.dataCollectImpl = dataCollectImpl;
    }

    public abstract void report();
}
