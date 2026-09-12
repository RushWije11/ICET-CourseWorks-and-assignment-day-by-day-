import java.util.*;
class Q15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter radius: ");
		double radius = input.nextDouble();
		System.out.println();
		
        double area = 3.14 * radius * radius;
        double perimeter = 2 * 3.14 * radius;

        System.out.println("Area      = "+ area );
        System.out.println("Perimeter = "+ perimeter);
	}
}
