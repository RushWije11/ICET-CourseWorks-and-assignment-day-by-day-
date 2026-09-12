import java.util.*;
class Q32 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter total number of classes held: ");
        double Classes = input.nextDouble();

        System.out.print("Enter number of classes attended: ");
        double attended_Classes = input.nextDouble();

       
        double attendance_Percentage = (attended_Classes / Classes) * 100;
        System.out.println("Attendance Percentage: " + attendance_Percentage + "%");

       
        if (attendance_Percentage >= 70) {
            System.out.println("You are allowed to sit for the exam.");
        } else {
            System.out.print("Do you have a medical cause? (Y/N): ");
            char medical = input.next().charAt(0);

            if (medical == 'Y' || medical == 'y') {
                System.out.println("You are allowed to sit for the exam due to medical causes.");
            } else {
                System.out.println("You are not allowed to sit for the exam.");
            }
        }
    }
}
