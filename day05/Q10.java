import java.util.*;
class Q10 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int total = 0;
		int max = 0 ;
		int min = 0 ;
		
		for(int i = 1; i<=10;i++){
		
			System.out.print("Enter "+i+" Subject Marks : ");
			int num = input.nextInt();
			total+=num;
				if(i==1){
					max=num ;
					min=num ;
				}else{	
			
					if(max>num){
					max=num ;
					}
					if (min<num){
					min=num ;
					}
					
			}
		}
		double average = total/10;
		System.out.println("Total : " + total );
		System.out.println("Max   : " + max);
		System.out.println("Min   : " + min);
		System.out.println("Average : "+ average);
	}
}
