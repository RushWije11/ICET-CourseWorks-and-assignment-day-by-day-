class Q10 {
	public static void main(String[] args){
		int result[]={6,3,3,2,4,1,6,6,2,4};
		int count=0;
		
		for(int i=0;i<result.length;i++){
			if(result[i]==3 | result[i]==6){
				count++;
			}
		}
		System.out.println("the number of times ‘3’ and ‘6’ is rolled : "+count);
		int count_odd=0;
			for(int i=0;i<result.length;i++){
				if(result[i]%2==1){
					count_odd++;
			}
			
		}
		System.out.println("the number of times odd numbers are rolled : "+count_odd);
		boolean found_5=false;
			for(int i=0;i<result.length;i++){
				if(result[i]==5){
					found_5=true;
					break;
			}
			
		}
		System.out.println("Is number ‘5’ are rolled : "+(found_5 ? "Yes":"No"));
	}
}
