import java.util.*;
class Q33 {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 1, 0, 0, 1, 0, 1, 0};

        int zeroIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = arr[i];
                arr[i] = arr[zeroIndex];
                arr[zeroIndex] = temp;
                zeroIndex++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
