import java.util.*;
class Q14 {
	public static void main(String[] args){
		Random r = new Random();
		int[] ar= new int[20];
		
		for(int i=0;i<ar.length;i++){
			ar[i]= r.nextInt(101);
			
		}
		System.out.println(Arrays.toString(ar));
		int pass_count=0;
		for(int i=0;i<ar.length;i++){
			if(ar[i]>50){
				pass_count++;
			}
		}
		System.out.println("\n");
		System.out.println("How many students pass the assignmen : "+pass_count);
		
		boolean found90=false;
		for(int i=0;i<ar.length;i++){
			if(ar[i]>90){
				found90=true;
				break;
			}
		}
		System.out.println("Are there student with more than 90 : "+(found90 ? "Yes":"No"));
	}
}
