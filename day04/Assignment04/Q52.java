import java.util.*;
class Q52 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter x coordinate: ");
        double x = input.nextDouble();

        System.out.print("Enter y coordinate: ");
        double y = input.nextDouble();

        if (x > 0 && y > 0) {
            System.out.println("The point lies in Quadrant I");
        } 
        else if (x < 0 && y > 0) {
            System.out.println("The point lies in Quadrant II");
        } 
        else if (x < 0 && y < 0) {
            System.out.println("The point lies in Quadrant III");
        } 
        else if (x > 0 && y < 0) {
            System.out.println("The point lies in Quadrant IV");
        } 
        else if (x == 0 && y == 0) {
            System.out.println("The point lies at the Origin");
        } 
        else if (x == 0) {
            System.out.println("The point lies on the Y-axis");
        } 
        else {
            System.out.println("The point lies on the X-axis");
        }
    }
}
