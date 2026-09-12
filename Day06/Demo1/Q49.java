import java.util.*;
class Q49 {
	public static void tryguessing(int ra_num){
		Scanner input=new Scanner(System.in);
		
		for(int i=1;i<=5;i++){
			System.out.print("Enter your guessing number : ");
			int num0 = input.nextInt();
			if(num0==ra_num){	
				System.out.println("Your Guessing is correct.");
			}else{
				if(num0 > ra_num){
					System.out.println("Too high, try again.");
				}else{
					System.out.println("Too low, try again.");
				}
			}
        }
        System.out.println("Maximum attempts exceeded ");
	}
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		Random r = new Random();
		
		int r_num = r.nextInt(100)+1;
		
		tryguessing(r_num);
	}
}
