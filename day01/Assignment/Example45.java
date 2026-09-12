import java.util.*;
class Example45 {
	public static void main(String args[]){
		Scanner input=new Scanner(System.in);
		System.out.print("Enter your marks -");
		int mark=input.nextInt();
		    if(mark>=75){
			System.out.println("your grade is A");
		}else if(mark >=65){
			System.out.println("your grade is B");
		}else if(mark >=50){
		      System.out.println("your grade is C");
		}else{
		      System.out.println("your grade is F");		
		}
	}
}