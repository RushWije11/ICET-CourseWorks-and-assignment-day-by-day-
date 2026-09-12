import java.util.*;
class Q9 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int num = 0 ;
		int count=0;	
		for(int i = 1 ;i<=50;i++){
		
			System.out.print("Enter number"+ i +" : ");
			num =input.nextInt();
			
			if(num>100){
				 count++;
					}
			}	
				System.out.println();
				System.out.println( count +" Numbers are "+"greater that 100 ");
				
	}
}
