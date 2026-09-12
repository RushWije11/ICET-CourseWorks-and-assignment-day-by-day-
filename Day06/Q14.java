import java.util.*;
class calculator {
	public static void add(int a,int b){
		System.out.println(a +" + "+b+" = "+(a+b));
	}
	public static void subtraction(){
	
	}
	public static void multiplication(){
	
	}
	public static void dividend(){
	
	}
	public static void reminder(){
	
	}
	public static void power(){
	
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter the first number  : ");
		int num1 =input.nextInt();
		
		System.out.print("Enter the second number : ");
		int num2 =input.nextInt();
		
		System.out.print("Enter the operator (+,-,*,/,%,^) : ");
		char operator = input.next().charAt(0);
		
		switch(operator) {
			case '+':
				add(num1,num2);
				break;
		}
	}
}
