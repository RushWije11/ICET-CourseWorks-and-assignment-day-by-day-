class Q14 {
	public static void main(String[] args){
		byte b = 10;
		short s = 100;
		int x = 125;
		long l = 15000;
		float f = 1.5f;
		double d = 21.231;
		char c = 'c';
		boolean bool = 10>9;
		System.out.println(b+s+x+""+f+d+c+bool); //Line 1
		System.out.println(""+b+s+x+f+d+c+bool); //Line 2
		System.out.println(b+s+x+f+d+c+""+bool); //Line 3
		//System.out.println(b+s+x+f+d+c+bool+""); //Error 
		//System.out.println(bool+b+f+d+c+""+x+l); //Error
	}
}
