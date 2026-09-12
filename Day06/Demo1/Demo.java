class Test{
	public static void testMethod(){
		System.out.println("testMethod of Test");
	}
}
class Demo{
	public static void testMethod(){
		System.out.println("testMethod of Demo");
	}
	public static void testMethod2(){
		System.out.println("testMethod of Demo");
	}
	public static void main(String args[]){
		testMethod(); //line 1
		testMethod2(); //line 2
		Test.testMethod(); //line 3
		Demo.testMethod(); //line 4
		Demo.testMethod2(); //line 5
		Demo d=new Demo(); //line 6
		d.testMethod(); //line 7
		d.testMethod2(); //line 8
	}
}
