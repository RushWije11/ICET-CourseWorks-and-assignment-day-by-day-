import java.util.*;
class Q28 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input integer number : ");
		int num = input.nextInt();
		
		while(num!=0){
			System.out.print(num%10);
			num/=10;
		
		}
	}
}	
