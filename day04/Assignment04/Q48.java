import java.util.*;
class Q48 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter month of birth (1-12): ");
        int month = input.nextInt();

        System.out.print("Enter day of birth (1-31): ");
        int day = input.nextInt();

        if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) {
            System.out.println("Astrological sign: Capricornus");
        } 
        else if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) {
            System.out.println("Astrological sign: Aquarius");
        } 
        else if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) {
            System.out.println("Astrological sign: Pisces");
        } 
        else if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) {
            System.out.println("Astrological sign: Aries (Ram)");
        } 
        else if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) {
            System.out.println("Astrological sign: Taurus");
        } 
        else if ((month == 5 && day >= 21) || (month == 6 && day <= 21)) {
            System.out.println("Astrological sign: Gemini");
        } 
        else if ((month == 6 && day >= 22) || (month == 7 && day <= 22)) {
            System.out.println("Astrological sign: Cancer");
        } 
        else if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) {
            System.out.println("Astrological sign: Leo");
        } 
        else if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) {
            System.out.println("Astrological sign: Virgo");
        } 
        else if ((month == 9 && day >= 23) || (month == 10 && day <= 23)) {
            System.out.println("Astrological sign: Libra");
        } 
        else if ((month == 10 && day >= 24) || (month == 11 && day <= 21)) {
            System.out.println("Astrological sign: Scorpius");
        } 
        else if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) {
            System.out.println("Astrological sign: Sagittarius");
        } 
        else {
            System.out.println("Invalid date!");
        }
    }
}
