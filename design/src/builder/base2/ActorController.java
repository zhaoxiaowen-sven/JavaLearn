package builder.base2;

public class ActorController {

    public Actor construct(ActorBuilder actorBuilder){
        actorBuilder.buildName("name");
        actorBuilder.buildAge("age");
        actorBuilder.buildFace("face");
        return  actorBuilder.build();
    }
}
