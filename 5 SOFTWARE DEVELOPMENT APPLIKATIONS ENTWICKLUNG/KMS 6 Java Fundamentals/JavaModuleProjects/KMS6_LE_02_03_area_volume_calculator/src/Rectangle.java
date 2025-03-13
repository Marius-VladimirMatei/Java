
// Rectangle class structure with specific implementation for Area method

public class Rectangle extends BaseShape {
    private double length;
    private double width;

    // Constructor for Rectangle objects
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // the getArea method will override the SuperClass (ParentClass) method with its specific implementation
    @Override
    public double getArea() {
        return length * width;
    }
}
