package design.mediator.demo1;

public class SoundCard extends EColleague {

    public SoundCard(EMediator eMediator) {
        super(eMediator);
    }

    public void soundPlay(String data){
        System.out.println("音频 " + data);
    }
}
