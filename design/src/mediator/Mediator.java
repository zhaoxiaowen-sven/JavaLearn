package mediator;

import java.util.ArrayList;

public abstract class Mediator {

    protected ArrayList<Colleague> colleagues;

    public void register(Colleague colleague){
        colleagues.add(colleague);
    }

    public abstract void operation();
}
