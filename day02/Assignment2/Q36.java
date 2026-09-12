import java.util.Scanner;
class Q36{
		public static void main(String args[]){
			Scanner input = new Scanner(System.in);
			System.out.print("Whats your name : ");
			String name = input.next();//i use the next method because i wanted to get first name only
			input.nextLine();
			
			System.out.print("Hello "+ name+","+" "+"nice to meet you!");
		}
}
