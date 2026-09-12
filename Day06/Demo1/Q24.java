import java.util.*;
class Q24 {
	public static double tankCapacity(double radius,double height){
		double conv_Radius = radius*100;
		double conv_Height = height*100;
		
		double capacity_valu = (3.14*conv_Radius*conv_Radius)*conv_Height/1000;
		
		return capacity_valu;
	}
	public static void main(){
	Scanner input =new Scanner(System.in);
		
		System.out.print("Enter Radius in Meter (m) : ");
		double r_valu = input.nextDouble();
		System.out.print("Enter Heigth in Meter (m) : ");
		double h_valu = input.nextDouble();
		
		double c_valu=tankCapacity(r_valu,h_valu);
		System.out.printf("Tank Capactiy : %.2f L",c_valu);
	}
}
