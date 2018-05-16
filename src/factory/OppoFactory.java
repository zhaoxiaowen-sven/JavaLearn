package factory;

public class OppoFactory implements Factory{

    @Override
    public Phone createMobile() {
        return new OppoPhone();
    }

    @Override
    public Tv createTv() {
        return new OppoTv();
    }
}
