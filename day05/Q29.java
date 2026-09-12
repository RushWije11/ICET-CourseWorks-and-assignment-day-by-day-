import java.util.*;
class Q29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("How many bottles of beer are on the wall: ");
        int bottles = scanner.nextInt();
        
        for (int i = bottles; i > 0; i--) {
            if (i == 1) {
                System.out.println("1 bottle of beer on the wall, 1 bottle of beer.");
                System.out.println("Take one down, pass it around, no more bottles of beer on the wall.");
            } else {
                System.out.println(i + " bottles of beer on the wall, " + i + " bottles of beer.");
                System.out.println("Take one down, pass it around, " + (i - 1) + " bottles of beer on the wall.\n");
            }
        }
        
    }
}
