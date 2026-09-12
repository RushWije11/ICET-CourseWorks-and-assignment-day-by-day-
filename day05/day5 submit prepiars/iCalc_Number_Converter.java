import java.util.*;
class iCalc_Number_Converter {
	public static void main(String [] args){
	Scanner input = new Scanner(System.in);
	
	
	
		System.out.println();
		System.out.println();
	
	
		System.out.println("                                        __   ______              __            ");
		System.out.println("                                       |  \\ /       \\           |  \\           ");
		System.out.println("                                        \\$$|  $$$$$$\\  ______   | $$  _______  ");
		System.out.println("                                       |  \\| $$   \\$$ |       \\ | $$ /       \\ ");
		System.out.println("                                       | $$| $$         \\$$$$$$\\| $$|  $$$$$$$ ");
		System.out.println("                                       | $$| $$   __   /      $$| $$| $$");
		System.out.println("                                       | $$| $$__/  \\|   $$$$$$$| $$| $$_____ ");
		System.out.println("                                       | $$ \\$$    $$  \\$$    $$| $$ \\$$     \\ ");
		System.out.println("                                        \\$$  \\ $$$$$$   \\$$$$$$$ \\$$  \\$$$$$$$");
		System.out.println();
		System.out.println("  _   _                       _                         _____                                          _                 ");
		System.out.println(" | \\ | |                     | |                       / ____|                                        | |                ");
		System.out.println(" |  \\| |  _   _   _ __ ___   | |__     ___   _ __     | |        ___    _ __   __    __   ___   _ __  | |_    ___   _ __ ");
		System.out.println(" | . ` | | | | | | '_ ` _  \\ | '_ \\   / _ \\ | '__|    | |       / _ \\  | '_ \\  \\ \\  / /  / _ \\ | '__| | __|  / _ \\ | '__|");
		System.out.println(" | |\\  | | |_| | | | | | | | | |_) | |  __/ | |       | |____  | (_) | | | | |  \\ \\/ /  |  __/ | |    | |_  |  __/ | |   ");
		System.out.println(" |_| \\_|  \\__,_| |_| |_| |_| |_.__/   \\___| |_|        \\_____|  \\___/  |_| |_|   \\__/    \\___| |_|     \\__|  \\___| |_|   ");
		System.out.println();
		System.out.println("  ============================================================================================================================\n");
		
		
		System.out.println("           [01] Decimal Converter ");
		System.out.println();
		System.out.println("           [02] Binary Converter  ");
		System.out.println();
		System.out.println("           [03] Octal Converter   ");
		System.out.println();
		System.out.println("           [04] Hexadecimal Conveter ");
		System.out.println();
		System.out.println("           [05] Roman Number Converter ");
	
		System.out.println();
		
	
		System.out.print("Enter Option -> ");
		int option = input.nextInt();
	
		switch(option){
			case 1 :
					System.out.println("+-----------------------------------------+");
					System.out.println("|            Decimal Converter            |");
					System.out.println("+-----------------------------------------+");
					System.out.println();
					System.out.println();
				
					System.out.print("Enter an Decimal Number: ");
					int d_num = input.nextInt();
					
					
					int t_binary = d_num;
					String binary ="";
					if(t_binary != 0){
						
						while(t_binary>0){
						
							int rem = t_binary % 2;
							binary = rem + binary ;
							t_binary = t_binary /2;
						
						}
					
					}
					 
					System.out.println("\t Binary Number : "+ binary);
					
					int t_hex =d_num;
					
					
       
		}
					
				
				
				
	
		
	
	}
}
