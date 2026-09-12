import java.util.*;
class Q46 {
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		Random r = new Random();
		
		int r_num = r.nextInt(100)+1;
		int num = -1; 
        
        while (num != r_num) {
            System.out.print("Enter your guessing number : ");
            num = input.nextInt();
            
            if(num > r_num){
                System.out.println("Too high, try again.");
            } else if(num < r_num){
                System.out.println("Too low, try again.");
            } else {
                System.out.println("Your Guessing is correct.");
            }
        }
	}
}
