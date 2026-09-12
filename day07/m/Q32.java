import java.util.*;
class Q32 {
    public static void rotateLeft(int[] arr) {
        int first = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = first;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60, 70};
		System.out.println(Arrays.toString(arr));
        rotateLeft(arr);

        System.out.println(Arrays.toString(arr));
    }
}
