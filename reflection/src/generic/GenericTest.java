package generic;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {

    public static void main(String[] args) {
//        List arrayList = new ArrayList();
//        arrayList.add("aaaa");
//        arrayList.add(100);
//
//        for (int i = 0; i < arrayList.size(); i++) {
//            String item = (String) arrayList.get(i);
//            System.out.println("泛型测试 item = " + item);
//        }
//
//        // 1.泛型的类型参数只能是类类型（包括自定义类），不能是基本类型
//        Generic<Integer> genericInteger = new Generic<Integer>(123456);
//        Generic<String> genericString = new Generic<String>("key_value");
//        System.out.println("泛型测试 key is " + genericInteger.getKey());
//        System.out.println("泛型测试 key is " + genericString.getKey());
//
//
//        // 2.如果操作时没有指定具体的数据类型，操作类型是`Object`
//        Generic generic = new Generic("key");
//        Object object = generic.getKey();
//        System.out.println(object);
//
//        // 3.泛型类型在逻辑上可以看成是多个不同类型，但实际上都是相同类型
//        System.out.println(genericInteger.getClass());
//        System.out.println(genericString.getClass());
//
////         4.不能对确切的泛型类型使用instanceof操作。如下面的操作是非法的，编译时会出错。
//        if (genericInteger instanceof Generic<Integer>) {
//
//        }
//
////         泛型类的泛型 和 泛型方法的泛型虽然申明都是 T，但是没有任何关系
//        Generic<Integer> integerGeneric = new Generic<>(1);
//        integerGeneric.showKeyName("myname");
//
//        Generic<Number> generic = new Generic<>(1);
//        Generic<Integer> integerGeneric = new Generic<>(2);
//
//        showKeyValue1(generic);
//        // 编译不过
//        // 报错：不兼容的类型: Generic<java.lang.Integer>无法转换为Generic<java.lang.Number>
////         showKeyValue1(integerGeneric);
//
//        showKeyValue2(generic);
//        showKeyValue2(integerGeneric);
//
//        showKeyValue3(generic);
//        showKeyValue3(integerGeneric);
//
//        List<Integer> integerlist = new ArrayList<>();
//        add(integerlist);
//
//
//        List<Cat> cats = new ArrayList<>();
//        List<MiniCat> miniCats = new ArrayList<>();
//        superAdd(cats);
//        // 报错：
//        // 不兼容的类型: java.util.List<Demo.MiniCat>无法转换为java.util.List<? super Demo.Cat>
//        superAdd(miniCats);
//
//        List<String> stringArrayList = new ArrayList<String>();
//        List<Integer> integerArrayList = new ArrayList<Integer>();
//
//        Class classStringArrayList = stringArrayList.getClass();
//        Class classIntegerArrayList = integerArrayList.getClass();
//
//        if (classStringArrayList.equals(classIntegerArrayList)) {
//            System.out.println("类型相同 = " + stringArrayList.getClass().getSimpleName());
//        }
//        Erasure<Integer> integerErasure = new Erasure<>();
//        Class<?> cls = integerErasure.getClass();
//        Field[] fields = cls.getDeclaredFields();
//        for (Field field : fields) {
//            System.out.println("无限制类型擦除：" + field.getType().getSimpleName());
//        }
//
//        Erasure2<Number> numberErasure = new Erasure2<>();
//        Class<?> cls2 = numberErasure.getClass();
//        Field[] fields2 = cls2.getDeclaredFields();
//        for (Field field : fields2) {
//            System.out.println("有限制类型擦除：" + field.getType().getSimpleName());
//        }
//
//        Erasure<? super Integer> numberErasure3 = new Erasure<>();
//        Class<?> cls3 = numberErasure3.getClass();
//        Field[] fields3 = cls3.getDeclaredFields();
//        for (Field field : fields3) {
//            System.out.println("有限制类型擦除：" + field.getType().getSimpleName());
//        }
//
//                Subtype st1 = new Subtype(), st2 = new Subtype(), st3 = new Subtype();
//        st1.set(st2);
//        st2.set(st3);
//        Subtype st4 = st1.get().get();
//        st1.f();
//
//        A a = new A();
//        a.set(new A());
//        System.out.println(a.get().getClass().getSimpleName());
//        C c = new C();
//        c = c.setAndGet(new C());
//        System.out.println(c.getClass().getSimpleName());
//
//
//        A a2 = new A();
//        System.out.println(f(a2).getClass().getSimpleName());
//
//        ArrayList[] ls = new ArrayList[10];
//        // 引用指向String
//        ArrayList<String>[] listArray = ls;
//        ArrayList<Integer> listInt = new ArrayList<>();
//        listInt.add(100);
//        ls[0] = listInt;
//        // 运行报错，java.lang.ClassCastException:
//        // java.lang.Integer cannot be cast to java.lang.String
//        String s= (String)listArray[0].get(0);
//        System.out.println(s);
//
//
//        ArrayList<String>[] listArray = new ArrayList[10];
//        ArrayList<Integer> listInt = new ArrayList<>();
//        listInt.add(100);
//        // 编译报错
//        //listArray[0] = listInt;
//        String s= listArray[0].get(0);
//        System.out.println(s);
//
//        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Correct.
//        Integer i = (Integer) lsa[1].get(0); // OK

        Fruit<String> fruit = new Fruit<>(String.class, 5);
        fruit.put("apple", 0);
        fruit.put("banana", 1);
        System.out.println(fruit.get(1));
    }

    class Child8 extends Generic<Integer> {
        public Child8(Integer key) {
            super(key);
        }

        @Override
        public Integer getKey() {
            return super.getKey();
        }
    }


//    static void put(List<?> list) {
//    }

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i = 0; i < src.size(); i++)
            dest.set(i, src.get(i));
    }

    static class Animal {
    }

    static class BigCat extends Animal {
    }

    static class Cat extends BigCat {
    }

    static class MiniCat extends Cat {
    }

    public static void add(List<? extends Number> list) {
        // 可以获取
        Number number = list.get(0);
        // 添加报错,原因：
        // 申明时这里的范围是, [-∞, Number], 假设传入的是List<Integer>,
        // 如果允许添加元素, 那么当我们添加的是Double或者其他 非Integer的子类 就会产生异常
        // list.add(1.0)
    }

    //
    public static void superAdd(List<? super Cat> list) {
        // [Number, +∞], 上限是 无穷大,所get的得到的对象是 Object 类型
        Object cat = list.get(0);
        // 添加注意，不能添加 Cat 的父类
        // 假设我们的集合传入的是 List<Cat>, 如果我们允许添加 父类的话，
        // 我们不能确定 ？ 代表的是到底是 Animal 还是 BigCat，
        // list.add(new Animal()); // 报错
        list.add(new Cat());
        list.add(new MiniCat());
    }

    public static void showKeyValue3(Generic<? extends Number> obj) {
        // 注意此时我们获取到的类型是父类型 Number
        Number key = obj.getKey();
        System.out.println("泛型测试 key value is " + key);
    }

    public static void showKeyValue2(Generic<?> obj) {
        Object key = obj.getKey();
        System.out.println("泛型测试 key value is " + key);
    }

    public static void showKeyValue1(Generic<Number> obj) {
        System.out.println("泛型测试 key value is " + obj.getKey());
    }


    class ChildGeneric1<T> extends Generic<T> {
        public ChildGeneric1(T key) {
            super(key);
        }
    }

    class ChildGeneric2 extends Generic<String> {
        public ChildGeneric2(String key) {
            super(key);
        }
    }

    class Parent<T, E> {
        private T t;
        private E e;

        public T getKey() {
            return t;
        }

        public E getValue() {
            return e;
        }
    }

    // 1.全部擦除（子类不是泛型类）
    class Child1 extends Parent {
    }

    // 2.全部擦除 + 扩展
    class Child2<A, B> extends Parent {
    }

    // 3.全部保留
    class Child3<T, E> extends Parent<T, E> {
    }

    // 4.全部保留 + 扩展
    class Child4<T, E, K> extends Parent<T, E> {
    }

    // 5.全部指定（子类不是泛型类）
    class Child5 extends Parent<String, Integer> {
    }

    // 6.指定 + 部分保留
    class Child6<E> extends Parent<String, E> {
    }

    // 7.指定 + 保留 + 扩展
    class Child7<T, K> extends Parent<T, String> {
    }


    static <T extends SelfBounded<T>> T f(T arg) {
        return arg.set(arg).get();
    }
}

class Fruit<T> {
    // 报错
//   private T[] array = new T[3];
    private final T[] array;

    public Fruit(Class<T> clz, int len) {
        array = (T[]) Array.newInstance(clz, len);
    }

    public void put(T t, int index) {
        array[index] = t;
    }

    public T get(int index) {
        return array[index];
    }
}

//自限定类型的标准用法
class SelfBounded<T extends SelfBounded<T>> {
    //所有
    T element;

    SelfBounded<T> set(T arg) {
        element = arg;
        return this;
    }

    T get() {
        return element;
    }
}

// 1.一般用法
class A extends SelfBounded<A> {
}

// 2.编译ok，B继承SelfBounded时，给定的具体类型A确实满足了边界。不过B对象没有自限定的效果了
class B extends SelfBounded<A> {
} // It's OK.

// 3.在自己新增的成员方法里，去调用继承来的成员方法。注意，继承来的方法被限定类型为C即自身了，这就是自限定的效果
class C extends SelfBounded<C> {
    C setAndGet(C arg) {
        set(arg);
        return get();
    }
}

// 4. D 没有 extend SelfBounded<D>,导致E会报错
// [Compile error]: Type parameter D is not within its bound
class D {
}
// class E extends SelfBounded<D> {}

//5.编译 ok，但是失去了限定的作用
class F extends SelfBounded {
}

class BasicHolder<T> {
    T element;

    void set(T arg) {
        element = arg;
    }

    T get() {
        return element;
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

class Subtype extends BasicHolder<Subtype> {
}
