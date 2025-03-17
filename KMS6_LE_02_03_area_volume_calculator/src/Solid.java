// Abstract class tho define the logic for 3D shapes

public abstract class Solid {
    public BaseShape base;
    public double height;

    public Solid(BaseShape base, double height) {
        this.base = base;
        this.height = height;
    }

    public double getBaseArea() {
        return base.getArea();
    }

    public abstract double getVolume();
}
