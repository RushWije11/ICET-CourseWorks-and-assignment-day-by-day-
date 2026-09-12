import java.util.*;
class Q17 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
		System.out.print("Input number of Employees: ");
        int empCount = scan.nextInt();
        
        for (int i = 1; i <= empCount; i++) {
            System.out.print("Input salary " + i + " : ");
            double salary = scan.nextDouble();

            int n5000 = (int) (salary / 5000);
            int rem5000 = (int) (salary % 5000);

            int n2000 = rem5000 / 2000;
            int rem2000 = rem5000 % 2000;

            int n1000 = rem2000 / 1000;
            int rem1000 = rem2000 % 1000;

            int n500 = rem1000 / 500;
            int rem500 = rem1000 % 500;

            int n200 = rem500 / 200;
            int rem200 = rem500 % 200;

            int n100 = rem200 / 100;
            int rem100 = rem200 % 100;

            int n50 = rem100 / 50;
            int rem50 = rem100 % 50;

            int n20 = rem50 / 20;
            int rem20 = rem50 % 20;

            int n10 = rem20 / 10;
            int rem10 = rem20 % 10;

            int n5 = rem10 / 5;
            int rem5 = rem10 % 5;

            int n2 = rem5 / 2;
            int rem2 = rem5 % 2;
            int n1 = rem2 / 1;
		System.out.println();
        System.out.println("==============");
        System.out.println("R5000 notes\t: " + n5000 );
        System.out.println("R2000 notes\t: " + n2000);
        System.out.println("R1000 notes\t: " + n1000);
        System.out.println("R500 notes\t: " + n500);
        System.out.println("R200 notes\t: " + n200);
        System.out.println("R100 notes\t: " + n100);
        System.out.println("R50 notes\t: " + n50);
        System.out.println("R20 notes\t: " + n20);
        System.out.println("R10 coins\t: " + n10);
        System.out.println("R5 coins\t: " + n5);
        System.out.println("R2 coins\t: " + n2);
        System.out.println("R1 Coins\t: " + n1);
        
        System.out.println();
        
        }
        
    }
}
