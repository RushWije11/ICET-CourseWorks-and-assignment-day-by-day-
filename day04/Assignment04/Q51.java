import java.util.*;
class Q51 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = input.nextInt();

        if (age > 65) {
            System.out.println("Classification: Senior");
        } 
        else if (age > 20 && age <= 65) {
            System.out.println("Classification: Adult");
        } 
        else if (age > 13 && age <= 20) {
            System.out.println("Classification: Teenager");
        } 
        else if (age > 1 && age <= 13) {
            System.out.println("Classification: Child");
        } 
        else if (age <= 1 && age >= 0) {
            System.out.println("Classification: Infant");
        } 
        else {
            System.out.println("Invalid age entered!");
        }
    }
}
