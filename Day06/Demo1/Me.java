import java.util.*;
class Me {
   public static void checkPassword() {
        Scanner input = new Scanner(System.in);
        String correctPassword = "1234";
		int attempts = 0;

        while (attempts < 3) {
            System.out.print("Enter password: ");
            String enteredPassword = input.nextLine();

            if (enteredPassword.equals(correctPassword)) {
                displayDetails();
                return;
            } else {
                attempts++;
                System.out.println("Incorrect password!");

                if (attempts < 3) {
                    System.out.print("Do you want to continue (Yes/No)? ");
                    char choice = input.nextLine().charAt(0);

                    if (choice=='N'||choice=='n') {
                        System.out.println("Program ended.");
                        return;
                    }
                }
            }
        }

        System.out.println("Maximum attempts exceeded. Program ended.");
    }

    public static void displayDetails() {
        System.out.println("\nLogin Successful!");
        System.out.println("Name: Rush Wijemanna");
        System.out.println("Age: 20");
        System.out.println("Occupation: Software Engineer ");
    }

    public static void main(String[] args) {
        checkPassword();
    }
}
