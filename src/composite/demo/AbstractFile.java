package composite.demo;

public abstract class AbstractFile {

    public abstract void add(AbstractFile file);
    public abstract void remove(AbstractFile file);
    public abstract void get(int i);
    public abstract void killVirus();
}
