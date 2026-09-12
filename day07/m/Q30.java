import java.util.*;
class Q30 {
    public static void sortDescending(String[] months, int[] reserves) {
        for (int i = 0; i < reserves.length - 1; i++) {
            for (int j = 0; j < reserves.length - 1 - i; j++) {
                if (reserves[j] < reserves[j + 1]) {
                    int tempReserve = reserves[j];
                    reserves[j] = reserves[j + 1];
                    reserves[j + 1] = tempReserve;

                    String tempMonth = months[j];
                    months[j] = months[j + 1];
                    months[j + 1] = tempMonth;
                }
            }
        }
    }

    public static void main(String[] args) {
        String[] originalMonths = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] originalReserves = {2362, 2311, 1917, 1812, 1887, 1854, 1817, 1717, 1779, 1705, 1806, 1896};

        String[] newMonths = new String[originalMonths.length];
        int[] newReserves = new int[originalReserves.length];

        for (int i = 0; i < originalMonths.length; i++) {
            newMonths[i] = originalMonths[i];
            newReserves[i] = originalReserves[i];
        }

        System.out.println("According to Month Order:");
        for (int i = 0; i < originalMonths.length; i++) {
            System.out.println(originalMonths[i] + " - " + originalReserves[i]);
        }

        System.out.println();

        sortDescending(newMonths, newReserves);

        System.out.println("According to Descending Order of Reserves:");
        for (int i = 0; i < newMonths.length; i++) {
            System.out.println(newMonths[i] + " - " + newReserves[i]);
        }
    }
}
