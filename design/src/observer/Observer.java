package observer;

import java.util.ArrayList;

public abstract class Observer {
    protected ArrayList<Subject> subjectList = new ArrayList<>();

    public void add(Subject subject){
        subjectList.add(subject);
    }
    abstract void notify(String name);

}
