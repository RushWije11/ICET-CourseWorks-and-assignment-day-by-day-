import java.util.*;
class Q46 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number (a): ");
        int a = input.nextInt();

        System.out.print("Enter second number (b): ");
        int b = input.nextInt();

        System.out.print("Enter third number (c): ");
        int c = input.nextInt();

        if ((a * a) + (b * b) == (c * c) || (a * a) + (c * c) == (b * b) || (b * b) + (c * c) == (a * a)) {
            System.out.println("They form a Pythagorean triple.");
        } else {
            System.out.println("They do not form a Pythagorean triple.");
        }
    }
}
