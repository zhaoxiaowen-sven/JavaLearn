package design.strategy;

public class Context {
    private AbstractStrategy strategy;
    public void setStrategy(AbstractStrategy strategy) {
        this.strategy= strategy;
    }
    //调用策略类中的算法
    public void algorithm() {
        strategy.algorithm();
    }
}
