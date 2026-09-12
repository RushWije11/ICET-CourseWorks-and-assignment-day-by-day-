import java.util.*;
class Q24 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter First Integer Number : ");
		int f_num = input.nextInt();
		
		System.out.print("Enter Second Integer Number : ");
		int s_num = input.nextInt();
		
		System.out.print("Enter Third Integer Number : ");
		int third_num = input.nextInt();
		
		int digit1 = f_num %10 ;
		int digit2 = s_num %10 ;
		int digit3 = third_num %10 ;
		
		if(digit1 == digit2 || digit1 == digit3 || digit2 == digit3 ){
			System.out.println("True");
		}else{
			System.out.println("False");
		}
		
		
	
		
		
		
	}
}
