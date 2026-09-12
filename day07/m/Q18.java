import java.util.*;
class Q18 {
	public static void main(String[] args){
		String month[]={"january","february","march","april","may","june","july","august","september","octomber","november","december"};
		
		String[] arrMonth=new String[month.length];
		
		for(int i=0;i<month.length;i++){
			arrMonth[i]=month[i];
		}
		System.out.println("month Array = "+Arrays.toString(month));
		System.out.println("\n");
		
		System.out.println(" After copy the value to the arrMonth array from the month array by using for loop \n");
		System.out.println("arrMonth Array = "+Arrays.toString(arrMonth));
		
		System.out.println("month == arrMonth ??? "+ (month==arrMonth));
		
	}
}
