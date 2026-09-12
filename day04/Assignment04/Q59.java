import java.util.*;
class Q59 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter R values (0 to 255): ");
        int r = input.nextInt();
        System.out.print("Enter G values (0 to 255): ");
        int g = input.nextInt();
        System.out.print("Enter B values (0 to 255): ");
        int b = input.nextInt();

        double c, m, y, k;

        if (r == 0 && g == 0 && b == 0) {
            c = 0.0;
            m = 0.0;
            y = 0.0;
            k = 1.0;
        } else {
            double rPrime = r / 255.0;
            double gPrime = g / 255.0;
            double bPrime = b / 255.0;

            double w = Math.max(rPrime, Math.max(gPrime, bPrime));

            c = (w - rPrime) / w;
            m = (w - gPrime) / w;
            y = (w - bPrime) / w;
            k = 1 - w;
        }
        System.out.printf("Cyan = %.5f \n",c);
        System.out.printf("Magenta =%.5f \n",m);
        System.out.printf("Yellow = %.5f \n", y);
        System.out.printf("black = %.5f \n",k);
    }
}
