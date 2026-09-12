import java.util.*;
class Q19 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Number of days - ");
		int days = input.nextInt();
		
		int day_mo = days/30;
		int day_da = days%30;
		
		System.out.println(days+" days"+" ="+" "+day_mo+" and"+" "+ day_da+" days");
	}
}
