import java.util.*;
class Q31 {
	public static void printRolled(){
		Random r =new Random();
		int num1=r.nextInt(6)+1;
		int num2=r.nextInt(6)+1;
		int count = 0;
		while(num1!=num2){
			num1 = r.nextInt(6)+1;
		    num2 = r.nextInt(6)+1;
			System.out.println(num1+" "+num2);
			count++;
		}
		System.out.println("Dice roll - "+count+" times");
	}
	public static void main(String[] args){
		printRolled();
	}
}
