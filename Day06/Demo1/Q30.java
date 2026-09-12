import java.util.*;
class Q30 {
    public static void printOddAndEvenDigits(int number) {
        String oddDigits = "";
        String evenDigits = "";

        int reversed = 0;
        int temp = number;

        if (temp == 0) {
            evenDigits = "0";
        }
        while (temp > 0) {
            int remainder = temp % 10;
            reversed = (reversed * 10) + remainder;
            temp /= 10;
        }
        while (reversed > 0) {
            int digit = reversed % 10;

            if (digit % 2 != 0) {
                oddDigits += digit;
            } else {
                evenDigits += digit;
            }
            reversed /= 10;
        }
        System.out.println(oddDigits + " " + evenDigits);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter positive integer: ");
        int num = input.nextInt();

        printOddAndEvenDigits(num);
    }
}
