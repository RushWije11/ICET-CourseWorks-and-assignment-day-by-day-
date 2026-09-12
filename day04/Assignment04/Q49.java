import java.util.*;
class Q49 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basic = input.nextDouble();

        double housing_pe = 0;
        double travel_pe = 0;

        if (basic <= 10000) {
            housing_pe = 0.20;
            travel_pe = 0.60;
        } 
        else if (basic <= 20000) {
            housing_pe = 0.25;
            travel_pe = 0.70;
        } 
        else {
            housing_pe = 0.30;
            travel_pe = 0.75;
        }

        double h_allowance = basic * housing_pe;
        double t_allowance = basic * travel_pe;
        double gross_Salary = basic + h_allowance+ t_allowance;

        System.out.println("Housing Allowance (HA): " + h_allowance);
        System.out.println("Travel Allowance (TA): " + t_allowance);
        System.out.println("Gross Salary: " + gross_Salary);

    }
}
