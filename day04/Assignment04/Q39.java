import java.util.*;
class Q39 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter time : ");
        double time = input.nextDouble();
        
		if (time < 0.00 || time > 24.00 || (time % 1) > 0.59) {
            System.out.println("Invalid time entered! Minutes cannot exceed 59.");
        } else if (time >= 00.00 && time <= 12.00) {
            System.out.println("Good morning");
        } else if (time > 12.00 && time <= 16.00) {
            System.out.println("Good afternoon");
        } else if (time > 16.00 && time <= 19.00) {
            System.out.println("Good evening");
        } else if(time > 19.00 && time <= 24.00) {
            System.out.println("Good night");
        }
    }
}
