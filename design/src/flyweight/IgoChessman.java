package flyweight;

public abstract class IgoChessman {
    abstract int getColor();

    public void display(Coordinates coordinates) {
        System.out.println(this.getColor() + " x = " + coordinates.getX() + ", y = " + coordinates.getY());
    }
}
