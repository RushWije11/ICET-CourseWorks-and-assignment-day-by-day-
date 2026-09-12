class Q15 {
	public static void printswap(){
		int a =23;
		int b =26;
		a= a+b;
		b= a-b;
		a= a-b;
		System.out.println("After Swaping : \n a = "+a+ "\n b = "+b);
	}
	public static void main(String[] args){
		printswap();
	}
}
