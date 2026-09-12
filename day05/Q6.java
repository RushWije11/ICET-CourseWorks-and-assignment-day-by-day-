import java.util.*;
class Q6 {
	public static void main(String[] args){
		Random ran = new Random();
		
		for(int i = 0;i<=50;i++){
			int rand = ran.nextInt(100)+1;
			if(rand%2==1){
			System.out.println(rand);
			}
		}
	}
}
