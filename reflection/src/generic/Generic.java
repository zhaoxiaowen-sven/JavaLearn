package generic;

public class Generic<T> {
    //key这个成员变量的类型为T,T的类型由外部指定
    private T key;

    public Generic(T key) { //泛型构造方法形参key的类型也为T，T的类型由外部指定
        this.key = key;
    }

    /**
     * 虽然在方法中使用了泛型，但是这并不是一个泛型方法。
     * 这只是类中一个普通的成员方法，只不过他的返回值是在声明泛型类已经声明过的泛型。
     * 所以在这个方法中才可以继续使用 T 这个泛型
     */
    public T getKey() {
        return key;
    }


    /**
     * 这才是一个真正的泛型方法。
     * 首先在public与返回值之间的<T>必不可少，这表明这是一个泛型方法，并且声明了一个泛型T
     * 这个T可以出现在这个泛型方法的任意位置.
     * 泛型的数量也可以为任意多个
     */
    public <T> void showKeyName(T name) {
        System.out.println(name);
    }


    /**
     * 这个方法是有问题的，编译器会为我们提示错误信息："UnKnown class 'E' "
     * 虽然我们声明了<T>,也表明了这是一个可以处理泛型的类型的泛型方法。
     * 但是只声明了泛型类型T，并未声明泛型类型E，因此编译器并不知道该如何处理E这个类型。
     **/
//    public <T> T showKeyName(Generic<E> container){
//     ...
//    }

    /**
     * 这个方法也是有问题的，编译器会为我们提示错误信息："UnKnown class 'T' "
     * 对于编译器来说T这个类型并未项目中声明过，因此编译也不知道该如何编译这个类。
     * 所以这也不是一个正确的泛型方法声明。
     */
//
//    public void showkey(T genericObj) {
//
//    }

    // 静态的泛型方法
    public static <T, E> void showType(T t, E e) {
        System.out.println("T = " + t.getClass() + ", E = " + e.getClass());
    }

    // 5.静态方法中不能使用类的泛型
    // 无法从静态上下文中引用非静态 类型变量 T
//    public static void showType(T t) {
//        System.out.println("T = " + t.getClass());
//    }

    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试 t is " + t);
        }
    }

}