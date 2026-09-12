import java.util.*;
class Q12 {
	public static double markTotal=0;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		double ar[]= new double[9];
		
		for(int i=0;i<ar.length;i++){
		
			System.out.print("Enter Student Subject "+(i+1)+" marks : ");
			ar[i]=input.nextDouble();
		}
		for(int i =0;i<ar.length;i++){
			markTotal+=ar[i];
		}	
		System.out.println("The total mark of the student         : "+markTotal);
		System.out.printf("The average mark of the student       : %.2f",(markTotal/ar.length));
		System.out.println();
		double max = 0;
		double min = ar[0];
		for(int i=1;i<ar.length;i++){
			if(ar[i]<=min){
				min=ar[i];
			}
		}
		System.out.println("The minimum mark of the student       : "+min);
		for(int i=0;i<ar.length;i++){
			if(ar[i]>=max){
				max=ar[i];
			}
		}
		System.out.println("The maximum mark of the student       : "+max);
		int count_g=0;
		for(int i =0;i<ar.length;i++){
		
			if(ar[i]>75){
				count_g++;
			}
		}
		System.out.println("How many marks are greater than 75    : "+count_g);
		int count_l=0;
		for(int i =0;i<ar.length;i++){
		
			if(ar[i]<45){
				count_l++;
			}
		}
		System.out.println("How many marks are less than 45       : "+count_l);
		boolean found_100=false;
			for(int i=0;i<ar.length;i++){
				if(ar[i]==100){
					found_100=true;
					break;
			}
			
		}
		System.out.println("Is number ‘5’ are rolled : "+(found_100? "Yes":"No"));
	}
}
