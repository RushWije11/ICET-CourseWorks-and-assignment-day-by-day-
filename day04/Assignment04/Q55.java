import java.util.*;
class Q55 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number to check: ");
        double number = input.nextDouble();

        System.out.print("Enter the lower bound: ");
        double lowerBound = input.nextDouble();

        System.out.print("Enter the upper bound: ");
        double upperBound = input.nextDouble();

        if (number >= lowerBound && number <= upperBound) {
            System.out.println("The number is within the given range.");
        } else {
            System.out.println("The number is outside the given range.");
        }
    }
}
