import java.util.*;
class Q43 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first number      : ");
        int num1 = input.nextInt();

        System.out.print("Enter the second number     : ");
        int num2 = input.nextInt();

        System.out.print("Enter the operator (+,-,*,/,%,^) : ");
        char operator = input.next().charAt(0);

        if (operator == '+') {
            System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
        } 
        else if (operator == '-') {
            System.out.println(num1 + " - " + num2 + " = " + (num1 - num2));
        } 
        else if (operator == '*') {
            System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
        } 
        else if (operator == '/') {
            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
        } 
        else if (operator == '%') {
            System.out.println(num1 + " % " + num2 + " = " + (num1 % num2));
        } 
        else if (operator == '^') {
            int result = 1;
            for (int i = 1; i <= num2; i++) {
                result = result * num1;
            }
            System.out.println(num1 + " ^ " + num2 + " = " + result);
        } 
        else {
            System.out.println("Invalid operator!");
        }
    }
}
