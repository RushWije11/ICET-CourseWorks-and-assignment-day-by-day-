import java.util.*;
class Q26 {
    public static void sort(int[] ar) {
        for (int i = 0; i < ar.length - 1; i++) {
            for (int j = 0; j < ar.length - 1 - i; j++) {
                if (ar[j] > ar[j + 1]) {
                    int t = ar[j];
                    ar[j] = ar[j + 1];
                    ar[j + 1] = t;
                }
            }
        }
        System.out.println(Arrays.toString(ar));
    }

    public static void main(String[] args) {
        int[] arr = {96, 17, 54, 6, 81, 47, 63, 79, 32, 13};
        sort(arr);
    }
}
