import java.util.*;
public class Q60 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter parcel weight in kg: ");
        double weight_val = input.nextDouble();

        double totalCharge = 0;

        if (weight_val <= 5) {
            totalCharge = 500;
        } else {
            double ex_Weight = weight_val - 5;
            totalCharge = 500 + (ex_Weight * 100);
        }

        System.out.println("Total courier charge: Rs. " + totalCharge);
    }
}
