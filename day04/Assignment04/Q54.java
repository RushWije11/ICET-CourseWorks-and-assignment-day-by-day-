import java.util.*;
class Q54 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the URL: ");
        String url = input.next();

        if (url.endsWith(".com")) {
            System.out.println("Website type: Commercial website");
        } 
        else if (url.endsWith(".org")) {
            System.out.println("Website type: Organization website");
        } 
        else if (url.endsWith(".lk")) {
            System.out.println("Website type: Sri Lankan website");
        } 
        else {
            System.out.println("Unknown website type!");
        }
    }
}
