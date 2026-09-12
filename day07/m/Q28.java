import java.util.*;
class Q28 {
    public static int[] modifyArray(int[] inputArr, int replaceIndex, int replaceValue) {
        int[] newArr = new int[inputArr.length];

        for (int i = 0; i < inputArr.length; i++) {
            newArr[i] = inputArr[i];
        }

        if (replaceIndex >= 0 && replaceIndex < newArr.length) {
            newArr[replaceIndex] = replaceValue;
        } else {
            System.out.println("Invalid index!");
        }

        return newArr;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] originalArray = {10, 20, 30, 40};

        System.out.print("Input array -> ");
        System.out.println(Arrays.toString(originalArray));

        System.out.print("Replace index - ");
        int index = input.nextInt();

        System.out.print("Replace value - ");
        int value = input.nextInt();

        int[] newArray = modifyArray(originalArray, index, value);

        System.out.print("New array -> ");
        System.out.println(Arrays.toString(newArray));

        
    }
}
