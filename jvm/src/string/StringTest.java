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
        String s1 = "abc";
        String s2 = s1.replace("a", "m");
        System.out.println(s1 == s2);
    }

    public static void test4() {
        String s1 = "a" + "b" + "c"; //编译器优化
        String s2 = "abc"; // 常量池

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

    public static void test5() {
        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;

        System.out.println(s3 == s4);
    }

    //  1. 字符串拼接操作不一定使用的是StringBuilder!
//       如果拼接符号左右两边都是字符串常量或常量引用，则仍然使用编译期优化，即非StringBuilder的方式。
    public void test7() {
        final String s1 = "a";
        final String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;
        System.out.println(s3 == s4);//true
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


    public static void test10() {
//        String s1 = new String("ab");//执行完以后，会在字符串常量池中会生成"ab"
        String s1 = new String("a") + new String("b");////执行完以后，不会在字符串常量池中会生成"ab"
        s1.intern();
        String s2 = "ab";
        System.out.println(s1 == s2); //false
    }


    public static void main(String[] args) {
        test10();
//        for (int i = 0; i<1024;  i++) {
//            String s = "i" + i;
//            s.intern();
//        }

//        System.out.println(s.toString().length());
    }

}
