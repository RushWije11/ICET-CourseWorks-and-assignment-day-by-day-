import java.util.*;
class Q20 {
		public static void main(String[] args){
			Scanner input = new Scanner(System.in);
			
			System.out.print("Input seconds : ");
			long total_Seconds = input.nextLong();
			
			long hours = total_Seconds /3600 ;
			long minutes = (total_Seconds % 3600) / 60;
			long seconds = total_Seconds % 60 ;
			
			System.out.println(hours+":"+minutes+":"+seconds);
			
		}
}
