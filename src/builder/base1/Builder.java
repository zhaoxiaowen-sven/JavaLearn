package builder.base1;

public class Builder {
    Product product = new Product();
    public void buildPartA(){
        product.partA = "partA";
    }
    public void buildPartB(){
        product.partB = "partB";
    }
    public void buildPartC(){
        product.partC = "partC";
    }

    public Product getProduct() {
        return product;
    }
}
