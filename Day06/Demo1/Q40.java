import java.util.*;
class Q40 {
    public static int absoluteDifference(int a, int b) {
        int diff = a - b;
        if (diff < 0) {
            return -diff;
        }
        return diff;
    }
    public static double absoluteDifference(double a, double b) {
        double diff = a - b;
        if (diff < 0) {
            return -diff;
        }
        return diff;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first integer: ");
        int num1 = input.nextInt();
        System.out.print("Enter second integer: ");
        int num2 = input.nextInt();
        
        int intResult = absoluteDifference(num1, num2);
        System.out.println("Absolute difference of integers: " + intResult);

        System.out.print("Enter first double: ");
        double d1 = input.nextDouble();
        System.out.print("Enter second double: ");
        double d2 = input.nextDouble();

        double doubleResult = absoluteDifference(d1, d2);
        System.out.println("Absolute difference of doubles: " + doubleResult);
    }
}
