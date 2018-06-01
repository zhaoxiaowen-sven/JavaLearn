package bridge.demo2;

public class Reporter2 extends AbstractReporter {

    @Override
    public void report() {
        System.out.println("Reporter2 "+dataCollectImpl.collectData().data);
    }
}
