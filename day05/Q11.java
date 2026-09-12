import java.util.*;
class Q11 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double hei_total = 0;
		double wei_total = 0;
		double avg_hei = 0;
		double avg_wei = 0;
		
		for(int i = 1;i<=100;i++){
			System.out.println("Enter "+i+" student \n ");
		
			System.out.print("      height :");
			double stu_hei = input.nextInt();
		
			System.out.print("      weight :");
			double stu_wei = input.nextInt();
		
			System.out.println("\n");
		
			hei_total +=stu_hei;
			wei_total +=stu_wei; 
		
			avg_hei = hei_total /100;
			avg_wei = wei_total /100;
					
		}
			System.out.print("Average Height : "+avg_hei);
			System.out.print("\n");
			System.out.print("Average Weight : "+avg_wei);
	}
}
