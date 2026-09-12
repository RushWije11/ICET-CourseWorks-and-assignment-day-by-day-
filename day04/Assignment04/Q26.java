import java.util.*;
class Q26 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the selling price :  ");
		double sell_price =input.nextDouble();
		
		System.out.print("Enter cost of product :  ");
		double  cost=input.nextDouble();
		
		if(sell_price > cost){
			System.out.println("Profit");
		}else if (sell_price< cost){
			System.out.println("loss");
		}else{
			System.out.println("No Profit No loss");
		}
	}
}
