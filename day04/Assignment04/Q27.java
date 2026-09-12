import java.util.*;
class Q27 {
		public static void main(String args[]){
				Scanner input = new Scanner(System.in);
				System.out.print("Enter First integer number : ");
				double num_1 = input.nextInt();
				
				System.out.print("Enter Secod integer number : ");
				double num_2 = input.nextInt();
				
				System.out.print("Enter Third integer number : ");
				double num_3 = input.nextInt();
				
				if(num_1>num_2 && num_2>num_3){
						System.out.print("Decreasing");
				}else if(num_3>num_2 && num_2>num_1){
						System.out.print("Increasing");
				}else{
						System.out.print("Neither increasing nor decreasing order");
				}
				
		}
}
