import java.util.*;
class Q35 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base number: ");
        int base = input.nextInt();
        
        System.out.print("Enter exponent number: ");
        int exponent = input.nextInt();
        
        long result = 1;
        
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }
        
        System.out.println("Result: " + result);
    }
}
