package design.state;

public abstract class AccountState {
    protected Account account;
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract void computeInterest();
    public abstract void stateCheck();


}
