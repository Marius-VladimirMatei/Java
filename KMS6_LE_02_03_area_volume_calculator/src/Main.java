import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select packaging type");
        System.out.println("1. Cuboid (Rectangular Prism)");
        System.out.println("2. Triangular Prism");
        System.out.println("3. Cylinder");
        int choice = scanner.nextInt();

        Solid solid = null;

        switch (choice) {
            case 1:
                System.out.println("Enter the length of the base rectangle: ");
                double length = scanner.nextDouble();

                System.out.println("Enter the width oif the base rectangle: ");
                double width = scanner.nextDouble();

                System.out.println("Enter the height of the cuboid");
                double cuboidHeight = scanner.nextDouble();

                solid = new Cuboid(length, width, cuboidHeight);
                break;

            case 2:
                System.out.println("Enter the side length of the base equilateral triangle: ");
                double side = scanner.nextDouble();

                System.out.println("Enter the height of the base triangular prism: ");
                double prismHeight = scanner.nextDouble();

                solid = new TriangularPrism(side, prismHeight);
                break;

            case 3:
                System.out.println("Enter the radius of the base circle: ");
                double radius = scanner.nextDouble();

                System.out.println("Enter the height of the cylinder: ");
                double cylinderHeight = scanner.nextDouble();

                solid = new Cylinder(radius, cylinderHeight);
                break;

            default:
                System.out.println("Invalid choice. Exit");
                System.exit(0);

        }

        System.out.printf("Base Area: %.2f%n", solid.getBaseArea());
        System.out.printf("Volume: %.2f%n", solid.getVolume());

        scanner.close();

    }

}
