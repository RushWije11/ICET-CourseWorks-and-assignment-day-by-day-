import java.util.*;
class Q32 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("When user input - ");
        String text = input.nextLine();
        
        String reversed = "";
        
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }
        
        System.out.println("Reverse word -" + reversed);
        
       
    }
}
