import java.util.*;
class Q39 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int[] ids = new int[100];
        String[] names = new String[100];
        int count = 0;

        while (true) {
            System.out.print("Enter Admission Number: ");
            int id = input.nextInt();
            input.nextLine();

            boolean exists = false;
            for (int i = 0; i < count; i++) {
                if (ids[i] == id) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("Duplicate Admission number...");
                System.out.print("Do you want to enter another admission number? (y/n): ");
                if (input.nextLine().equalsIgnoreCase("n")) break;
                continue;
            }

            System.out.print("Enter Student Name: ");
            names[count] = input.nextLine();
            ids[count] = id;
            count++;

            System.out.print("Do you want to add another student? (y/n): ");
            if (input.nextLine().equalsIgnoreCase("n")) break;
        }

        System.out.println("\nRegistered Students:");
        for (int i = 0; i < count; i++) {
            System.out.println(ids[i] + " - " + names[i]);
        }
    }
}
