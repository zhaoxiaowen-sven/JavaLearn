package mediator.demo1;

public class CPU extends EColleague {
    public String dataVideo, dataSound;

    public CPU(EMediator eMediator) {
        super(eMediator);
    }

    public void decodeData(String data){
        String[] tmp = data.split(",");
        dataVideo = tmp[0];
        dataSound = tmp[1];

        eMediator.onChanged(this);
    }
}
