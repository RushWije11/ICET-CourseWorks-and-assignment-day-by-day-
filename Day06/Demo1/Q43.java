import java.util.*;
class Q43 {
    public static String convertToBinary(int val) {
        String bin = "";
        while (val > 0) {
            int rem = val % 2;
            bin = rem + bin;
            val = val / 2;
        }
        if (bin.equals("")) {
            bin = "0";
        }
        return bin;
    }
    public static String convertToOctal(int val) {
        String oct = "";
        while (val > 0) {
            int rem = val % 8;
            oct = rem + oct;
            val = val / 8;
        }
        if (oct.equals("")) {
            oct = "0";
        }
        return oct;
    }
    public static String convertToHexadecimal(int val) {
        String hex = "";
        while (val > 0) {
            int rem = val % 16;
            
            if (rem == 10) {
                hex = "A" + hex;
            } else if (rem == 11) {
                hex = "B" + hex;
            } else if (rem == 12) {
                hex = "C" + hex;
            } else if (rem == 13) {
                hex = "D" + hex;
            } else if (rem == 14) {
                hex = "E" + hex;
            } else if (rem == 15) {
                hex = "F" + hex;
            } else {
                hex = rem + hex;
            }
            
            val = val / 16;
        }
        if (hex.equals("")) {
            hex = "0";
        }
        return hex;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int num = scan.nextInt();

        System.out.println("Binary: " + convertToBinary(num));
        System.out.println("Octal: " + convertToOctal(num));
        System.out.println("Hexadecimal: " + convertToHexadecimal(num));
    }
}
