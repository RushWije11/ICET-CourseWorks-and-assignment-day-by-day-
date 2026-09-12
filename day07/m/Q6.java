import java.util.*;
class  Q6 {
	public static void main(String[] args){
		String days[]={"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		
		System.out.print(Arrays.toString(days));
		
		System.out.println("\n");
		System.out.print("[");
		for(int i = days.length - 1; i >=0; i--) {
            System.out.print(days[i]+" ");
            if(i>0){
				System.out.print(",");
            }
            
        }
        System.out.print("]");
	}
}
