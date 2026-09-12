import java.util.*;
class Q5 {
	public static void isleapyear(){
		Scanner input = new Scanner(System.in);
			System.out.print("Enter Year : ");
			int year = input.nextInt();
			if(year%4==0&&year%100!=0||year%400==0){
		
				System.out.println(year+" is leap Year");
			}else
				System.out.println(year+" is not Leap Year ");
	}
	public static void main(){
		isleapyear();
	}
}
