import java.util.*;
class Q34 {
    public static void main(String[] args) {
        String[] countries = {"Switzerland(2)", "Ivory Coast(1)", "Jamaica(2)", "United States(1)",
							"United States(2)", "Great Britain", "Ivory Coast(2)", "Jamaica(3)", "Switzerland(1)", "Jamaica(1)"};
        double[] times = {11.11, 10.86, 10.76, 10.98, 11.11, 11.05, 11.14, 10.61, 11.06, 10.74};

        int gold = 0;
        for (int i = 1; i < times.length; i++) {
            if (times[i] < times[gold]) gold = i;
        }
        System.out.println("Part I: " + countries[gold] + " - " + times[gold] + "s");

        int newGold = (gold == 0) ? 1 : 0;
        for (int i = 0; i < times.length; i++) {
            if (i != gold && times[i] < times[newGold]) newGold = i;
        }
        System.out.println("Part II: " + countries[newGold] + " - " + times[newGold] + "s");

        String[] c = new String[countries.length - 1];
        double[] t = new double[times.length - 1];

        for (int i = 0, j = 0; i < countries.length; i++) {
            if (i != gold) {
                c[j] = countries[i];
                t[j] = times[i];
                j++;
            }
        }

        for (int i = 0; i < t.length - 1; i++) {
            for (int j = 0; j < t.length - 1 - i; j++) {
                if (t[j] > t[j + 1]) {
                    double tempT = t[j]; t[j] = t[j + 1]; t[j + 1] = tempT;
                    String tempC = c[j]; c[j] = c[j + 1]; c[j + 1] = tempC;
                }
            }
        }

        System.out.println("\nPart III:");
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i] + " - " + t[i] + "s");
        }
    }
}
