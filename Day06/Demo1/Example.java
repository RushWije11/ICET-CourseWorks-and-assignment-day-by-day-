class Example{
	public static int increment(int x){
		x++;
		System.out.println("x : "+x);
		return x;
	}
	public static void main(String args[]){
		int x=100;
		System.out.println("x : "+x);
		increment(x);
		System.out.println("x : "+x);
		x=increment(x);
		System.out.println("x : "+x);
	}
}
