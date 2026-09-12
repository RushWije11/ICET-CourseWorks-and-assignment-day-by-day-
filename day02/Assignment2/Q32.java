import java.util.*;
class Q32 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter Red value : ");
		int red = input.nextInt();
		System.out.println();
		
		System.out.print("Enter Green value : ");
		int green = input.nextInt();
		System.out.println();
		
		System.out.print("Enter Blue value : ");
		int blue = input.nextInt();
		System.out.println();
		
		int inver_red = 255 - red;
		int inver_green = 255 - green;
		int inver_blue = 255 - blue;
		
		System.out.println("Inversion of given colour - [" + inver_red +","+ inver_green + "," + inver_blue + "]");
		
	}
}
