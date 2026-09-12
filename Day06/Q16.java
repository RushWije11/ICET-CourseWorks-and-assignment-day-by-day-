import java.util.*;
class Q16 {
	public static void printperfect(){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Number : ");
		int num = input.nextInt();
		
		if(num<=0){
			System.out.println("Error");
		}else{
		
		int sum = 0;
		
		for(int i = 1;i<num;i++){
			if(num%i==0){
				sum+=i;
			}
		}
			if(sum==num){
				System.out.println(num+" is a Perfect Number.");
			}else{
				System.out.println(num+" is not a Perfect Number.");
		}
		}
	}
	public static void main(String[] args){
		printperfect();
	}
}
