import java.util.*;
class Q44 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number from 1 to 28 : ");
        int day = input.nextInt();

        if (day == 1 || day == 8 || day == 15 || day == 22) {
            System.out.println("Tuesday");
        } 
        else if (day == 2 || day == 9 || day == 16 || day == 23) {
            System.out.println("Wednesday");
        } 
        else if (day == 3 || day == 10 || day == 17 || day == 24) {
            System.out.println("Thursday");
        } 
        else if (day == 4 || day == 11 || day == 18 || day == 25) {
            System.out.println("Friday");
        } 
        else if (day == 5 || day == 12 || day == 19 || day == 26) {
            System.out.println("Saturday");
        } 
        else if (day == 6 || day == 13 || day == 20 || day == 27) {
            System.out.println("Sunday");
        } 
        else if (day == 7 || day == 14 || day == 21 || day == 28) {
            System.out.println("Monday");
        } 
        else {
            System.out.println("Invalid number! Please enter between 1 and 28.");
        }
    }
}
