package design.mediator.demo1;

public abstract class EColleague {
    protected EMediator eMediator;

    public EColleague(EMediator eMediator){
        this.eMediator = eMediator;
    }
}
