class Q48 {
    public static void main(String[] args) {
        int i = 2; 
        while (i <= 100) {
            int j = 2;
            boolean prime = true;
            while (j <= i / 2) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
                j++;
            }
            if (prime) {
                System.out.println(i);
            }
            
            i++;
        }
    }
}
