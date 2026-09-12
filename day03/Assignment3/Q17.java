import java.util.*;
class Q17 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter The Total Amount of Purchase : ");
		double total = input.nextDouble();
		
		//logic part
		
		double import_tax = total * 0.15 ;
		double final_price = total + import_tax ;
		
		System.out.println("Price: After adding Import tax : "+final_price );
	}
}
