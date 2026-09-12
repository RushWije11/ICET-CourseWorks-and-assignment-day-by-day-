import java.util.*;
class Q30 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Input integer number : ");
        int num = input.nextInt();
        
        int originalNum = num; 
        int reversedNum = 0;   
        
        while(num != 0){
            int digit = num % 10;
            reversedNum = (reversedNum * 10) + digit;
            num /= 10;
        }
        
        if(originalNum == reversedNum) {
            System.out.println(originalNum + " is a Palindrome number.");
        } else {
            System.out.println(originalNum + " is not a Palindrome number.");
        }
    }
}
