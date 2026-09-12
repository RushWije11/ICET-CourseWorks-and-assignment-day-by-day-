import java.util.*;
class Q36 {
    public static void main(String[] args) {
        String[] c = {"Shanaka", "Dinesh", "Amesh", "Lahiru", "Dilshan", "Hashan", "Wenura",
						"Randika", "Dasun", "Thisara", "Kasun", "Nisal", "Praveen"};
						
        String[] f = {"Anjana", "Chamara", "Kamal", "Dhanuka", "Shanaka", "Kasun", "Dineth",
						"Sahan", "Wenura", "Amesh", "Mahesh", "Randika", "Thisara"};

        System.out.println("Part I:");
        for (String s1 : c) {
            for (String s2 : f) {
                if (s1.equals(s2)) {
                    System.out.println(s1);
                    break;
                }
            }
        }
        System.out.println("\nPart II:");
        String all = "";
        for (String s : c) {
            if (!all.contains(s)) {
                all += s + " ";
                System.out.println(s);
            }
        }
        for (String s : f) {
            if (!all.contains(s)) {
                all += s + " ";
                System.out.println(s);
            }
        }
    }
}
