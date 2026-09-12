import java.util.*;
class Q8 {
	public static void main(String[] args){
		int districts[]={2346, 1945, 2060, 1781, 2365, 1005, 1162, 1016, 1512, 2231, 1903, 12061, 1005, 1545,
		2156, 2037, 1583, 3668};
		
		System.out.println("Number of Districts : "+districts.length);
		int morethan_count =0;
		int lessthan_count =0;
		for(int i=0;i<districts.length;i++){
			if(districts[i]>2000){
				morethan_count++;
			}
			
		}
		System.out.println("Nmbers of districts with more than 2000mm of annual rainfall : "+morethan_count);
		
		for(int i=0;i<districts.length;i++){
			if(districts[i]<1000){
				lessthan_count++;
			}
			
		}
		System.out.println("Nmbers of districts with less than 1000mm of annual rainfall : "+lessthan_count);
		int sum=0;
		for(int i=0;i<districts.length;i++){
			sum=sum+districts[i];
		}
		 double rain_avg =(double)sum/districts.length;
		System.out.printf("The average annual rainfall values of all districs : %.2f",rain_avg);
	}
}
