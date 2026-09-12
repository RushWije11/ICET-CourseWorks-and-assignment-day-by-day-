import java.util.*;
class Q38 {
    public static void main(String[] args) {
        int x = 1;
        while (true) {
            if (hasSameDigits(x, 2 * x) &&
                hasSameDigits(x, 3 * x) &&
                hasSameDigits(x, 4 * x) &&
                hasSameDigits(x, 5 * x) &&
                hasSameDigits(x, 6 * x)) {
                
                System.out.println("Smallest integer x: " + x);
                break;
            }
            x++;
        }
    }
    public static boolean hasSameDigits(int n1, int n2) {
        char[] a1 = String.valueOf(n1).toCharArray();
        char[] a2 = String.valueOf(n2).toCharArray();
        Arrays.sort(a1);
        Arrays.sort(a2);
        return Arrays.equals(a1, a2);
    }
}
