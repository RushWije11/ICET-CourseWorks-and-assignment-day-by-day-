class Q13 {
	public static void main(String[] args){
		int x=20,y=60;
		boolean bool;
		System.out.println(x=10); 
		System.out.println(bool=true); 
		//System.out.println(x=10>0); // this is incorrect
		System.out.println((x=10)>0); 
		System.out.println(bool=(x=10)>0); 
		System.out.println(bool=x+y>100); 
	}
}
