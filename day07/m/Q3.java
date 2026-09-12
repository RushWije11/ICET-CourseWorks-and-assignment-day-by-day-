class Q3 {
	public static void main(String[] args){
		String month[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
		int exchange[]={2362,2311,1917,1912,1887,1854,1717,1717,1779,1705,1806,1896};
		
		System.out.println("         Sri lanka          ");
		System.out.println(" Foreign Exchange Reserves  ");
		System.out.println("---------------------------");
		System.out.println("|Month       |USD Milion  |");
		System.out.println("---------------------------");
		System.out.println("|"+month[0]+"     |        "+exchange[0]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[1]+"    |        "+exchange[1]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[2]+"       |        "+exchange[2]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[3]+"       |        "+exchange[3]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[4]+"         |        "+exchange[4]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[5]+"        |        "+exchange[5]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[6]+"        |        "+exchange[6]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[7]+"      |        "+exchange[7]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[8]+"   |        "+exchange[8]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[9]+"     |        "+exchange[9]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[10]+"    |        "+exchange[10]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[11]+"    |        "+exchange[11]+"|");
		System.out.println("---------------------------\n");
		
		
		System.out.println("  Modify (April and july)\n");
		
		exchange[3]=1812;
		exchange[6]=1817;
		
		System.out.println("---------------------------");
		System.out.println("|Month       |USD Milion  |");
		System.out.println("---------------------------");
		System.out.println("|"+month[3]+"       |        "+exchange[3]+"|");
		System.out.println("---------------------------");
		System.out.println("|"+month[6]+"        |        "+exchange[6]+"|");
		System.out.println("---------------------------");
		
		
		
	}
}
