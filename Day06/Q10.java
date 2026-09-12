import java.util.*;
class Q10 {
	public static void getrequired(){
		Scanner input =new Scanner(System.in);
		
		System.out.print("Enter desired monthly interest - Rs.");
		double m_interest = input.nextDouble();
		
	
		double annual_interest =m_interest*12;
		double annualrate = 0.2;
		double required_deposite = annual_interest/annualrate;
		System.out.printf("Required deposit amount : Rs.%.2f ",required_deposite);
	}
	public static void main(String[] args){
		getrequired();
	}
}
