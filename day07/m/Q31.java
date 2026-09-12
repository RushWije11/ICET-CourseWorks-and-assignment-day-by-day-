import java.util.*;
class Q31 {
    public static void main(String[] args) {
        String[] names = {"Sachini", "Tharusha", "Shehan", "Ashini", "Sachin", "Kasun", "Lihini", "Hashini", "Ashini", "Kaveesha"};
        int[] marks = {807, 796, 728, 801, 818, 746, 781, 756, 801, 812};

        System.out.println("--- Part I ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
        names = Arrays.copyOf(names, names.length + 1);
        marks = Arrays.copyOf(marks, marks.length + 1);
        names[names.length - 1] = "Amesh";
        marks[marks.length - 1] = 804;

        System.out.println("\n--- Part II ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
        String[] newNames = new String[names.length - 1];
        int[] newMarks = new int[marks.length - 1];
        for (int i = 0, j = 0; i < names.length; i++) {
            if (i != 8) {
                newNames[j] = names[i];
                newMarks[j] = marks[i];
                j++;
            }
        }
        names = newNames;
        marks = newMarks;

        System.out.println("\n--- Part III ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
        for (int i = 0; i < marks.length - 1; i++) {
            for (int j = 0; j < marks.length - 1 - i; j++) {
                if (marks[j] < marks[j + 1]) {
                    int tempM = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = tempM;

                    String tempN = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = tempN;
                }
            }
        }
        System.out.println("\n--- Part IV ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " - " + marks[i]);
        }
    }
}
