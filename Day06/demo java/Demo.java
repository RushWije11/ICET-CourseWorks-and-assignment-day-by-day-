class Demo {
	public static void test(){
		System.out.println("Hello....");
	}
	public static void test(String name){
		System.out.println("Hello "+name+"....");
	}
	public static void main(String args[]){
		String s="java"; //Line 1
		//test; //Line 2
		test(); //Line 3
		//test(){ } //Line 4
		//test(){ }; //Line 5 
		Demo.test(); //Line 6
		System.out.println("test()"); //Line 7
		//System.out.println(test()); //Line 8
		test(s); //Line 9
		//System.out.println(test(s)); //Line 10
		System.out.println("test(s)"); //Line 11
 }
}
