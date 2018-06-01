import bridge.demo1.AbstractFileParser;
import bridge.demo1.XmlParser;
import bridge.demo1.MySqlDb;
import bridge.demo2.AbstractReporter;
import bridge.demo2.ExcelDataCollect;
import bridge.demo2.Reporter1;
<<<<<<< HEAD
import composite.demo.AbstractFile;
import composite.demo.Folder;
import composite.demo.ImageFile;
import composite.demo.TextFile;
=======
>>>>>>> f775a6926a6e14805d6f57e622971a4fd565334a
import prototype.Attachment;
import prototype.Weeklylog2;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args){
//        Factory vivoFactory = new VivoFactory();
//        vivoFactory.createMobile().call();
//        vivoFactory.createTv().play();
//
//
//        Director director = new Director(new Builder());
//        Product product = director.construct();
//        System.out.println(product.toString());

//        ActorController actorController = new ActorController();
//        System.out.println(actorController.construct(new AngelBuilder()));

        //建造者模式
//        ActorBuilder actorBuilder = new AngelBuilder();
//        actorBuilder.buildName("name");
//        actorBuilder.buildAge("age");
//        actorBuilder.buildFace("name");
//        System.out.println(actorBuilder.build());

        //----------------------原型模式 begin---------------
        Weeklylog2 log_previous = new Weeklylog2();  //创建原型对象
        log_previous.name = "vivo";
        log_previous.date = "0530";
        log_previous.tasks = new ArrayList();
        Attachment attachment = new Attachment();
        attachment.setName("attachment");
        log_previous.attachment = attachment;

        Weeklylog2 today = null;
        try {
            today = log_previous.deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
//        System.out.println(log_previous == today);
//        System.out.println(log_previous.name == today.name);
//        System.out.println(log_previous.date == today.date);
//        System.out.println(log_previous.tasks == today.tasks);
//        System.out.println(log_previous.attachment == today.attachment);
//
//        System.out.println(log_previous.name + " "+ today.name);
//        System.out.println(log_previous.date + " "+ today.date);
        //----------------------prototype end---------------

//        Weeklylog log_previous2 = new Weeklylog();  //创建原型对象
//        log_previous2.name = "vivo";
//        log_previous2.date = "0530";
//        log_previous2.tasks = new ArrayList();
//        Attachment attachment2 = new Attachment();
//        attachment2.setName("yyy");
//        attachment.setName("attachment");
//        log_previous2.attachment = attachment2;
//
//        Weeklylog today2 = log_previous2.clone();
//        log_previous2.name = "xxx";
//        today2.attachment.setName("yyy2");
//        System.out.println(log_previous2 == today2);
//        System.out.println(log_previous2.name +"//"+ today2.name);
//        System.out.println(log_previous2.attachment.getName() +"___"+ today2.attachment.getName());

        //------------------桥接模式---------------------
//        AbstractFileParser parser = new XmlParser();
//        parser.setDbImpl(new MySqlDb());
//        parser.parse();
        // 桥接模式 + 适配器模式
        AbstractReporter reporter = new Reporter1();
        reporter.setDataCollectImpl(new ExcelDataCollect());
        reporter.report();

<<<<<<< HEAD
        // 组合模式
        AbstractFile file = new Folder();
        AbstractFile imageFile = new ImageFile();
        AbstractFile textFile = new TextFile();
        file.add(imageFile);
        file.add(textFile);
        file.killVirus();

=======
>>>>>>> f775a6926a6e14805d6f57e622971a4fd565334a
    }
}
