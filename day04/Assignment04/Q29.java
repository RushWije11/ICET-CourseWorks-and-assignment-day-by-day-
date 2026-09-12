import java.util.*;
class Q29 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter First Number  : ");
		double f_num = input.nextDouble();
		
		System.out.print("Enter Second Number : ");
		double s_num = input.nextDouble();
		
		if ((f_num > 0 && s_num > 0) || (f_num < 0 && s_num < 0)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
		
	}
}
