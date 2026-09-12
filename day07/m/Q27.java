import java.util.*;
class Q27 {
    public static void sortSalaries(double[] salaries) {
        for (int i = 0; i < salaries.length - 1; i++) {
            for (int j = 0; j < salaries.length - 1 - i; j++) {
                if (salaries[j] > salaries[j + 1]) {
                    double temp = salaries[j];
                    salaries[j] = salaries[j + 1];
                    salaries[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        double[] dollarSalaries = {15000, 21000, 18500, 12275, 35550, 28760, 17175, 10500};

        sortSalaries(dollarSalaries);

        System.out.println(Arrays.toString(dollarSalaries));
    }
}
