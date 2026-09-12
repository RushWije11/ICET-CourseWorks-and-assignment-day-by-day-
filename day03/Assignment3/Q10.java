class Q10 {
	public static void main(String[] args){
		int a=10,b=20;
		int x;
		x= a + b;
		System.out.println("A:"+"x"+"="+x);
		x= a + -b;
		System.out.println("B:"+"x"+"="+x);
		x= ++a + b;
		System.out.println("C:"+"x"+"="+x);
		x= a + b++;
		System.out.println("D:"+"x"+"="+x);
		x= ++a + b++;
		System.out.println("E:"+"x"+"="+x);
		x= a++ + b++;
		System.out.println("F:"+"x"+"="+x);
		x= ++a + ++b;
		System.out.println("G:"+"x"+"="+x);
		x= a++ + ++b;
		System.out.println("H:"+"x"+"="+x);
	}

}
