import java.util.*;
class Q12 {
	public static void getcalculate(){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter angle (in degrees) : ");
		double angle_value =input.nextDouble();
		
		System.out.print("Enter radius (cm)        : ");
		double radius =input.nextDouble();
		double 	arc_length =(angle_value/360)*(2*(3.14*radius));
		double perimeter = arc_length+(2*radius);
		double area_sector = (angle_value/360)*(3.14*radius*radius);
		 
		 System.out.printf("Perimeter         : %.2f \n",perimeter);
		  System.out.printf("Area of a sector  : %.2f \n",area_sector);
	}
	public static void main(String[] args){
		
		getcalculate();
		
	}
}
