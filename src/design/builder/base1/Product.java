package design.builder.base1;

public class Product {

    public String partA;
    public String partB;
    public String partC;

    @Override
    public String toString() {
        return "Product{" +
                "partA='" + partA + '\'' +
                ", partB='" + partB + '\'' +
                ", partC='" + partC + '\'' +
                '}';
    }
}
