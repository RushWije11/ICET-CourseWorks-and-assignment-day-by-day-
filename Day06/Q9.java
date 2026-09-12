import java.util.*;
class Q9 {
	public static void  printRound(double a){
		System.out.printf("%.2f \n ",a );
	}
	public static void main(String[] args){
		Scanner input =new Scanner(System.in);
		
		System.out.print("Enter Number : ");
		double num = input.nextDouble();
		printRound(num);
	}
}
