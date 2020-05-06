package builder.base2;

public class AngelBuilder extends ActorBuilder {

    private static String TAG = "angel_";

    public void buildName(String name) {
        actor.name = TAG + name;
    }

    public void buildAge(String age) {
        actor.age = TAG + age;
    }

    public void buildFace(String face) {
        actor.face = TAG + face;
    }
}
