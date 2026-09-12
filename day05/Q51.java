class Q51 {
    public static void main(String[] args) {
        long number = 1;
        boolean found = false;
        
        while (!found) {
            boolean isDivid = true;
            for (int i = 1; i <= 20; i++) {
                if (number % i != 0) {
                    isDivid = false;
                    break; 
                }
            }
            
            if (isDivid) {
                System.out.println("The smallest multiple between 1 to 20 and it is: " + number);
                found = true;
            } else {
                number++;
            }
        }
    }
}
