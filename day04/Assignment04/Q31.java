import java.util.*;
class Q31 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = input.nextInt();

        if (num % 7 == 0 || num % 10 == 7) {
            System.out.println("It is a Buzz Number.");
        } else {
            System.out.println("It is not a Buzz Number.");
        }
    }
}
