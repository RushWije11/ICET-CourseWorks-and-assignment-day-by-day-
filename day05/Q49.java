import java.util.*;
class Q49 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        
        int o_num = num;
        int sum = 0;
        
        while (num > 0) {
            int digit = num % 10; 
            sum += (digit * digit * digit); 
            num /= 10; 
        }
        if (sum == o_num) {
            System.out.println(o_num + " is an Armstrong number.");
        } else {
            System.out.println(o_num + " is not an Armstrong number.");
        }
    }
}
