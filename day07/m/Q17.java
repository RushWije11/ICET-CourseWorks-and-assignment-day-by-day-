import java.util.*;
class Q17 {
	public static void main(String s[]) {
		int[] arr={10,20,30,40,50,60,70};
		int[] num=arr;
		System.out.println(Arrays.toString(num)); //Line 1
		System.out.println(Arrays.toString(arr)); //Line 2
		System.out.println("num == arr ??? "+ (num==arr)); //Line 3
		System.out.println(arr); //Line 4
		System.out.println(num); //Line 5
	}
 }
