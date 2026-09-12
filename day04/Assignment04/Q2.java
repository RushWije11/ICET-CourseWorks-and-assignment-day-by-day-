import java.util.*;
class Q2 {
	public static void main(String[] args){
		
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter Number : ");
		int number =input.nextInt();
		int abs;
		if (number<0){
			abs= -number;
			System.out.println("Absolute : "+abs);
		}else{
			abs = number ;
			System.out.println("Absolute : "+abs);
		
		}
		
	}
}
