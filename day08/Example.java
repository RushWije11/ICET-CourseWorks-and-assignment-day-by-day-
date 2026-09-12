import java.util.*;
class Example{
	public static int[] ar={100,90,80,70,60,50,40,30,20,10};
	public static void sortArray(){
		for(int i=ar.length-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(ar[j]>ar[j+1]){
					int temp=ar[j];
					ar[j]=ar[j+1];
					ar[j+1]=temp;
				}
				System.out.println(Arrays.toString(ar));
				try{Thread.sleep(500);}catch(Exception ex){}
			}
		}
	}
	public static void main(String args[]){	
		System.out.println(Arrays.toString(ar));//[100,90,80,70,60,50,40,30,20,10]
		sortArray();
		System.out.println(Arrays.toString(ar));//[10,20,30,40,50,60,70,80,90,100]
	}
}





