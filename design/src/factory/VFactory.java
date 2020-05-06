package factory;

public class VFactory implements Factory{
    @Override
    public Phone createMobile() {
        return new VPhone();
    }

    @Override
    public Tv createTv() {
        return new VTv();
    }
}
