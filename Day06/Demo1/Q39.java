class Q39 {
    public static void add(int a, int b) {
        System.out.println("Sum of integers: " + (a + b));
    }
    public static void add(double a, double b) {
        System.out.println("Sum of doubles: " + (a + b));
    }
    public static void add(String a, String b) {
        System.out.println("Concatenated String: " + (a + b));
    }
    public static void main(String[] args) {
        add(10, 20);
        add(5.5, 4.2);
        add("Hello, ", "World!");
    }
}
