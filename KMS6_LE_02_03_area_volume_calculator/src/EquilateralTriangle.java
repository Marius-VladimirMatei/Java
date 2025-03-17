
// Equilateral triangle class structure with specific implementation for Area method

public class EquilateralTriangle extends BaseShape{
    private double side;

    // Constructor for E_Triangle objects
    public EquilateralTriangle(double side) {
        this.side = side;
    }

    // the getArea method will override the SuperClass (ParentClass) method with its specific implementation
    @Override
    public double getArea() {
        return ((Math.sqrt(3) / 4) * side * side);
    }
}
