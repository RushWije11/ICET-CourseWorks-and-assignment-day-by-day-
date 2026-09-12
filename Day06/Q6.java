import java.util.*;
class Q6 {
	public static void integerCompare(){ 
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input Number 1 - ");
		int num1 =input.nextInt();
		
		System.out.print("Input Number 2 - ");
		int num2 =input.nextInt();
		
		if(num1==num2){
			System.out.println("num1==num2 : "+num1+" = "+num2);
		}else if(num1>num2){
			System.out.println("--> "+num1+" > "+num2);
		}else{
			System.out.println("--> "+num1+" < "+num2);
		}
		
	}
	public static void main(String[] args){
		integerCompare();
	}
}
