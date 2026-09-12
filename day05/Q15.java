import java.util.*;
class Q15 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input an integer : ");
		int num=input.nextInt();
		int n=0;//no of digits
		for(int i=num;i>0;i/=10){
			int s_num =i%10;
			n+=s_num;
		}
		System.out.println("sum of digits : "+n);
	} 
}
