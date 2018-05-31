package prototype;

import java.util.ArrayList;

public class Weeklylog implements Cloneable {
    public String name;
    public String date;
    public ArrayList tasks;
    public Attachment attachment;
    public Weeklylog(){

    }

    // java 复制方法，浅复制
    public Weeklylog clone() {
        Object obj = null;
        try {
            obj = super.clone();
        } catch (CloneNotSupportedException e) {

        }
        return (Weeklylog) obj;
    }

    // 深复制
//    public Weeklylog clone() {
////        Object obj = null;
////        try {
////            obj = super.clone();
////        } catch (CloneNotSupportedException e) {
////
////        }
////        return (Weeklylog) obj;
//        return  new Weeklylog(this);
//    }

    public Weeklylog(Weeklylog weeklylog){
        this.name = weeklylog.name;
        this.date = weeklylog.date;
        this.tasks = (ArrayList) weeklylog.tasks.clone();
        this.attachment = new Attachment(weeklylog.attachment);
    }
}
