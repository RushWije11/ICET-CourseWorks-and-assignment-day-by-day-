import java.util.*;
class Q40 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       
        System.out.print("Enter year  : ");
        int year = input.nextInt();

     
        System.out.print("Enter month : ");
        String month = input.next();

        boolean is_LeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        if (is_LeapYear) {
            System.out.println(year + " is a Leap Year.");
        } else {
            System.out.println(year + " is not a Leap Year.");
        }

        if (month.equals("January") || month.equals("March" )|| month.equals("May") || month.equals("July") || month.equals("August") || month.equals("October") || month.equals("December") ||
		   month.equals("january") || month.equals("march" )|| month.equals("may") || month.equals("july") || month.equals("august") || month.equals("october") || month.equals("december"))  {
            System.out.println("Number of days in " + month + " " + year + " is: 31");
        } 
        else if (month.equals("April") || month.equals("June") || month.equals("September") || month.equals("November") ||	
				month.equals("april") || month.equals("june") || month.equals("september") || month.equals("november")) {
            System.out.println("Number of days in " + month + " " + year + " is: 30");
        } 
        else if (month.equals("February") ||
				 month.equals("february")) {
            if (is_LeapYear) {
                System.out.println("Number of days in February " + year + " is: 29");
            } else {
                System.out.println("Number of days in February " + year + " is: 28");
            }
        } 
        else {
            System.out.println("Invalid month name!");
        }

    }
}
