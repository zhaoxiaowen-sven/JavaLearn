package design.builder.base2;

public abstract class ActorBuilder {

    Actor actor = new Actor();

    public abstract void buildName(String name);

    public abstract void buildAge(String age);

    public abstract void buildFace(String face);

    public Actor build() {
        return actor;
    }

}
