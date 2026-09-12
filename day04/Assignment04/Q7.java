import java.util.*;
class Q7 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		
		System.out.print("Input number 01 : ");
		int num_1 =input.nextInt();
		
		System.out.print("Input number 02 : ");
		int num_2 =input.nextInt();
		
		System.out.print("Input number 03 : ");
		int num_3 =input.nextInt();
		
		int max_num =num_1;
		
		if(num_2>max_num){
			max_num = num_2;
		
		}
		if(num_3>max_num){
		
			max_num = num_3;
		}
	System.out.println("The Maxumum Number is : "+max_num);
	}
}
