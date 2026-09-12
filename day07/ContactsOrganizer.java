import java.util.Scanner;

public class ContactsOrganizer {
    // Global arrays to store contact information
    public static String[] ids = new String[0];
    public static String[] names = new String[0];
    public static String[] phones = new String[0];
    public static String[] companies = new String[0];
    public static double[] salaries = new double[0];
    public static String[] birthdays = new String[0];

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        homePage();
    }

    // --- HOME PAGE ---
    public static void homePage() {
        while (true) {
            clearConsole();
            System.out.println("===========================================================================================");
            System.out.println("   /$$ /$$$$$$$$ /$$$$$$$$ /$$$$$$ /$$$$$$$$ /$$   /$$ /$$$$$$$ ");
            System.out.println("  |__/| $$_____/| $$_____/|_  $$_/| $$_____/| $$$ | $$| $$__  $$");
            System.out.println("   /$$| $$      | $$        | $$  | $$      | $$$$| $$| $$  \\ $$");
            System.out.println("  | $$| $$$$$   | $$$$$     | $$  | $$$$$   | $$ $$ $$| $$  | $$");
            System.out.println("  | $$| $$__/   | $$__/     | $$  | $$__/   | $$  $$$$| $$  | $$");
            System.out.println("  | $$| $$      | $$        | $$  | $$      | $$\\  $$$| $$  | $$");
            System.out.println("  | $$| $$      | $$$$$$$$ /$$$$$$| $$$$$$$$| $$ \\  $$| $$$$$$$/");
            System.out.println("  |__/|__/      |________/|______/|________/|__/  \\__/|_______/ ");
            System.out.println("===========================================================================================");
            System.out.println(" _____            _act   ___                    _zer   ");
            System.out.println("/  __ \\          | |    / _ \\                  |_  |   ");
            System.out.println("| /  \\/ ___  _ __| |_  / /_\\ \\_ __  _ __        | |   ");
            System.out.println("| |    / _ \\| '__| __| |  _  | '_ \\| '_ \\       | |   ");
            System.out.println("| \\__/\\ (_) | |  | |_  | | | | |_) | |_) |  /\\__/ /   ");
            System.out.println(" \\____/\\___/|_|   \\__| \\_| |_/ .__/| .__/   \\____/    ");
            System.out.println("                             | |   | |                 ");
            System.out.println("                             |_|   |_|                 ");
            System.out.println("===========================================================================================\n");

            System.out.println("[01] ADD Contacts");
            System.out.println("[02] UPDATE Contacts");
            System.out.println("[03] DELETE Contacts");
            System.out.println("[04] SEARCH Contacts");
            System.out.println("[05] LIST Contacts");
            System.out.println("[06] Exit\n");

            System.out.print("Enter an option to continue -> ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                case "01":
                    addContact();
                    break;
                case "2":
                case "02":
                    updateContact();
                    break;
                case "3":
                case "03":
                    deleteContact();
                    break;
                case "4":
                case "04":
                    searchContact();
                    break;
                case "5":
                case "05":
                    listContacts();
                    break;
                case "6":
                case "06":
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    // --- ID GENERATOR ---
    public static String generateId() {
        if (ids.length == 0) {
            return "C0001";
        }
        String lastId = ids[ids.length - 1];
        int num = Integer.parseInt(lastId.substring(1));
        num++;
        return String.format("C%04d", num);
    }

    // --- VALIDATION METHODS ---
    public static boolean isValidPhoneNumber(String phone) {
        if (phone.length() != 10 || phone.charAt(0) != '0') {
            return false;
        }
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidBirthday(String bday) {
        if (bday.length() != 10) return false;
        if (bday.charAt(4) != '-' || bday.charAt(7) != '-') return false;

        for (int i = 0; i < bday.length(); i++) {
            if (i == 4 || i == 7) continue;
            if (!Character.isDigit(bday.charAt(i))) return false;
        }

        int year = Integer.parseInt(bday.substring(0, 4));
        int month = Integer.parseInt(bday.substring(5, 7));
        int day = Integer.parseInt(bday.substring(8, 10));

        if (month < 1 || month > 12) return false;
        if (day < 1 || day > 31) return false;

        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) return false;
        } else if (month == 2) {
            boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            if (isLeap && day > 29) return false;
            if (!isLeap && day > 28) return false;
        }

        int curYear = 2026;
        int curMonth = 9;
        int curDay = 3;

        if (year > curYear) return false;
        if (year == curYear) {
            if (month > curMonth) return false;
            if (month == curMonth && day > curDay) return false;
        }

        return true;
    }

    // --- SEARCH HELPER ---
    public static int searchIndex(String nameOrPhone) {
        for (int i = 0; i < ids.length; i++) {
            if (names[i].equalsIgnoreCase(nameOrPhone) || phones[i].equals(nameOrPhone)) {
                return i;
            }
        }
        return -1;
    }

    // --- ARRAY RESIZING HELPER ---
    public static void extendArrays() {
        String[] newIds = new String[ids.length + 1];
        String[] newNames = new String[names.length + 1];
        String[] newPhones = new String[phones.length + 1];
        String[] newCompanies = new String[companies.length + 1];
        double[] newSalaries = new double[salaries.length + 1];
        String[] newBirthdays = new String[birthdays.length + 1];

        for (int i = 0; i < ids.length; i++) {
            newIds[i] = ids[i];
            newNames[i] = names[i];
            newPhones[i] = phones[i];
            newCompanies[i] = companies[i];
            newSalaries[i] = salaries[i];
            newBirthdays[i] = birthdays[i];
        }

        ids = newIds;
        names = newNames;
        phones = newPhones;
        companies = newCompanies;
        salaries = newSalaries;
        birthdays = newBirthdays;
    }

    // --- 01. ADD CONTACTS ---
    public static void addContact() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|               Add Contact to the list            |");
            System.out.println("+--------------------------------------------------+\n");

            String newId = generateId();
            System.out.println(newId);
            System.out.println("=======\n");

            System.out.print("Name             : ");
            String name = scanner.nextLine();

            String phone = "";
            while (true) {
                System.out.print("Phone Number     : ");
                phone = scanner.nextLine();
                if (isValidPhoneNumber(phone)) {
                    break;
                }
                System.out.println("\nInvalid phone number...");
                System.out.print("Do you want to add phone number again (Y/N): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return;
                }
                System.out.print("\033[3A\033[0J");
            }

            System.out.print("Company Name     : ");
            String company = scanner.nextLine();

            double salary = 0;
            while (true) {
                System.out.print("Salary           : ");
                double sal = scanner.nextDouble();
                scanner.nextLine();
                if (sal > 0) {
                    salary = sal;
                    break;
                }
                System.out.println("\nInvalid salary...");
                System.out.print("Do you want to add salary again (Y/N): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return;
                }
                System.out.print("\033[3A\033[0J");
            }

            String birthday = "";
            while (true) {
                System.out.print("B'Day(YYYY-MM-DD): ");
                birthday = scanner.nextLine();
                if (isValidBirthday(birthday)) {
                    break;
                }
                System.out.println("\nInvalid Birthday...");
                System.out.print("Do you want to input birthday again (Y/N): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return;
                }
                System.out.print("\033[3A\033[0J");
            }

            extendArrays();
            int idx = ids.length - 1;
            ids[idx] = newId;
            names[idx] = name;
            phones[idx] = phone;
            companies[idx] = company;
            salaries[idx] = salary;
            birthdays[idx] = birthday;

            System.out.println("\n\tContact has been added successfully...\n");
            System.out.print("Do you want to add another Contact(Y/N): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                return;
            }
        }
    }

    // --- 02. UPDATE CONTACTS ---
    public static void updateContact() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                  UPDATE Contact                  |");
            System.out.println("+--------------------------------------------------+\n");

            System.out.print("Search Contact by Name or Phone Number - ");
            String searchKey = scanner.nextLine();

            int index = searchIndex(searchKey);
            if (index == -1) {
                System.out.println("\n\tNo contact found for " + searchKey + "...");
                System.out.print("\nDo you want to try a new search (Y/N): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return;
                }
                continue;
            }

            printContactDetails(index);

            System.out.println("\nWhat do you want to update...");
            System.out.println("\t[01] Name");
            System.out.println("\t[02] Phone Number");
            System.out.println("\t[03] Company Name");
            System.out.println("\t[04] Salary\n");

            System.out.print("Enter an option to continue -> ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                case "01":
                    System.out.println("\nUpdate Name");
                    System.out.println("===========");
                    System.out.print("Input new name - ");
                    String newName = scanner.nextLine();
                    names[index] = newName;
                    break;

                case "2":
                case "02":
                    System.out.println("\nUpdate Phone Number");
                    System.out.println("===================");
                    while (true) {
                        System.out.print("Input new phone number - ");
                        String newPhone = scanner.nextLine();
                        if (isValidPhoneNumber(newPhone)) {
                            phones[index] = newPhone;
                            break;
                        }
                        System.out.println("Invalid phone number...");
                    }
                    break;

                case "3":
                case "03":
                    System.out.println("\nUpdate Company Name");
                    System.out.println("===================");
                    System.out.print("Input new company name - ");
                    String newComp = scanner.nextLine();
                    companies[index] = newComp;
                    break;

                case "4":
                case "04":
                    System.out.println("\nUpdate Salary");
                    System.out.println("=============");
                    while (true) {
                        System.out.print("Input new salary - ");
                        double newSal = scanner.nextDouble();
                        scanner.nextLine();
                        if (newSal > 0) {
                            salaries[index] = newSal;
                            break;
                        }
                        System.out.println("Invalid salary...");
                    }
                    break;

                default:
                    break;
            }

            System.out.println("\n\tContact has been update successfully...\n");
            System.out.print("Do you want to update another Contact (Y/N): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                return;
            }
        }
    }

    // --- 03. DELETE CONTACTS ---
    public static void deleteContact() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                  DELETE Contact                  |");
            System.out.println("+--------------------------------------------------+\n");

            System.out.print("Search Contact by Name or Phone Number - ");
            String searchKey = scanner.nextLine();

            int index = searchIndex(searchKey);
            if (index == -1) {
                System.out.println("\n\tNo contact found for " + searchKey + "...");
                System.out.print("\nDo you want to try a new search (Y/N): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return;
                }
                continue;
            }

            printContactDetails(index);

            System.out.print("\nDo you want to delete this Contact (Y/N): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("Y")) {
                String[] newIds = new String[ids.length - 1];
                String[] newNames = new String[names.length - 1];
                String[] newPhones = new String[phones.length - 1];
                String[] newCompanies = new String[companies.length - 1];
                double[] newSalaries = new double[salaries.length - 1];
                String[] newBirthdays = new String[birthdays.length - 1];

                for (int i = 0, k = 0; i < ids.length; i++) {
                    if (i == index) continue;
                    newIds[k] = ids[i];
                    newNames[k] = names[i];
                    newPhones[k] = phones[i];
                    newCompanies[k] = companies[i];
                    newSalaries[k] = salaries[i];
                    newBirthdays[k] = birthdays[i];
                    k++;
                }

                ids = newIds;
                names = newNames;
                phones = newPhones;
                companies = newCompanies;
                salaries = newSalaries;
                birthdays = newBirthdays;

                System.out.println("\n\tCustomer has been deleted successfully...\n");
            }

            System.out.print("Do you want to delete another Contact (Y/N): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                return;
            }
        }
    }

    // --- 04. SEARCH CONTACTS ---
    public static void searchContact() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                  SEARCH Contact                  |");
            System.out.println("+--------------------------------------------------+\n");

            System.out.print("Search Contact by Name or Phone Number - ");
            String searchKey = scanner.nextLine();

            int index = searchIndex(searchKey);
            if (index == -1) {
                System.out.println("\n\tNo contact found for " + searchKey + "...");
                System.out.print("\nDo you want to try a new search (Y/N): ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    return;
                }
                continue;
            }

            printContactDetails(index);

            System.out.print("\nDo you want to search another contact (Y/N): ");
            String choice = scanner.nextLine();
            if (!choice.equalsIgnoreCase("Y")) {
                return;
            }
        }
    }

    // --- 05. LIST CONTACTS ---
    public static void listContacts() {
        while (true) {
            clearConsole();
            System.out.println("+--------------------------------------------------+");
            System.out.println("|                   SORT Contact                   |");
            System.out.println("+--------------------------------------------------+\n");

            System.out.println("\t[01] Sorting by Name");
            System.out.println("\t[02] Sorting by Salary");
            System.out.println("\t[03] Sorting by Birthday\n");

            System.out.print("Enter an option to continue -> ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                case "01":
                    sortByName();
                    break;
                case "2":
                case "02":
                    sortBySalary();
                    break;
                case "3":
                case "03":
                    sortByBirthday();
                    break;
                default:
                    continue;
            }

            System.out.print("\nDo you want to go Home Page (Y/N): ");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("Y")) {
                return;
            }
        }
    }

    // --- SORTING METHODS ---
    public static void sortByName() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------+");
        System.out.println("|                                  List Contact by Name                                  |");
        System.out.println("+----------------------------------------------------------------------------------------+\n");

        int n = ids.length;
        String[] tIds = copyArray(ids);
        String[] tNames = copyArray(names);
        String[] tPhones = copyArray(phones);
        String[] tCompanies = copyArray(companies);
        double[] tSalaries = copyArray(salaries);
        String[] tBirthdays = copyArray(birthdays);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tNames[j].compareToIgnoreCase(tNames[j + 1]) > 0) {
                    swap(tIds, tNames, tPhones, tCompanies, tSalaries, tBirthdays, j, j + 1);
                }
            }
        }
        printTable(tIds, tNames, tPhones, tCompanies, tSalaries, tBirthdays);
    }

    public static void sortBySalary() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------+");
        System.out.println("|                                 List Contact by Salary                                 |");
        System.out.println("+----------------------------------------------------------------------------------------+\n");

        int n = ids.length;
        String[] tIds = copyArray(ids);
        String[] tNames = copyArray(names);
        String[] tPhones = copyArray(phones);
        String[] tCompanies = copyArray(companies);
        double[] tSalaries = copyArray(salaries);
        String[] tBirthdays = copyArray(birthdays);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tSalaries[j] > tSalaries[j + 1]) {
                    swap(tIds, tNames, tPhones, tCompanies, tSalaries, tBirthdays, j, j + 1);
                }
            }
        }
        printTable(tIds, tNames, tPhones, tCompanies, tSalaries, tBirthdays);
    }

    public static void sortByBirthday() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------------------------------+");
        System.out.println("|                                List Contact by Birthday                                |");
        System.out.println("+----------------------------------------------------------------------------------------+\n");

        int n = ids.length;
        String[] tIds = copyArray(ids);
        String[] tNames = copyArray(names);
        String[] tPhones = copyArray(phones);
        String[] tCompanies = copyArray(companies);
        double[] tSalaries = copyArray(salaries);
        String[] tBirthdays = copyArray(birthdays);

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tBirthdays[j].compareTo(tBirthdays[j + 1]) > 0) {
                    swap(tIds, tNames, tPhones, tCompanies, tSalaries, tBirthdays, j, j + 1);
                }
            }
        }
        printTable(tIds, tNames, tPhones, tCompanies, tSalaries, tBirthdays);
    }

    // --- UTILITY METHODS ---
    public static void printContactDetails(int index) {
        System.out.println("\n\tContact ID       : " + ids[index]);
        System.out.println("\tName             : " + names[index]);
        System.out.println("\tPhone Number     : " + phones[index]);
        System.out.println("\tCompany Name     : " + companies[index]);
        System.out.println("\tSalary           : " + salaries[index]);
        System.out.println("\tB'Day(YYYY-MM-DD): " + birthdays[index]);
    }

    public static void printTable(String[] tIds, String[] tNames, String[] tPhones, String[] tCompanies, double[] tSalaries, String[] tBirthdays) {
        System.out.println("+------------+--------------------+--------------+--------------------+------------+------------+");
        System.out.println("| Contact ID | Name               | Phone Number | Company            | Salary     | Birthday   |");
        System.out.println("+------------+--------------------+--------------+--------------------+------------+------------+");

        for (int i = 0; i < tIds.length; i++) {
            System.out.printf("| %-10s | %-18s | %-12s | %-18s | %-10.1f | %-10s |\n",
                    tIds[i], tNames[i], tPhones[i], tCompanies[i], tSalaries[i], tBirthdays[i]);
        }
        System.out.println("+------------+--------------------+--------------+--------------------+------------+------------+");
    }

    public static void swap(String[] tIds, String[] tNames, String[] tPhones, String[] tCompanies, double[] tSalaries, String[] tBirthdays, int i, int j) {
        String tempId = tIds[i]; tIds[i] = tIds[j]; tIds[j] = tempId;
        String tempName = tNames[i]; tNames[i] = tNames[j]; tNames[j] = tempName;
        String tempPhone = tPhones[i]; tPhones[i] = tPhones[j]; tPhones[j] = tempPhone;
        String tempComp = tCompanies[i]; tCompanies[i] = tCompanies[j]; tCompanies[j] = tempComp;
        double tempSal = tSalaries[i]; tSalaries[i] = tSalaries[j]; tSalaries[j] = tempSal;
        String tempBday = tBirthdays[i]; tBirthdays[i] = tBirthdays[j]; tBirthdays[j] = tempBday;
    }

    public static String[] copyArray(String[] arr) {
        String[] copy = new String[arr.length];
        for (int i = 0; i < arr.length; i++) copy[i] = arr[i];
        return copy;
    }

    public static double[] copyArray(double[] arr) {
        double[] copy = new double[arr.length];
        for (int i = 0; i < arr.length; i++) copy[i] = arr[i];
        return copy;
    }

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
