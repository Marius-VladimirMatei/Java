
// Circle class structure with specific implementation for Area method


public class Circle extends BaseShape {
    private double radius;

    // Constructor for Circle objects
    public Circle(double radius) {
        this.radius = radius;
    }

    // the getArea method will override the SuperClass (ParentClass) method with its specific implementation
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }
}
