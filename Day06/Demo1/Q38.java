import java.util.*;
class Q38 {
    public static void findCoordinates(double xA, double yA, double xB, double yB, double lambda, double mu) {
        double xC = (lambda * xB + mu * xA) / (lambda + mu);
        double yC = (lambda * yB + mu * yA) / (lambda + mu);
        
        System.out.println("Coordinates of C:");
        System.out.println("Xc: " + xC);
        System.out.println("Yc: " + yC);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter XA: ");
        double xA = input.nextDouble();

        System.out.print("Enter YA: ");
        double yA = input.nextDouble();

        System.out.print("Enter XB: ");
        double xB = input.nextDouble();

        System.out.print("Enter YB: ");
        double yB = input.nextDouble();

        System.out.print("Enter lambda (λ): ");
        double lambda = input.nextDouble();

        System.out.print("Enter mu (μ): ");
        double mu = input.nextDouble();

        findCoordinates(xA, yA, xB, yB, lambda, mu);
    }
}
