import java.util.*;
class Q23 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter First Number  : ");
		int f_num = input.nextInt();
		
		System.out.print("Enter Second Number : ");
		int s_num = input.nextInt();
		
		if(f_num<s_num){
			System.out.println("The first number is less than the second number");
		}else if (f_num>s_num){
			System.out.println("The First number is greater than the second number");
			
		}else{
			System.out.println("Both are equal");
		}
	}
}
