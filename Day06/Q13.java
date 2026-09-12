import java.util.*;
class Q13 {
	public static void findquadratic(){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter first integer for x(a) : ");
		int num1 = input.nextInt();
		
		System.out.print("Enter second integer for x(b) : ");
		int num2 = input.nextInt();
		int sum = num1+num2;
		int multipli = num1*num1; 
		System.out.println("x^2 + "+sum+"x +"+multipli+ " = 0");
		
	}
	public static void main(String[] args){
		findquadratic();
	}
}
