import java.util.*;
class Q24 {
	public static void main(String[] args){
		Random r = new Random();
		
		int head_count = 0 ;
		int tail_count = 0 ;
		
		for(int i = 0 ; i<10 ; i++){
		
			boolean ishead = r.nextBoolean();
			
			if(ishead){
				System.out.println("HEAD");
				head_count++;
			}else{
				System.out.println("TAIL");
				tail_count++;
			}
		
		}
		System.out.println("Statistic: "+head_count+" and "+tail_count+" Tails");
	}
}
