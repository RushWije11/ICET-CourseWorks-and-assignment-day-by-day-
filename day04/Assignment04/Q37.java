import java.util.*;
class Q37 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter current annual salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter performance rating (1=excellent, 2=good, 3=poor): ");
        int rating = input.nextInt();

        double raisePercentage = 0;

        if (rating == 1) {
            raisePercentage = 0.06;
        } else if (rating == 2) {
            raisePercentage = 0.04;
        } else if (rating == 3) {
            raisePercentage = 0.015;
        }

        double raiseAmount = salary * raisePercentage;
        double newSalary = salary + raiseAmount;

        System.out.println("Raise amount: " + raiseAmount);
        System.out.println("New salary: " + newSalary);
    }
}
