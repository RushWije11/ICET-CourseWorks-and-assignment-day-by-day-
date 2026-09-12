import java.util.*;
class Q47 {
	public static void power(int a,int b){
		int power_0 = (int)Math.pow(a,b);
		System.out.println("Result : "+power_0);
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter base number      : ");
		int num1 = input.nextInt();
		
		System.out.print("Enter exponent (power) : ");
		int num2 = input.nextInt();
		
		power(num1,num2);
	}
}
