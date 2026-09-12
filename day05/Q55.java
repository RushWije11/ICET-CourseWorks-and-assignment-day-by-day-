class Q55 {
    public static void main(String[] args) {
        System.out.println("Starting random point generation inside the unit circle:\n");
        
        int totalPoints = 0;
        
        while (true) {
            double x = Math.random() * 2.0 - 1.0;
            if (x < -1.0) {
                x = -1.0;
            } else if (x > 1.0) {
                x = 1.0;
            }
            
            double y = Math.random() * 2.0 - 1.0;
            if (y < -1.0) {
                y = -1.0;
            } else if (y > 1.0) {
                y = 1.0;
            }
            
            totalPoints++;
            
            if (x * x + y * y <= 1.0) {
                System.out.printf("Point %d (Inside): x = %.1f, y = %.1f%n", totalPoints, x, y);
            } else {
                System.out.printf("Caught an outsider! x = %.1f, y = %.1f (Outside the circle)%n", x, y);
                System.out.println(" Total  generated points : " + totalPoints);
                break;
            }
        }
    }
}
