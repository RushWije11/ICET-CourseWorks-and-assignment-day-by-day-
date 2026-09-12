import java.util.*;
class Q13 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter Dividend : ");
        double dividend = input.nextDouble();
        
        System.out.println();
        
        System.out.print("Enter Divisor  : ");
        double divisor = input.nextDouble();
        
        int quotient = (int) (dividend / divisor);
        double remainder = dividend % divisor;
        
        System.out.println("Quotient  : " + quotient);
        System.out.printf("Remainder : %.2f\n" , remainder);
        
        input.close();
    }
}
