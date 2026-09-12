import java.util.*;
class Q34 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String str_text = input.nextLine();
        
        System.out.print("Enter the character to search: ");
        char ser_charac = input.next().charAt(0);
        
        int count = 0;
        
        for (int i = 0; i < str_text.length(); i++) {
            if (str_text.charAt(i) == ser_charac) {
                count++;
            }
        }
        
        System.out.println("The character '" + ser_charac + "' appears " + count + " times.");
    }
}
