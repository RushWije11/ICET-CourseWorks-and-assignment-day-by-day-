import java.util.*;
class Q53 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base: ");
        int base = scanner.nextInt();
        
        System.out.print("Enter exponent: ");
        int exponent = scanner.nextInt();
        
        long result = 1;
        int i = 0;
        
        while (i < exponent) {
            result *= base;
            i++;
        }
        
        System.out.println("Result: " + result);
    }
}
