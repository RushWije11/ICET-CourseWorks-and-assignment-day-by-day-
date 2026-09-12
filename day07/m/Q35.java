import java.util.*;
class Q35 {
    public static void findDuplicate(int[] arr) {
        boolean found = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    System.out.println("duplicate \"" + arr[i] + "\"");
                    found = true;
                    break;
                }
            }
            if (found) break;
        }
        if (!found) {
            System.out.println("no duplicate");
        }
    }
    public static boolean equals(int[] a, int[] b) {
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[] ar = {10, 20, 30, 40, 50};
        int[] br = {10, 20, 10, 40, 50, 60};
        int[] cr = {30, 30, 30, 30};
        int[] dr = {40, 10, 50, 20, 30};
        int[] er = {10, 20, 30, 40, 50};
        int[] fr = {10, 20, 30, 40};

        findDuplicate(ar);
        findDuplicate(br);
        findDuplicate(cr);
        findDuplicate(dr);
        findDuplicate(er);
        findDuplicate(fr);

        System.out.println("ar==br: " + equals(ar, br));
        System.out.println("ar==cr: " + equals(ar, cr));
        System.out.println("ar==dr: " + equals(ar, dr));
        System.out.println("ar==er: " + equals(ar, er));
        System.out.println("ar==fr: " + equals(ar, fr));
    }
}
