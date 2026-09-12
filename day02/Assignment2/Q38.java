import java.util.Scanner;
class Q38{
		public static void main(String args[]){
			Scanner input = new Scanner(System.in);
			System.out.print("Enter your friends name: ");
			String name = input.next();
			input.nextLine();
			
			System.out.print("Enter your friend's age: ");
			String age = input.nextLine();
			
			System.out.print("Enter your friend's living place: ");
			String place = input.nextLine();
			
			System.out.print(name+" is my best friend. He is "+age+" years old and lives in the beautiful town of "+place+".");
			
			
			
		}
}
