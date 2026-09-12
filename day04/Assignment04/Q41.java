import java.util.*;
class Q41 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many prints do you want : ");
        int p_quan = input.nextInt();

        double price_1 = 30.00;
        double price_2 = 28.00;
        double price_3 = 27.00;
        double price_4 = 26.00;
        double over_price = 25.00;

        if (p_quan >= 0 && p_quan <= 99) {
            System.out.println("Price per copy : Rs." + price_1);
            System.out.println("Total Price : " + (p_quan * price_1));
        } 
        else if (p_quan >= 100 && p_quan <= 499) {
            System.out.println("Price per copy : Rs." + price_2);
            System.out.println("Total Price : " + (p_quan * price_2));
        } 
        else if (p_quan >= 500 && p_quan <= 799) {
            System.out.println("Price per copy : Rs." + price_3);
            System.out.println("Total Price : " + (p_quan * price_3));
        } 
        else if (p_quan >= 800 && p_quan <= 1000) {
            System.out.println("Price per copy : Rs." + price_4);
            System.out.println("Total Price : " + (p_quan * price_4));
        } 
        else {
            System.out.println("Price per copy : Rs." + over_price);
            System.out.println("Total Price : " + (p_quan * over_price));
        }
    }
}
