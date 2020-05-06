package observer;

public interface Subject {
    public String getName();

    public void help(String name);

    public void beAttacked(Observer observer);

}
