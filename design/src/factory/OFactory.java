package factory;

public class OFactory implements Factory{

    @Override
    public Phone createMobile() {
        return new OPhone();
    }

    @Override
    public Tv createTv() {
        return new OTv();
    }
}
