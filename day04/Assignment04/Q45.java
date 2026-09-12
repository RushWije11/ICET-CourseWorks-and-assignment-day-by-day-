import java.util.Scanner;
class Q45 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter row number (1-8): ");
        int row = input.nextInt();

        System.out.print("Enter column number (1-8): ");
        int col = input.nextInt();

        if (row >= 1 && row <= 8 && col >= 1 && col <= 8) {
            if ((row % 2 == 0 && col % 2 == 0) || (row % 2 != 0 && col % 2 != 0)) {
                System.out.println("The color of the square is: White");
            } else {
                System.out.println("The color of the square is: Black");
            }
        } else {
            System.out.println("Invalid input! Row and column must be between 1 and 8.");
        }
    }
}
