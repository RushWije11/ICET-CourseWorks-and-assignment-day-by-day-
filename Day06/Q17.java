import java.util.*;
class Q17 {
	public static void checkRange(){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter number : ");
		int num = input.nextInt();
		System.out.print("The lower bound of the range : ");
		int lower_bound=input.nextInt();
		System.out.print("The upper bound of the range : ");
		int upper_bound=input.nextInt();
		int count =0;
		for(int i=lower_bound+1;i<upper_bound;i++){
			if(i%num==0){
				count++;
			}	
		}
		System.out.println("Multiples of "+num+" between "+lower_bound+" and "+upper_bound+" - "+count);
	}
	public static void main(String[] args){
		checkRange();
	}
}
