import bridge.demo2.AbstractReporter;
import bridge.demo2.ExcelDataCollect;
import bridge.demo2.Reporter1;
import bridge.demo3.DrinkTest;
import chain.Congress;
import chain.Director;
import chain.President;
import chain.PurchaseRequest;
import chain.demo1.ChainTest;
import composite.demo.AbstractFile;
import composite.demo.Folder;
import composite.demo.ImageFile;
import composite.demo.TextFile;
import composite.demo2.CompositeTest;
import decorator.Boy;
import decorator.CheapPersonCloth;
import decorator.Person;
import flyweight.Coordinates;
import flyweight.IgoChessman;
import flyweight.IgoChessmanFactory;
import jdk.nashorn.internal.ir.WhileNode;
import mediator.demo1.*;
import memento.MemoTest;
import observer.ConcreteObserver;
import observer.ConcreteSubject;
import observer.Observer;
import observer.Subject;
import prototype.Attachment;
import prototype.Weeklylog2;
import proxy.ProxySearcher;
import proxy.dynamic.DynamicProxy;
import proxy.dynamic.UserService;
import proxy.dynamic.UserServiceImpl;
import singleton.IdGenerator2;
import state.Account;
import state.sw.TestSwitch;
import visit.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class DesignTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
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
//        Weeklylog today2 = log_previous2.clone();ConcreteStrategyA
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

        // 装饰模式
        Person person = new Boy();
        CheapPersonCloth cheapCloth = new CheapPersonCloth(person);
        cheapCloth.dressed();


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
        Employee fte1, fte2, fte3, pte1, pte2;
        fte1 = new FulltimeEmployee("张无忌", 3200.00, 45);
        fte2 = new FulltimeEmployee("杨过", 2000.00, 40);
        fte3 = new FulltimeEmployee("段誉", 2400.00, 38);
        pte1 = new ParttimeEmployee("洪七公", 80.00, 20);
        pte2 = new ParttimeEmployee("郭靖", 60.00, 18);
        list.addEmployee(fte1);
        list.addEmployee(fte2);
        list.addEmployee(fte3);
        list.addEmployee(pte1);
        list.addEmployee(pte2);

        FADepartment faDepartment = new FADepartment();
        list.accept(faDepartment);

        HRDepartment hrDepartment = new HRDepartment();
        list.accept(hrDepartment);

        // --------------观察者模式---------------
        Observer observer = new ConcreteObserver();
        Subject subject1 = new ConcreteSubject("杨过");
        Subject subject2 = new ConcreteSubject("郭靖");
        Subject subject3 = new ConcreteSubject("令狐冲");
        observer.add(subject1);
        observer.add(subject2);
        observer.add(subject3);

        subject1.beAttacked(observer);

        // --------------状态模式----------------
        Account acc = new Account("段誉", 0.0);
        acc.deposit(1000);
        acc.withdraw(2000);
        acc.deposit(3000);
        acc.withdraw(4000);
        acc.withdraw(1000);
        acc.computeInterest();

        // --------------状态模式----------------

        TestSwitch s1, testSwitch2;
        s1 = new TestSwitch("开关1");
        testSwitch2 = new TestSwitch("开关2");
        s1.on();
        testSwitch2.on();
        s1.off();
        testSwitch2.off();
        testSwitch2.on();
        s1.on();
        //---------------------------

        //--------------中介者模式--------------

        MainBoard eMediator = new MainBoard();

        CDDevice cdDevice = new CDDevice(eMediator);
        CPU cpu = new CPU(eMediator);
        GraphicsCard graphicCard = new GraphicsCard(eMediator);
        SoundCard soundCard = new SoundCard(eMediator);

        eMediator.mGraphicCard = graphicCard;
        eMediator.mCpu = cpu;
        eMediator.mSoundCard = soundCard;
        eMediator.mCdDevice = cdDevice;

        cdDevice.load();

        IdGenerator2.Instance.doSth();


        // 设置变量可以保存动态代理类，默认名称以 $Proxy0 格式命名
//        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
//
//        /*
//         * 3.根据上面提供的信息，创建代理对象 在这个过程中，
//         *  a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
//         *  b.然后根据相应的字节码转换成对应的class，
//         *  c.然后调用newInstance()创建代理实例
//         */
        // 1. 创建被代理的对象，UserService接口的实现类
        UserService proxy = (UserService) DynamicProxy.createProxy(new UserServiceImpl());
        proxy.select();
        proxy.update();

//        DrinkTest.test();
//
//        CompositeTest.test();
//
//        ChainTest.testChain();
//
//        new Test2().test();
    }
}
