import java.util.*;
class Q18 {
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter value in byte : ");
		double bytes = input.nextDouble();
		
		//calculation part
		double kilobytes = bytes / 1024 ;
		double megabytes = kilobytes /1024 ;
		double gigabytes = megabytes /1024 ;
		
		System.out.printf("Kilobytes : %.2f KB\n",kilobytes);
		System.out.printf("Megabytes : %.2f MB\n",megabytes);
		System.out.printf("Gigabytes : %.2f GB\n",gigabytes);
	}
}
