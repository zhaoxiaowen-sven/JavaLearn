package observer;

public class ConcreteObserver extends Observer {
    @Override
    void notify(String name) {
        for(Subject subject : subjectList){
            if (!name.equals(subject.getName())){
                subject.help(name);
            }
        }
    }
}
