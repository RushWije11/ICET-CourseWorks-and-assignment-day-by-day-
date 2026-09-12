import java.util.*;
class Q45 {
    public static String reverseString(String txt) {
        String reversed = "";
        
        for (int i = txt.length() - 1; i >= 0; i--) {
            reversed = reversed + txt.charAt(i);
        }
        return reversed;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a word: ");
        String str = input.nextLine();
		String re_str =reverseString(str);
        System.out.println("Reversed word: " +re_str );
    }
}
