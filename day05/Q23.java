import java.util.*;
class Q23 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int less_count = 0 ;
		int greater_count =0;
		
		for(int i = 1;;){
			while(true){
				System.out.print("Enter "+i+" integer number : ");	
				double num = input.nextInt();
				if(num==-1){
					break;
				}
				if(num<1000){
					less_count++;
				}else if(num>1000){
					greater_count++;	
				}
				i++;
			}
			System.out.println(less_count+" numbers are less than 1000");
			System.out.println(greater_count+" numbers are greater than 1000");
		}
		
		
	}
}
