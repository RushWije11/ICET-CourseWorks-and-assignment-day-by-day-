import java.util.*;
class Q52 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter words: ");
        String input_num = scanner.nextLine();
        
        int count = 0;
        int i = 0;
        
        while (i < input_num.length()) {
            char ch = input_num.charAt(i);
            
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
				ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                count++;
            }
            
            i++;
        }
        
        System.out.println("Number of vowels: " + count);
        
    }
}
