package generic;

public class ChildErasure extends Erasure<Integer>{
    @Override
    public Integer getValue() {
        return super.getValue();
    }
}