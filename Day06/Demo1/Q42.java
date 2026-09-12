import java.util.*;
class Q42 {
    public static boolean isPalindrome(int val) {
        int original = val;
        int flipped = 0;
        while (val > 0) {
            int rem = val % 10;
            flipped = (flipped * 10) + rem;
            val = val / 10;
        }
        return original == flipped;
    }
    public static boolean isPalindrome(String txt) {
        String reversed = "";
        
        for (int i = txt.length() - 1; i >= 0; i--) {
            reversed = reversed + txt.charAt(i);
        }

        return txt.equals(reversed);
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter an integer number: ");
        int num = scan.nextInt();
        System.out.println("Is number palindrome? : " + isPalindrome(num));

        System.out.println();

        System.out.print("Enter a word: ");
        String str = scan.next();
        System.out.println("Is word palindrome? : " + isPalindrome(str));
    }
}
