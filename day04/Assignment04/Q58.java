import java.util.*;
class Q58 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter year: ");
        int y = input.nextInt();

        System.out.print("Enter month: ");
        int m = input.nextInt();

        System.out.print("Enter day: ");
        int d = input.nextInt();

        int y_cal = y - ((14 - m)) / 12;
        int x = y_cal + y_cal / 4 - y_cal / 100 + y_cal / 400;
        int m_cal = m + 12 * ((14 - m) / 12) - 2;
        int d_cal = (d + x + (31 * m_cal) / 12) % 7;

        if (d_cal == 0) {
            System.out.println("Day of the week: Sunday");
        }
        if (d_cal == 1) {
            System.out.println("Day of the week: Monday");
        }
        if (d_cal == 2) {
            System.out.println("Day of the week: Tuesday");
        }
        if (d_cal == 3) {
            System.out.println("Day of the week: Wednesday");
        }
        if (d_cal == 4) {
            System.out.println("Day of the week: Thursday");
        }
        if (d_cal == 5) {
            System.out.println("Day of the week: Friday");
        }
        if (d_cal == 6) {
            System.out.println("Day of the week: Saturday");
        }
    }
}
