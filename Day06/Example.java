import java.util.*;
class Example{
	public static void printTotal(int num1,int num2){
		int total;
		total=num1+num2;
		if(total<100){
			return;
		} 
		System.out.println(num1+" + "+num2+" = "+total);
	}
	public static void main(String[] args){
		printTotal(100,200);
		System.out.println("---------------------");
		printTotal(10,20);
	} 
}
