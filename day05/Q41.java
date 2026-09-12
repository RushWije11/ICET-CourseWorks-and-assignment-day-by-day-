class Q41 {
    public static void main(String[] args) {
        for (int i = 0; i <= 4; i++) {
            for (int j = 0; j <= 4; j++) {
                
                System.out.println(
                    i + " " + j + "\t" + 
                    j + " " + i + "\t" + 
                    (5 - i) + " " + j + "\t" + 
                    (5 - i) + " " + (5 - j)
                );
            }
        }
    }
}
