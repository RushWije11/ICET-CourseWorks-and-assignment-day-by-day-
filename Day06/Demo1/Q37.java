import java.util.*;
class Q37 {
    public static void checkTriangle(double x, double y, double z) {
        if ((x + y > z) && (x + z > y) && (y + z > x)) {
            double perimeter = x + y + z;
            System.out.println("Valid triangle. Perimeter: " + perimeter);
        } else {
            System.out.println("Invalid triangle");
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter side x: ");
        double x = input.nextDouble();

        System.out.print("Enter side y: ");
        double y = input.nextDouble();

        System.out.print("Enter side z: ");
        double z = input.nextDouble();

        checkTriangle(x, y, z);
    }
}
