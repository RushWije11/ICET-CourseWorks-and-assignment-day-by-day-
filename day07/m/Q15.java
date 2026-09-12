import java.util.*;
class Q15 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		Random num = new Random();
		System.out.print("Enter The size of array : ");
		int size=input.nextInt();
		
		int[] ar= new int[size];
		for(int i=0;i<ar.length;i++){
			ar[i]=num.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(ar));
		
		int odd_count=0;
		for(int i=0;i<ar.length;i++){
			if(i%2==1){
				if(ar[i]%2==1){
					odd_count++;
				}
			}	
		}
		System.out.println("Count of how many odd numbers are in the odd index of array : "+odd_count);
		boolean found100 =false;
		for(int i=0;i<ar.length;i++){
			if(ar[i]==100){
				found100=true;
				break;
			}
		}
		System.out.println("The number 100 is present in the array : "+(found100 ? "Yes":"No"));
		
		int max=0;
		int min=ar[0];
		
		for(int i=0;i<ar.length;i++){
			if(ar[i]>max){
				max=ar[i];
			}
		}
		System.out.println("The maximum number of array : "+max);
		
		for(int i=1;i<ar.length;i++){
			if(ar[i]<=min){
				min=ar[i];
			}
		}
		System.out.println("The minimum number of array : "+min);
	}
}
