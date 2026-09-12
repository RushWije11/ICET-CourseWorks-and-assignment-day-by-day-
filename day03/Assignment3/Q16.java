import java.util.*;//before get scanner method. use this java library to get methods
class Q16 {
	public static void main(String[] args){
		//we use scanner method to get input method into our program
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Product Price : ");
		double price = input.nextDouble();
		
		double discount =price * 0.05 ;
		double discount_price = price - discount ;
		System.out.printf("Price : After Adding 5%% Discount : %.2f\n",discount_price );
		
		
		
	}
}
