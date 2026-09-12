import java.util.*;
class Q6 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		
		System.out.print("Enter a Random Year : ");
		int y_num = input.nextInt();
		
		if(y_num%4 == 0 && y_num % 100 !=0 || (y_num % 400 ==0 )){
			System.out.println("It is a leap Year ");
		
		}else{
		
			System.out.println("It is not a leap Year ");
		}
		
		
	}
}
