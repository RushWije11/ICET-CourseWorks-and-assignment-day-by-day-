class Q35 {
    public static long findSmallestMultiple() {
        long number = 1;
        while (true) {
            boolean isDivisible = true;
            for (int i = 1; i <= 20; i++) {
                if (number % i != 0) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible) {
                return number;
            } 
            number++;
        }
    }
    public static void main(String[] args) {
        long result = findSmallestMultiple();
        System.out.println("Smallest positive number: " + result);
    }
}
