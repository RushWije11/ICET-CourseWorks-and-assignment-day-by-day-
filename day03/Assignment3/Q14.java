import java.util.*;
class Q14 {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		System.out.println("        Enter Numbers   ");
		System.out.print("        Enter 1st Number: ");
		double f_num =input.nextDouble();
		System.out.print("        Enter 2nd Number: ");
		double s_num =input.nextDouble();
		
		System.out.println();
		
		double addition = f_num + s_num ;
		double multi = f_num * s_num ;
		double subt  = f_num - s_num;
		double divi  = f_num/s_num ;
		double remain =f_num%s_num ;
		
		
		System.out.printf("        Addition          : %.2f\n ",addition);
		System.out.printf("       Multiplication    : %.2f\n ",multi);
		System.out.printf("       Subtraction       : %.2f\n ",subt);
		System.out.printf("       Division          : %.2f\n ",divi);
		System.out.printf("       Remainder         : %.2f\n ",remain);
		
	
	}
}
