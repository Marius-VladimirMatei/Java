
// Cuboid class structure with specific implementation for Volume method
// super keyword - calls the parent in order to bring a Rectangle object as a base for volume calculation

public class Cuboid  extends Solid {
    public Cuboid(double length, double width, double height) {
        super(new Rectangle(length, width), height);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }
}
