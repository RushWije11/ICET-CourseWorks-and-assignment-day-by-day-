import java.util.*;
class Q3 {
	public static void main(String[] args){
		
		Scanner input =new Scanner(System.in);
		
		System.out.print("Enter Chemistry Marks       : ");
		double chem_marks = input.nextInt();
		
		System.out.print("Enter Physics Marks        : ");
		double physi_marks = input.nextInt();
		
		System.out.print("Enter Combined Maths Marks : ");
		double com_marks = input.nextInt();
		
		double total = chem_marks + physi_marks + com_marks ;
		double average = total/3;
		System.out.println("Total : "+total);
		System.out.println("Average : "+average);
		if(average>75){
			System.out.println("Pass");
		}else{
			System.out.println("Fail");
		}
		
	}
}
