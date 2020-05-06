package builder.base2;

public class Actor {
    public String name;
    public String age;
    public String face;

    @Override
    public String toString() {
        return "Actor{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", face='" + face + '\'' +
                '}';
    }
}
