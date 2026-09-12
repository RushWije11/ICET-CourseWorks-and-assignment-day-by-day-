import java.util.*;
class Q27 {
	public static boolean countEvenDigit(int x){ 
		while (x > 0) {
            int digit = x % 10;    
            if (digit % 2 != 0) {    
                return false;  
            }  
            x = x/ 10;   
        }
       return true;              
    }
	public static void main(){
	Scanner input=new Scanner(System.in);
		
		System.out.print("Enter integer number : ");
		int num = input.nextInt();
		
		boolean alleven= countEvenDigit(num);
		System.out.println(alleven);
		
		
	}
}
