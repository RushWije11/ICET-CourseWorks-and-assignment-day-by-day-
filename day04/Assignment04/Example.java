import java.util.*;
class Example{
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);

		System.out.print("Enter Your Month Salary : ");
		double salary=input.nextDouble();
		double tax = 0 ;
		
		if (salary <= 150000) {
            tax = 0;
        } else if (salary <= 200000) {
            tax = (salary - 150000) * 0.06;
        } else if (salary <= 250000) {
            tax = (50000 * 0.06) + (salary - 200000) * 0.12;
        } else if (salary <= 300000) {
            tax = (50000 * 0.06) + (50000 * 0.12) + (salary - 250000) * 0.18;
        } else if (salary <= 400000) {
            tax = (50000 * 0.06) + (50000 * 0.12) + (50000 * 0.18) + (salary - 300000) * 0.24;
        } else { 
            tax = (50000 * 0.06) + (50000 * 0.12) + (50000 * 0.18) + (100000 * 0.24) + (salary - 400000) * 0.36;
        }
		double wht = tax ;
		double netSalary = salary - wht;
		System.out.printf("WHT :%.2f ", wht);
		System.out.println();
		System.out.printf("Net Salary : %.2f ",netSalary);
		
				     
				
			
    }		
}

