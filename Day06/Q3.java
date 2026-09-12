class Q3 {
	public static void printAlphabet(){
		for(char upperchar = 'A',lowerchar = 'a' ;upperchar<='Z';upperchar++,lowerchar++){
			System.out.print(upperchar+""+lowerchar+"  ");
		
		}
		System.out.println();
	}  
	public static void main(String[] args){
		printAlphabet();
		
	}
}
