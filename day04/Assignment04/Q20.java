import java.util.*;
class Q20 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer : ");
		double num = input.nextInt();
		
		if(num<0){
			System.out.println(" Negative integer ");
		
		}else if(num>0){
			System.out.println(" Positive integer ");
		}else{
			System.out.println(" Zero ");
		}
	}
}
