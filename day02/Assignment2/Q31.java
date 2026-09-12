import java.util.*;
class Q31 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Combined Maths - ");
		int c_marks = input.nextInt();
		System.out.println();
		
		System.out.print("chemistry      - ");
		int chem_marks = input.nextInt();
		System.out.println();
		
		System.out.print("Physics        - ");
		int phy_marks = input.nextInt();
		System.out.println();
		
		System.out.print("English        - ");
		int e_marks = input.nextInt();
		System.out.println();
		
		int total_sum = c_marks + chem_marks + phy_marks + e_marks;
		System.out.println("Total          - " + total_sum);		
	}
}
