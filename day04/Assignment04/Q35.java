import java.util.*;;
class Q35 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter temperature: ");
        int temp = input.nextInt();

        if (temp >= 80) {
            System.out.println("Swimming");
        } else if (temp >= 60 && temp < 80) {
            System.out.println("Tennis");
        } else if (temp >= 40 && temp < 60) {
            System.out.println("Golf");
        } else {
            System.out.println("Skiing");
        }
    }
}
