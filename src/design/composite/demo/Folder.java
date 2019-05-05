package design.composite.demo;

import java.util.ArrayList;

public class Folder extends AbstractFile{

    private ArrayList<AbstractFile> list = new ArrayList<>();


    @Override
    public void add(AbstractFile file) {
        list.add(file);
    }

    @Override
    public void remove(AbstractFile file) {
        list.remove(file);

    }

    @Override
    public void get(int i) {
        list.get(i);
    }

    @Override
    public void killVirus() {
        System.out.println("文件夹杀毒");
        for (AbstractFile file : list){
            file.killVirus();
        }
    }
}
