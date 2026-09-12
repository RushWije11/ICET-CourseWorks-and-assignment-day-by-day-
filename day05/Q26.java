import java.util.*;
class Q26 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		System.out.print("What number do you expect : ");
		int num = input.nextInt();
		
		
		int r_rolled;
		do{
			r_rolled = r.nextInt(6)+1;
			System.out.println(r_rolled);
		}while(r_rolled!=num);
		
		
		
	}
}
