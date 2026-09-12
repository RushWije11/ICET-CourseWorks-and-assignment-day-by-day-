class Q63 {
	public static void main (String args[]) {
		int x=1;
		L1:if(x>0){ 
			System.out.print("A "); 
			L2:if(x==1){break L1;} 
			System.out.print("B "); 
		}
	}
}

