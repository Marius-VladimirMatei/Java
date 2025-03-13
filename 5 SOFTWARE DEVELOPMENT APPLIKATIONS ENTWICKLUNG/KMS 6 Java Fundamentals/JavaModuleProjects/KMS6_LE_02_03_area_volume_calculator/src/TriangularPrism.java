
// TriangularPrisma class structure with specific implementation for Volume method
// super keyword - calls the parent in order to bring a Triangle object as a base for volume calculation


public class TriangularPrism extends Solid {
    public TriangularPrism(double side, double height) {
        super(new EquilateralTriangle(side), height);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

}
