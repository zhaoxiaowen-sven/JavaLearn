package string;

public class StringTest {
    // ！！！ 不可变性 ！！！
    public static void test1() {
        String s1 = "abc"; // abc 存储在字符串常量池中
        String s2 = "abc";
        s1 = "hello";
        System.out.println(s1 == s2);
    }

    public static void test2() {
        String s1 = "abc";
        String s2 = "abc";
        s2 += "def"; // abcdef
        System.out.println(s1 == s2);
    }

    public static void test3() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        /*
        如下的s1 + s2 的执行细节：(变量s是我临时定义的）
        ① StringBuilder s = new StringBuilder();
        ② s.append("a")
        ③ s.append("b")
        ④ s.toString()  --> 约等于 new String("ab")

        补充：在jdk5.0之后使用的是StringBuilder,
        在jdk5.0之前使用的是StringBuffer
         */
        String s4 = s1 + s2;//
        System.out.println(s3 == s4);//false
    }

    /* 1. 字符串拼接操作不一定使用的是StringBuilder!
     *    如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式。
     * 2. 针对于final修饰类、方法、基本数据类型、引用数据类型的量的结构时，能使用上final的时候建议使用上。
     */
    public static void test4() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//true
    }

    public static void test5() {
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = s1 + s2;
        //intern():判断字符串常量池中是否存在javaEEhadoop值，如果存在，则返回常量池中javaEEhadoop的地址；
        //如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回次对象的地址。
        String s5 = s4.intern();
        System.out.println(s3 == s5);//true
    }

    public static void test6() {
        String s1 = "javaEE";
        String s2 = "hadoop";

        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";//编译期优化
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;
        //如果拼接符号的前后出现了变量，则相当于在堆空间中new String()，具体的内容为拼接的结果：javaEEhadoop
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s3 == s7);//false
        System.out.println(s5 == s6);//false
        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false
        //intern():判断字符串常量池中是否存在javaEEhadoop值，如果存在，则返回常量池中javaEEhadoop的地址；
        //如果字符串常量池中不存在javaEEhadoop，则在常量池中加载一份javaEEhadoop，并返回次对象的地址。
        String s8 = s6.intern();
        System.out.println(s3 == s8);//true
    }

    public void test7() {
        long start = System.currentTimeMillis();

        //method1(100000);// 4014ms
        method2(100000);// 7ms

        long end = System.currentTimeMillis();
        System.out.println("花费的时间为：" + (end - start));
    }

    public void method1(int highLevel) {
        String src = "";
        for (int i = 0; i < highLevel; i++) {
            src = src + "a";//每次循环都会创建一个StringBuilder、String
        }
        // System.out.println(src);
    }

    public void method2(int highLevel) {
        //只需要创建一个StringBuilder
        StringBuilder src = new StringBuilder();
        for (int i = 0; i < highLevel; i++) {
            src.append("a");
        }
        // System.out.println(src);
    }


    public static void test8() {
        String s1 = new String("a") + new String("b");
        System.out.println(s1); //false
    }

    private static void test9() {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        String s4 = "11";
        s3.intern();
        System.out.println(s3 == s4); //JDK6:false ; JDK7:false
    }

    private static void test10() {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4); //JDK6:false ; JDK7:true
    }

    private static void test11() {
        String s1 = new String("a") + new String("b");
        String s2 = s1.intern();
        System.out.println(s2 == "ab"); // JDK6:true, JDK7:true
        System.out.println(s1 == "ab"); // JDK6: false; JDK7: true
    }

    private static void test12() {
        String s1 = new String("a") + new String("b");
        String s2 = new String("ab").intern();
        String s3 = s1.intern();
        System.out.println(s2 == s3); //jdk6/7 : true
    }

    private static void test13() {
        String s1 = new String("a") + new String("b");
        String s2 = "ab";
        String s3 = s1.intern();
        System.out.println(s2 == s3);//jdk6/jdk7：true
    }

    private static void test14() {
        String s1 = new String("a") + new String("b");//执行完以后，不会在字符串常量池中会生成"ab"
        String s3 = s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2); //jdk6：false ; JDK7:false
    }

    public static void main(String[] args) {
        //test6();
//        test9();
//        test11();
        test12();
        test13();
//        test14();
//        test10();
//        for (int i = 0; i<1024;  i++) {
//            String s = "i" + i;
//            s.intern();
//        }

//        System.out.println(s.toString().length());
    }

}
