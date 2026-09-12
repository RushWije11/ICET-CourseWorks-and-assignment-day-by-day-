import java.util.*;
public class Q25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the tax-inclusive price in dollars: ");
        double inclusive_Price = input.nextDouble();
     
        double actual_Price = inclusive_Price / 1.10;//actual price logic
        double sales_Tax = inclusive_Price - actual_Price;//sales tax logic
 
        System.out.printf("Actual Price is: $%.2f\n", actual_Price);
        System.out.printf("Sales Tax is: $%.2f\n", sales_Tax);

        
    }
}
