public class VolatileTest {

//    static class Singleton {
        private static volatile VolatileTest instance;
        private VolatileTest() {
        }
        public static VolatileTest getInstance() {
            if(instance == null) {
                synchronized (VolatileTest.class) {
                    if (instance == null) {
                        instance = new VolatileTest();
                    }
                }
            }
            return instance;
        }
//    }

//    public static void test() {
//        Singleton.getInstance();
//    }
}
