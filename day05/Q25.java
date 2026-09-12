import java.util.*;
class Q25 {
	public static void main(String[] args){
		Random r = new Random();
		
		for(int i = 0 ;i<5;i++){
			int diceroll = r.nextInt(6)+1;
			System.out.print(diceroll+" ");
		}
	}
}


