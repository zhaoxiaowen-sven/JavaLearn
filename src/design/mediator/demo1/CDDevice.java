package design.mediator.demo1;

public class CDDevice extends EColleague {

    public String data;


    public CDDevice(EMediator eMediator) {
        super(eMediator);
    }

    public void load(){
        data = "视频数据,音频数据";
        eMediator.onChanged(this);
    }
}
