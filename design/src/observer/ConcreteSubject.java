package observer;

public class ConcreteSubject implements Subject {
    private String name;


    public ConcreteSubject(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void help(String name) {
        System.out.println(this.name + " 帮助下 " + name);
    }

    @Override
    public void beAttacked(Observer observer) {
        System.out.println(this.name + "被攻击了");

        observer.notify(name);
    }
}
