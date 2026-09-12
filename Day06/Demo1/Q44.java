import java.util.*;
class Q44 {
    public static int findFactorial(int val) {
        int fact = 1;
        
        for (int i = 1; i <= val; i++) {
            fact = fact * i;
        }
        return fact;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int num = scan.nextInt();
		int re_fact = findFactorial(num);
        System.out.println("Factorial: " +re_fact);
    }
}
