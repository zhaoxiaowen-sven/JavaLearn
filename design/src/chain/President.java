package chain;

public class President extends Approver {
    public President(String name) {
        super(name);
    }

    @Override
    public void processRequest(PurchaseRequest request) {
        if (request.getAmount()< 5000){
            System.out.println("President " + name + request.getAmount());
        } else {
            approver.processRequest(request);
        }
    }
}
