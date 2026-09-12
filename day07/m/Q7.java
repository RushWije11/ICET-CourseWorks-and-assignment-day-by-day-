import java.util.*;
class Q7 {
	public static void main(String[] args){
	char[] ar ={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	System.out.println(Arrays.toString(ar)+"\n");
	
		for(int i=0;i<ar.length;i+=2){
			System.out.print(ar[i]+" ");
			
		}
		System.out.println("\n");
		for(int i=1;i<ar.length;i+=2){
			System.out.print(ar[i]+" ");
			
		}
		System.out.println("\n");
		char[] rever=new char[ar.length];
		for(int i=0 ,z=ar.length-1;i<ar.length;i++,z--){
		
			rever[i]=ar[z];
			
		}
		System.out.print(Arrays.toString(rever));
	}
}


