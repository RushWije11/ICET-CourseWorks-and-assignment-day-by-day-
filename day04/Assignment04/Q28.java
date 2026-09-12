import java.util.Scanner;
class Q28 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter your age    : ");
        int age = input.nextInt();

        System.out.print("Enter your weight : ");
        double weight = input.nextDouble();
        
        if (age > 18 && weight >= 50) {
            System.out.println("You are eligible to donate blood.");
        } else {
            System.out.println("You are not eligible to donate blood.");
        }
    }
}
