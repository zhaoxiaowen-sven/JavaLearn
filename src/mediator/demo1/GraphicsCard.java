package mediator.demo1;

public class GraphicsCard extends EColleague {
    public GraphicsCard(EMediator eMediator) {
        super(eMediator);
    }

    public void videoPlay(String data){
        System.out.println("视频" +data);
    }
}
