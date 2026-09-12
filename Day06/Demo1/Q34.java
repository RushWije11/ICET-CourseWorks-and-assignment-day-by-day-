import java.util.*;
class Q34 {

    public static long factorial(int num) {
        long fact = 1;
        for (int i = 1; i <= num; i++) {
            fact *= i;
        }
        return fact;
    }
    public static long calculateGroups(int n, int r) {
        if (r > n || n < 0 || r < 0) {
            return 0;
        }
        long nFactorial = factorial(n);
        long rFactorial = factorial(r);
        long nMinusRFactorial = factorial(n - r);

        return nFactorial / (nMinusRFactorial * rFactorial);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Number of children - ");
        int n = input.nextInt();

        System.out.print("Number of group members - ");
        int r = input.nextInt();

        long result = calculateGroups(n, r);
        System.out.println("The number of groups = " + result);
    }
}
