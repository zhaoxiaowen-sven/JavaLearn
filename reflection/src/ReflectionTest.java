import anno.MyAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        // class 的对象
//        System.out.println(Class.class.hashCode());
//
//        // 1.类名.class 获取class对象
//        System.out.println(Person.class.hashCode());
//
//        // 2.对象.getClass 获取class对象
//        Person p = new Person();
//        System.out.println(p.getClass().hashCode());
//
//        // 3.Class.forName 获取class对象
//        Class<?> c = Class.forName("bean.Person");
//        System.out.println(c.hashCode());

        // 1.Class.newInstance 方式
//        Class<?> c2 = Class.forName("bean.Person");
//        Person p2 = (Person) c2.newInstance();
//        System.out.println(p2);
//
//        // 2.构造函数Constructor 方式，注意基本类型参数的类型 int -> Integer.TYPE
//        Constructor<?> constructor = c2.getDeclaredConstructor(String.class, Integer.TYPE);
//        Person p3 = (Person) constructor.newInstance( "user", 10);
//        System.out.println(p3);

        // 操作方法
        // 1.获取class对象
//        Class<?> c2 = Class.forName("bean.Person");
//        // 2.创建实例
//        Person p = (Person) c2.newInstance();
//        // 3.获取方法
//        Method m1 = c2.getDeclaredMethod("setAge", Integer.TYPE);
//        // 4.调用
//        m1.invoke(p, 100);
//        System.out.println(p);

        // 操作属性
//        Class<?> c3 = Class.forName("bean.Person");
//        // 2.创建实例
//        Person p2 = (Person) c3.newInstance();
//        // 3.获取filed 对象
//        Field f =  c3.getDeclaredField("name");
//        // 4.关闭访问安全检查
//        f.setAccessible(true);
//
//        System.out.println("set前 = " + f.get(p2));
//        // 5.操作属性
//        f.set(p2, "usernew");
//
//        System.out.println("set后= " + f.get(p2));


//        Class<?> c4 = Class.forName("bean.Person");
//        Method[] methods1 = c4.getDeclaredMethods();
//        Method[] methods2 = c4.getMethods();
//
//        for (Method m : methods1) {
//            System.out.println("method = " + m);
//        }
//        System.out.println("========");
//        for (Method m : methods2) {
//            System.out.println("DeclaredMethod = " + m);
//        }

//        Class<?> c5 = Class.forName("bean.Person");
//        Method method = c5.getDeclaredMethod("say", String.class);
//        // 必须
//        method.setAccessible(true);
//        // object 可以传空
//        method.invoke(null, "hello");

//        Class<?> c6 = Class.forName("bean.Person");
//        Method method = c6.getDeclaredMethod("getMap", List.class, String.class);
//        Type[] pType = method.getGenericParameterTypes();
//        for (Type type : pType) {
//            System.out.println("参数类型是 ：type1 = " + type);
//            if (type instanceof ParameterizedType) {
//                Type[] p = ((ParameterizedType) type).getActualTypeArguments();
//                for (Type t : p) {
//                    System.out.println("参数类型是 ：type2 = " + t);
//                }
//            }
//        }
//
//        System.out.println("======分割线======");
//
//        Type rType = method.getGenericReturnType();
//        System.out.println("返回类型是 ：type1 = " + rType);
//        if (rType instanceof ParameterizedType) {
//            Type[] p = ((ParameterizedType) rType).getActualTypeArguments();
//            for (Type t : p) {
//                System.out.println("返回类型是 ：type2 = " + t);
//            }
//        }
//    }
        Class<?> c6 = Class.forName("bean.Person");
        Constructor<?> c= c6.getConstructor();
        Field f = c6.getDeclaredField("address");
        MyAnnotation annotation = f.getAnnotation(MyAnnotation.class);
        System.out.println(annotation.address());

    }
}
