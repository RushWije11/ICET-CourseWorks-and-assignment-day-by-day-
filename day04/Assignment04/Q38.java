import java.util.*;
class Q38 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter attendance percentage: ");
        double attendance = input.nextDouble();

        System.out.print("Enter average marks: ");
        double marks = input.nextDouble();

        if (attendance > 80 && marks > 50) {
            System.out.println("You are eligible to sit for the O/L examination.");
        } else {
            System.out.println("You are not eligible to sit for the O/L examination.");
        }
    }
}
