package mem;

import java.util.concurrent.atomic.*;

public class AtomApiTest {

    public static void test1() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        atomicBoolean.set(true);
        atomicBoolean.compareAndSet(true, true);

        System.out.println("a = " + atomicBoolean.get());
    }

    public static void test2() {
        AtomicInteger atomicInteger = new AtomicInteger();
        int a = atomicInteger.addAndGet(1);
        System.out.println("a = " + a);
    }


    public static void test3() {
        AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int[]{1, 2});
        int a = atomicIntegerArray.addAndGet(1, 1);
        System.out.println(a);
    }

    public static void test4() {
        AtomicReference<User> userAtomicReference = new AtomicReference<User>();
        User user1 = new User("zxw1", 1);
        userAtomicReference.set(user1);

//        User updateUser = new User("zxw2", 2);
//        userAtomicReference.compareAndSet(user1, updateUser);
//        System.out.println("user = "+userAtomicReference.get().toString());

        UserAtomicReferenceFieldUpdater updater = new UserAtomicReferenceFieldUpdater();
        updater.compareAndSet(user1, 1, 2);

        System.out.println("user = " + updater.get(user1));

        updater.compareAndSet(user1, 2, 3);
        System.out.println("user = " + updater.get(user1));

        AtomicMarkableReference<String> markableReference  = new AtomicMarkableReference<>("hello", true);
        boolean moditify = markableReference.compareAndSet("hi", "hi",true, false);
        System.out.println("moditify = " + moditify + ", ref = " + markableReference.getReference());

        AtomicIntegerFieldUpdater<User> b = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");
        User conan = new User("conan", 10);
        System.out.println("conan = " + b.getAndDecrement(conan));

    }


    private static class UserAtomicReferenceFieldUpdater extends AtomicReferenceFieldUpdater<User, Integer> {
        @Override
        public boolean compareAndSet(User obj, Integer expect, Integer update) {

            if (obj.age == expect) {
                obj.age = update;
                return true;
            }
            return false;
        }

        @Override
        public boolean weakCompareAndSet(User obj, Integer expect, Integer update) {
            return false;
        }

        @Override
        public void set(User obj, Integer newValue) {
            obj.age = newValue;
        }

        @Override
        public void lazySet(User obj, Integer newValue) {

        }

        @Override
        public Integer get(User obj) {
            return obj.getAge();
        }
    }

    private static class User {
        private String name;
        public volatile int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
