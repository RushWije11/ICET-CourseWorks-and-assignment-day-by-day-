import java.util.*;
class Q1 {
	public static void main(String[] args){
	
		Scanner input =new Scanner(System.in);
		
		System.out.print("Input First Number : ");
		int f_num = input.nextInt();
		
		System.out.print("Input Second Number : ");
		int s_num = input.nextInt();
		
		int add  ;
		
		if (f_num>s_num){
			add = f_num + s_num ;
			System.out.println("Addition of Two Numbers : "+add);
		}else{
			System.out.println("First Number  :  "+f_num);
			System.out.println("Second Number : "+s_num);
		}
		
	
	
	}
}
