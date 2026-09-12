import java.util.*;
class Q25 {
	public static void main(String[] args){
		int dollar[]={15000, 21000, 18500, 12275, 35550, 28760, 17175, 10500};
		double[] rupee = new double[dollar.length];
		
		for(int i = 0; i < rupee.length; i++){
			rupee[i] = (double)dollar[i] * 360.10;
		}
		
		int longvalue = 7500000;
		int more_count = 0;
		int less_count = 0;
		
		for(int i = 0; i < rupee.length; i++){
			if(rupee[i] > longvalue){
				more_count++;
			} else {
				less_count++;
			}
		}
		
		System.out.println("Count of Software engineers get more than Rs.7,500,000 : " + more_count);
		System.out.println("Count of Software engineers get less than Rs.7,500,000 : " + less_count);
		
		double[] arrmore = new double[more_count]; 
		double[] arrless = new double[less_count];

		int indexMore = 0;
		int indexLess = 0;
		
		for (int i = 0; i < rupee.length; i++) {
			if (rupee[i] > 7500000) {
				arrmore[indexMore++] = rupee[i];
			} else if (rupee[i] < 7500000) {
				arrless[indexLess++] = rupee[i];
			}
		}
		
		System.out.print("Arrmore: ");
		for (double val : arrmore) {
			System.out.printf("%.2f  ", val);
		}
		System.out.println();

		System.out.print("Arrless: ");
		for (double val : arrless) {
			System.out.printf("%.2f  ", val);
		}
		System.out.println();
	}
}
