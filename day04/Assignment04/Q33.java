import java.util.*;
class Q33 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("is employee permanent (Y/N) : ");
        char per_emp = input.next().charAt(0);

        double salary = 0;
        double y_service = 0;
        double bonus_Percentage = 0;

        if (per_emp == 'Y' || per_emp == 'y') {
            System.out.print("Enter your salary: ");
            salary = input.nextDouble();

            System.out.print("Enter your years of service : ");
            y_service = input.nextDouble();

            if (y_service < 5) {
                bonus_Percentage = 0.10;
            } else if (y_service < 10) {
                bonus_Percentage = 0.15;
            } else {
                bonus_Percentage = 0.25;
            }

            double bonus_Amount = salary * bonus_Percentage;
            double t_salary = salary + bonus_Amount;

            System.out.println("Bonus amount: " + bonus_Amount);
            System.out.println("Total salary with bonus: " + t_salary);
        } else {
            System.out.println("Not eligible for bonus (Employee is not permanent).");
        }
    }
}
