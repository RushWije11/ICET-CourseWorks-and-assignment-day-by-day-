import java.util.*;
class Q4 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Unit Price : ");
		double uni_price = input.nextDouble();
		
		System.out.print("Enter Amount : ");
		int amount = input.nextInt();
		
		double total = uni_price*amount;
		
		if(total>1500){
			System.out.println("You are entitled to the super draw");
		
		}else{
			System.out.println("Try again ");
		}
	}
}
