import java.util.*;
class Q40{
		public static void main(String args[]){
				Scanner input = new Scanner(System.in);
				System.out.print("Input number 1 : "); 
				int num1=input.nextInt(); 
				System.out.print("Input number 2 : "); 
				int num2=input.nextInt();
				System.out.println(num1+" "+num2);
				int temp1 =num1;
				int temp2 =num2;
				
				num1=temp2;
				num2=temp1;
				
				System.out.print(num1+" "+num2);
				  
				
				
		}
}
