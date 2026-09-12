import java.util.*;
class Q21 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Number 1 : ");
		int num_1 = input.nextInt();
		
		System.out.print("Enter Number 2 : ");
		int num_2 = input.nextInt();
		
		int absolute_difference ;
		if (num_1>num_2){
			absolute_difference = num_1 - num_2 ;
			
		}else{
			absolute_difference = num_2 - num_1 ;
		}
		System.out.print("Absolute Difference : "+absolute_difference );
	}
}
