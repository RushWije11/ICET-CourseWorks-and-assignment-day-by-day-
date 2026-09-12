import java.util.*;
class Q22 {
	public static double convertSpeed(double x){
		
		
		double conver_meter = x*1000;
		int minute_insecond = 3600;
		
		double convert_speed = conver_meter/3600;
		
	return convert_speed;	
	}
	public static void main(String[] args){
	Scanner input = new Scanner(System.in);
			
		System.out.print("Enter Speed (Kmh-1) : ");
		double speed =input.nextDouble();
		double c_speed=convertSpeed(speed);
		System.out.printf(speed+" Kmh-1 Convert to ms-1 : %.2f ms-1 ",c_speed);
		
	}
}
