package factory;

public class VivoFactory implements Factory{
    @Override
    public Phone createMobile() {
        return new VivoPhone();
    }

    @Override
    public Tv createTv() {
        return new VivoTv();
    }
}
