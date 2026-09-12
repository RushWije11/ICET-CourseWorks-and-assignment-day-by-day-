import java.util.*;
class Q53 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter Systolic Blood Pressure (SBP): ");
        int sbp = input.nextInt();

        System.out.print("Enter Diastolic Blood Pressure (DBP): ");
        int dbp = input.nextInt();

        if (sbp >= 130 && dbp >= 90) {
            System.out.println("Status: High Pressure");
        } 
        else if (sbp <= 100 && dbp <= 70) {
            System.out.println("Status: Low Pressure");
        } 
        else if (sbp >= 100 && sbp <= 130 && dbp >= 70 && dbp <= 90) {
            System.out.println("Status: Normal");
        }
    }
}
