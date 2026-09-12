import java.util.*;
class Q40 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] ids = new int[1000];
        int count = 0;

        while (true) {
            System.out.print("Enter Clothing ID (-1 to exit): ");
            int id = input.nextInt();

            if (id == -1) break;

            boolean exists = false;
            for (int i = 0; i < count; i++) {
                if (ids[i] == id) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("Duplicate element! ID already exists.");
            } else {
                ids[count] = id;
                count++;
            }
        }

        int[] selected = new int[count];
        for (int i = 0; i < count; i++) {
            selected[i] = ids[i];
        }

        System.out.println("Selected Clothing IDs: " + Arrays.toString(selected));
    }
}
