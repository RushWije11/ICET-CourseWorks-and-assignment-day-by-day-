import java.util.*;
class Q5 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Unit Price : ");
		double unit_price = input.nextDouble();
		
		System.out.print("Enter Amount : ");
		int amount = input.nextInt();
		
		double total = unit_price*amount; 
		double discount;
		double ne_total;
		if(total>500){
			discount = total*0.05;
			ne_total = total-discount;
			System.out.printf("New price (5%%) : %.2f \n",ne_total);
		
		}else{
			System.out.println("No discount give");
		}
		
	}
}
