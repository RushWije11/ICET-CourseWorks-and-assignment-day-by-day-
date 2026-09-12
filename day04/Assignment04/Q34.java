import java.util.*;
class Q34 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of books: ");
        int quantity = input.nextInt();

        double subtotal = quantity * 100.0;
        double discount = 0;

        if (subtotal > 5000) {
            discount = subtotal * 0.10;
        }

        double total = subtotal - discount;

        System.out.println("Subtotal : " + subtotal);
        if (subtotal > 5000) {
            System.out.println("Discount : " + discount);
        } else {
            System.out.println("Discount :      -");
        }
        System.out.println("TOTAL    : " + total);
    }
}
