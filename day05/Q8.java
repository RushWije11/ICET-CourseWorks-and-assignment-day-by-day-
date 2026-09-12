import java.util.*;
class Q8 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter number : ");
		long num1 = input.nextInt();
		
		long x ;
		long factorial = 1;
		for(x=num1;x>0;x--){
			factorial*=x;
		}
		System.out.print("Factorial of "+ num1 +" ! "+" = "+ factorial);
	}
}
