import java.util.*;
class Example{
	public static void incrementData(int a, int b, int c){
		a++;
		b++;
		c++;
	}
	public static void incrementData(int[] ar){
		ar[0]++;	
		ar[1]++;	
		ar[2]++;	
	}
	public static void main(String args[]){
		int[] ar={100,200,300};
		System.out.println(ar[0]+" "+ar[1]+" "+ar[2]); //100 200 300
		
		incrementData(ar[0],ar[1],ar[2]); //call by values
		System.out.println(ar[0]+" "+ar[1]+" "+ar[2]); //100 200 300
		
		incrementData(ar); //call by reference
		System.out.println(ar[0]+" "+ar[1]+" "+ar[2]); //101 201 301
	}
}

