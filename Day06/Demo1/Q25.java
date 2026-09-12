import java.util.*;
class Q25 {
	public static void getvalues(){
		Scanner input =new Scanner(System.in);
		
		System.out.print("Enter cube length (cm) : ");
		double length =input.nextDouble();
		
		double radius = length/2;
		double volume = 4/3*(3.14*radius*radius);
		
		System.out.printf("Volume of the largest sphere : %.2f cubic units ",volume);
	}
	public static void main(){
		getvalues();
	}
}
