import java.util.*;
class Q46 {
    public static void printGeometricSeries(long a, long r) {
        long currentTerm = a;
        
        for (int i = 1; i <= 10; i++) {
            System.out.print(currentTerm + " ");
            currentTerm = currentTerm * r;
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 1st term (a): ");
        long a = input.nextLong();

        System.out.print("Enter common ratio (r): ");
        long r = input.nextLong();

        System.out.println("First 10 terms of the geometric series:");
        
        printGeometricSeries(a, r);
    }
}
