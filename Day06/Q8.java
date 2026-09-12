import java.util.*;
class Q8 {
	public static void checkFirstLetter() {
		Scanner input = new Scanner(System.in);

		System.out.print("Enter first word: ");
		String word1 = input.next();

		System.out.print("Enter second word: ");
		String word2 = input.next();

        char first1 = word1.charAt(0);
        char first2 = word2.charAt(0);

        if (first1 == first2 || first1 == first2 + 32 || first1 == first2 - 32) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    public static void main(String[] args) {
        checkFirstLetter();
    }
}
