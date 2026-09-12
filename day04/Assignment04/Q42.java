import java.util.*;
class Q42 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your waist size in inches: ");
        int size = input.nextInt();

        if (size >= 28 && size <= 29) {
            System.out.println("Your size is: X-small (XS)");
        } 
        else if (size >= 30 && size <= 31) {
            System.out.println("Your size is: Small (S)");
        } 
        else if (size >= 32 && size <= 34) {
            System.out.println("Your size is: Medium (M)");
        } 
        else if (size >= 36 && size <= 38) {
            System.out.println("Your size is: Large (L)");
        } 
        else if (size >= 40 && size <= 42) {
            System.out.println("Your size is: X-Large (XL)");
        } 
        else {
            System.out.println("Size not available in the chart!");
        }
    }
}
