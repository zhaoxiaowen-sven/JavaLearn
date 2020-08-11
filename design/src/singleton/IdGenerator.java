package singleton;

public class IdGenerator {
    // 1. 饿汉式
//    private static final IdGenerator Instance = new IdGenerator();

//    private IdGenerator() {
//    }
//
//    public static IdGenerator getInstance() {
//        return Instance;
//    }

    // 2. 懒汉式
//    private static IdGenerator Instance;
//
//    private IdGenerator() {
//    }
//
//    public static synchronized IdGenerator getInstance() {
//        if (Instance == null) {
//            Instance = new IdGenerator();
//        }
//        return Instance;
//    }

    // 3. 双重检测
//    private static volatile IdGenerator instance;
//
//    private IdGenerator() {
//    }
//
//    public static IdGenerator getInstance() {
//        if (instance == null) {
//            synchronized (IdGenerator.class) {
//                if (instance == null) {
//                    instance = new IdGenerator();
//                }
//            }
//        }
//        return instance;
//    }

    // 4.静态内部类
//    private IdGenerator() {
//    }
//
//    public static synchronized IdGenerator getInstance() {
//        return SingletonHolder.instance;
//    }
//
//    private static class SingletonHolder {
//        private static final IdGenerator instance = new IdGenerator();
//    }


}
