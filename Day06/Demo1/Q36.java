import java.util.*;
class Q36 {
    public static void checkQuadrant(double x, double y) {
        if (x < -5 || x > 5 || y < -5 || y > 5) {
            System.out.println("Error: Coordinates must be between -5 and 5 as shown in the grid.");
            return;
        }
        if (x > 0 && y > 0) {
            System.out.println("Quadrant I");
        } else if (x < 0 && y > 0) {
            System.out.println("Quadrant II");
        } else if (x < 0 && y < 0) {
            System.out.println("Quadrant III");
        } else if (x > 0 && y < 0) {
            System.out.println("Quadrant IV");
        } else {
            System.out.println("Origin");
        } 
        double sumOfSquares = (x * x) + (y * y);
        System.out.println("Distance: " + sumOfSquares);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter x coordinate between (-5 to 5): ");
        double x = input.nextDouble();
        System.out.print("Enter y coordinate (-5 to 5): ");
        double y = input.nextDouble();

        checkQuadrant(x, y);
    }
}
