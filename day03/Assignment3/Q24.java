import java.util.*;
class Q24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
      
        System.out.print("Enter basic salary: ");
        double basic_Salary = input.nextDouble();
    
        double employee_Fund = basic_Salary * 0.120; // 12.0%
        double employer_Fund = basic_Salary * 0.035; // 3.5%
        double pension_Fund  = basic_Salary * 0.083; // 8.3%
  
        System.out.printf("Employee Fund (12.0%%) : %.2f\n", employee_Fund);
        System.out.printf("Employer Fund (3.5%%)  : %.2f\n", employer_Fund);
        System.out.printf("Pension Fund (8.3%%)   : %.2f\n", pension_Fund);

    }
}
