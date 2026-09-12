class Q12 {
	public static void main(String[] args){
		int x;
		x=7 % 10 / 2 * 2;
		System.out.println("A :"+"x"+"="+x);
		x=7 % (10 / 2) * 2;
		System.out.println("B :"+"x"+"="+x);
		x=7 % 10 / (2 * 2);
		System.out.println("C :"+"x"+"="+x);
		x=7 % (10 / (2 * 2));
		System.out.println("D :"+"x"+"="+x);
		x=7 % ((10 / 2) * 2);
		System.out.println("A :"+"x"+"="+x);
		
	}
}
