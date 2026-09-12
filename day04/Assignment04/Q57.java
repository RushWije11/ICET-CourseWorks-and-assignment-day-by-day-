import java.util.*;
class Q57 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int month_1 = 0, day_1 = 0, year_1 = 0;
        int month_2 = 0, day_2 = 0, year_2 = 0;

        System.out.println("Enter Date 1:");
        System.out.print("Month (1-12): ");
        month_1 = input.nextInt();
        System.out.print("Day (1-31): ");
        day_1 = input.nextInt();
        System.out.print("Year: ");
        year_1 = input.nextInt();

        System.out.println("\nEnter Date 2:");
        System.out.print("Month (1-12): ");
        month_2 = input.nextInt();
        System.out.print("Day (1-31): ");
        day_2 = input.nextInt();
        System.out.print("Year: ");
        year_2 = input.nextInt();

        if (year_1 < year_2) {
            System.out.println("\nDate 1 comes first.");
        }
        if (year_2 < year_1) {
            System.out.println("\nDate 2 comes first.");
        }
        if (year_1 == year_2) {
            if (month_1 < month_2) {
                System.out.println("\nDate 1 comes first.");
            }
            if (month_2 < month_1) {
                System.out.println("\nDate 2 comes first.");
            }
            if (month_1 == month_2) {
                if (day_1 < day_2) {
                    System.out.println("\nDate 1 comes first.");
                }
                if (day_2 < day_1) {
                    System.out.println("\nDate 2 comes first.");
                }
                if (day_1 == day_2) {
                    System.out.println("\nBoth dates are the same.");
                }
            }
        }
    }
}
