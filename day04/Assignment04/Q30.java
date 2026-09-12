import java.util.*;
class Q30 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);
        
        if (ch >= 'a' && ch <= 'z') {
            System.out.println("It is a lowercase letter.");
        } 
        else if (ch >= 'A' && ch <= 'Z') {
            System.out.println("It is an uppercase letter.");
        } 
        else {
            System.out.println("It is not a letter.");
        }
    }
}
