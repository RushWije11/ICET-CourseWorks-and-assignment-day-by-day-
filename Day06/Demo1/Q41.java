import java.util.*;
class Q41 {
    public static double getcal(double radius) {
        return 2 * 3.14 * radius;
    }
    public static double getcal(double length_s, double width_s) {
        if (length_s == width_s) {
            return 4 * length_s;
        } else {
            return (2 * (length_s + width_s));
        }
    }
    public static double getcal(double s01, double s02, double s03) {
        return s01 + s02 + s03;
    }
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
	
		System.out.println("--- circle ---");
        System.out.print("Enter radius of the circle : ");
        double c_radius = input.nextDouble();
        double c_cal =getcal(c_radius);
        System.out.println("Circle perimeter : " + c_cal);
        System.out.println();

        System.out.println("--- Square ---");
        System.out.print("Enter length : ");
        double sq_length = input.nextDouble();
        System.out.print("Enter width : ");
        double sq_width = input.nextDouble();
        double cal_valu=getcal(sq_length, sq_width);
        if (sq_length == sq_width) {
            System.out.println("Square perimeter : " + cal_valu);
        } else {
            System.out.println("Error: Length and width must be equal for a Square!");
        }
        System.out.println();
		System.out.println("--- Rectangle ---");
        System.out.print("Enter length : ");
        double rec_length = input.nextDouble();
        System.out.print("Enter width : ");
        double rec_width = input.nextDouble();
        
        if (rec_length != rec_width) {
            System.out.println("Rectangle perimeter : " + cal_valu);
        } else {
            System.out.println("Error: Length and width cannot be equal for a Rectangle!");
        }
        System.out.println();
        System.out.println("--- Triangle ---");
        System.out.print("Enter side 1 of the Triangle: ");
        double s1 = input.nextDouble();
        System.out.print("Enter side 2 of the Triangle: ");
        double s2 = input.nextDouble();
        System.out.print("Enter side 3 of the Triangle: ");
        double s3 = input.nextDouble();
        double tr_cal =getcal(s1, s2, s3);
        System.out.println("Triangle perimeter : " + tr_cal);
    }
}

