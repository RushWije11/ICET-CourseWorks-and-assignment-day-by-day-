import java.util.*;
class Q48{
	public static int sumOfDigits(int num){
		int sum=0;
		while(num!=0){
			sum+=num%10;
			num/=10;
		}
		return sum;
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		System.out.print("Input an integer : ");
		int num=input.nextInt();
				
		int sum=sumOfDigits(num);
		System.out.println("Sum of digits for "+num+" : "+sum);
	} 
}

