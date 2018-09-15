import bridge.demo2.AbstractReporter;
import bridge.demo2.ExcelDataCollect;
import bridge.demo2.Reporter1;
import chain.Congress;
import chain.Director;
import chain.President;
import chain.PurchaseRequest;
import command.*;
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
import strategy.ConcreteStrategyA;
import strategy.Context;
import visit.*;

import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
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


        String s = "cb37490a6b7b28da09e7adb06a32f646|8.6.0|599|381220356ad1f5d4abfd0865f80e9cc6|1|0";
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

        black1.display(new Coordinates(1, 2));
        black2.display(new Coordinates(3, 4));
        black3.display(new Coordinates(5, 6));

        white1.display(new Coordinates(7, 8));
        white2.display(new Coordinates(9, 9));

        //--------------代理模式----------------------

        ProxySearcher proxySearcher = new ProxySearcher();
        proxySearcher.doSearch("sven", "age");

        //--------------职责链模式------------------------
        Director director = new Director("zf");
        President president = new President("sw");
        Congress congress = new Congress("people");
        director.setApprover(president);
        president.setApprover(congress);

        PurchaseRequest purchaseRequest1 = new PurchaseRequest(500);
        PurchaseRequest purchaseRequest2 = new PurchaseRequest(1200);
        PurchaseRequest purchaseRequest3 = new PurchaseRequest(6000);

        director.processRequest(purchaseRequest1);
        director.processRequest(purchaseRequest2);
        director.processRequest(purchaseRequest3);
        //--------------命令模式------------------------

//        FBSettingWindow fbsw = new FBSettingWindow("功能键设置");
//        FunctionButton fb1, fb2;
//        fb1 = new FunctionButton("功能键1");
//        fb2 = new FunctionButton("功能键2");
//        Command command1, command2;
//        //通过读取配置文件和反射生成具体命令对象
//        command1 = new HelpCommand();
//
//        command2 = new MinimizeCommand();
//        //将命令对象注入功能键
//        fb1.setCommand(command1);
//        fb2.setCommand(command2);
//        fbsw.addFunctionButton(fb1);
//        fbsw.addFunctionButton(fb2);
//        //        fbsw.display();
//        fb1.onClick();
//        fb2.onClick();

         //-----------------策略模式-------------
//        Context context = new Context();
//        context.setStrategy(new ConcreteStrategyA());
//        context.algorithm();

        // --------------- 访问者模式------------

        EmployeeList list = new EmployeeList();
        Employee fte1,fte2,fte3,pte1,pte2;
        fte1 = new FulltimeEmployee("张无忌",3200.00,45);
        fte2 = new FulltimeEmployee("杨过",2000.00,40);
        fte3 = new FulltimeEmployee("段誉",2400.00,38);
        pte1 = new ParttimeEmployee("洪七公",80.00,20);
        pte2 = new ParttimeEmployee("郭靖",60.00,18);
        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);

        FADepartment faDepartment = new FADepartment();
        list.accept(faDepartment);

    }
}
