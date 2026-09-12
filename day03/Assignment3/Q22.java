import java.util.*;
class Q22 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

  
        System.out.print("Enter dividend : ");
        int dividend = input.nextInt();

        System.out.print("Enter divisor  : ");
        int divisor = input.nextInt();

        
        int quotient = dividend / divisor ;
        
        int remainder = dividend - ( divisor * quotient );

        System.out.println("Remainder is : " + remainder);

        
    }
}
