import java.util.*;
class Q21 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("How many eggs do you have : ");
		int total_eggs = input.nextInt();
		
		int gross = total_eggs / 144 ;
		int remain_gross = total_eggs % 144 ;
		
		int dozen = remain_gross / 12 ;
		int extra = remain_gross % 12 ;
		
		System.out.println("Your number of eggs in "+gross+" gross"+" and "+dozen+" dozen, and "+extra);
		
		
	}
}
