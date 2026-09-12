import java.util.*;
class Q29 {
	public static int getMonthDay(String x){
		switch (x){
			case "January","january":
			case "March","march":
			case "May","may":
			case "July","july":
			case "August","august":
			case "October","october":
			case "December","december":
				return 31;
			case "April","april":
            case "June","june":
            case "September","september":
            case "November","november":
                return 30;
            case "February","february":
				return 28;
			
			default:
				System.out.println("Month name incorrect !");
				return 0;
		}
	}	
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		System.out.print("Enter Month Name : ");
		String month = input.nextLine();
		
		int days =getMonthDay(month);
		if(days !=0){
			System.out.println("Number of days : "+days);
		}
	 }
 }

