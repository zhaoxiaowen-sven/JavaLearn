package bridge.demo2;

public class Reporter1 extends AbstractReporter{
    @Override
    public void report() {
        System.out.println("Reporter1 "+dataCollectImpl.collectData().data);
    }
}
