import java.util.*;
class Q11 {
	public static void getconvert(double c_val){
		
		double f_val = (c_val*9/5)+32;
		double k_val = c_val+273.15;
		
		System.out.println("Convertion of Celsioud into Fahrenheit(0F) : "+f_val);
		System.out.println("Convertion of Celsioud into Kelvin(0K) : "+k_val);
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter Celsins Value(0C) : ");
		double c_val = input.nextDouble();
			
			getconvert(c_val);
	}
}
