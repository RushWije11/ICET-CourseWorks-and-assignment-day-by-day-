import java.util.*;
class Q30 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Input Number : ");
		int number = input.nextInt();
		
		String s_concat = "" + number + number + number;
		System.out.println(s_concat);
		
		int m_number = number + number + number;
		System.out.println(m_number);
	}
}
