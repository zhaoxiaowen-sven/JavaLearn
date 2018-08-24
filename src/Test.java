import bridge.demo1.AbstractFileParser;
import bridge.demo1.XmlParser;
import bridge.demo1.MySqlDb;
import bridge.demo2.AbstractReporter;
import bridge.demo2.ExcelDataCollect;
import bridge.demo2.Reporter1;
import composite.demo.AbstractFile;
import composite.demo.Folder;
import composite.demo.ImageFile;
import composite.demo.TextFile;
import flyweight.Coordinates;
import flyweight.IgoChessman;
import flyweight.IgoChessmanFactory;
import prototype.Attachment;
import prototype.Weeklylog2;
import proxy.ProxySearcher;

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

        // 组合模式
        AbstractFile file = new Folder();
        AbstractFile imageFile = new ImageFile();
        AbstractFile textFile = new TextFile();
        file.add(imageFile);
        file.add(textFile);
        file.killVirus();


        String s= "cb37490a6b7b28da09e7adb06a32f646|8.6.0|599|381220356ad1f5d4abfd0865f80e9cc6|1|0";
        String[] s2 = s.split("\\|");
        System.out.println(s2.length);

        boolean result = true || false && false;

        System.out.println(result);

        //-------------享元模式------------------
        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();

        IgoChessman black1, black2, black3, white1, white2;

        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");

        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");

        black1.display(new Coordinates(1,2));
        black2.display(new Coordinates(3,4));
        black3.display(new Coordinates(5,6));

        white1.display(new Coordinates(7,8));
        white2.display(new Coordinates(9,9));

        //--------------代理模式----------------------

        ProxySearcher proxySearcher = new ProxySearcher();
        proxySearcher.doSearch("sven", "age");

    }
}
