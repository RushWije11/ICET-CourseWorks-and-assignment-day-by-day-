import java.util.*;
class Q25 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter First Integer Number  : ");
        int f_num = input.nextInt();

        System.out.print("Enter Second Integer Number : ");
        int s_num = input.nextInt();

        System.out.print("Enter Third Integer Number  : ");
        int third_num = input.nextInt();

        // Calculate absolute differences
        int abs1 = (s_num > third_num) ? (s_num - third_num) : (third_num - s_num);
        int abs2 = (f_num > third_num) ? (f_num - third_num) : (third_num - f_num);
        int abs3 = (f_num > s_num) ? (f_num - s_num) : (s_num - f_num);

        // Check if one is greater than the difference of others
        if (f_num > abs1) {
            System.out.println("First number Greater than subtraction of others :True ");
        }else{
            System.out.println("First number greater than subtraction of others :False ");
        }
        if(s_num > abs2){
			System.out.println("Second number greater than subtraction of others :True ");
        }else{
			System.out.println("Second number greater than subtraction of others :False ");
        }
        if(third_num > abs3){
			System.out.println("Thrid number greater than subtraction of others :True ");
        }else{
			System.out.println("Thrid number greater than subtraction of others :False ");
		}
    }
}
