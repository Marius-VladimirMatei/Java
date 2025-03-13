
// Cylinder class structure with specific implementation for Volume method
// super keyword - calls the parent in order to bring a Circle object as a base for volume calculation


public class Cylinder extends Solid {
    public Cylinder(double radius, double height) {
        super(new Circle(radius), height);
    }

    @Override
    public double getVolume() {
        return getBaseArea() * height;
    }

}
