package prototype;

import java.io.*;
import java.util.ArrayList;

public class Weeklylog2 implements Cloneable,Serializable {
    public String name;
    public String date;
    public ArrayList tasks;
    public Attachment attachment;

    public Weeklylog2() {

    }

    // java 复制方法，浅复制
//    public Weeklylog clone() {
//        Object obj = null;
//        try {
//            obj = super.clone();
//        } catch (CloneNotSupportedException e) {
//
//        }
//        return (Weeklylog) obj;
//    }

    //使用序列化技术实现深克隆
    public Weeklylog2 deepClone() throws IOException, ClassNotFoundException, OptionalDataException {
    //将对象写入流中
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);
    //将对象从流中取出
        ByteArrayInputStream bis = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        return (Weeklylog2) ois.readObject();
    }

}
