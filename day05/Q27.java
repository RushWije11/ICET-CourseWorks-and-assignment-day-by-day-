import java.util.*;
class Q27 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input an integer : ");
		int n=input.nextInt();
		int n_digi=0;
		for(int i=n;i>0;i/=10){
			int s_num =i%10;
			n_digi+=s_num;
		}
		System.out.println("sum of digits : "+n_digi);
	} 
}

