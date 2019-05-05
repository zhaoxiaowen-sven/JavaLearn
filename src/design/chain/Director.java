package design.chain;

public class Director extends Approver {
    public Director(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount() < 1000){
            System.out.println("Director " + name + request.getAmount());
        } else {
            approver.processRequest(request);
        }
    }
}
