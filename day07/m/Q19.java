import java.util.*;
class Q19 {
	public static void main(String[] args){
		int[] num=new int[50];
		Random r=new Random();
		
		for(int i=0;i<num.length;i++){
			num[i]=r.nextInt(20)-5;
		}
		System.out.println(Arrays.toString(num));
		System.out.println("\n");
		for(int i=0,j=num.length-1; i<j; i++,j--){
			int t=num[i];
			num[i]=num[j];
			num[j]=t;
			
		}
		System.out.println(Arrays.toString(num));
		System.out.println("\n");
		 int coun_neg=0;
		for(int i=0;i<num.length;i++){
			if(num[i]<0){
				coun_neg++;
			}
		}
		double probabil =(double)coun_neg/num.length;
		System.out.printf("The probability of getting negative numbers as Random numbers : %.3f",probabil);
	}
}
