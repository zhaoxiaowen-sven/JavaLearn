package bean;

import anno.MyAnnotation;

import java.util.List;
import java.util.Map;

public class Person {
    private String name = "default";

    private int age = -1;

    @MyAnnotation(address = "ru")
    private int address;

    static void say(String msg) {
        System.out.println("say = " + msg);
    }

    private Map<String, Person> getMap(List<Person> list, String name) {
        return null;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    private void toast(){
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
