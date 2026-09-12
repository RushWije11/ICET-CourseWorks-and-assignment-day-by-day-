import java.util.*;
class BillPrint{
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);//this is a scanner code it use for get input method
		System.out.println("================================================================================= \n");
		System.out.println("__          __  _                            _          _ __  __            _    ");
		System.out.println("\\ \\        / / | |                          | |        (_)  \\/  |          | |   ");
		System.out.println(" \\ \\  /\\  / /__| | ___ ___  _ __ ___   ___  | |_ ___    _| \\  / | __ _ _ __| |_  ");
		System.out.println("  \\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\ | __/ _ \\  | | |\\/| |/ _` | `__| __| ");
		System.out.println("   \\  /\\  /  __/ | (_| (_) | | | | | |  __/ | || (_) | | | |  | | (_| | |  | |_  ");
		System.out.println("    \\/  \\/ \\___|_|\\___\\___/|_| |_| | |\\___|  \\__\\___/  |_|_|  |_|\\__,_|_|   \\__| ");
		System.out.println(                                                                                   );
		System.out.println("================================================================================= \n");
		
		System.out.println("                                                                                     ");
		
		System.out.print("Enter Customer Phone Number : ");
		String c_tel = input.nextLine();//get input 
		
        System.out.println();
        
        System.out.print("Enter Customer Name : ");
		String c_name = input.nextLine();
		
		System.out.println("\n");
		
		System.out.println("================================================================================ \n");
		
		System.out.print("Basmathi Qty(Kg) : ");
		int basmathi_Qty = input.nextInt();
		
		System.out.print("\n");
		
		System.out.print("Dhal Qty(Kg)     : ");
		int dhal_Qty = input.nextInt();
		
		System.out.print("\n");
		
		System.out.print("Suger Qty(Kg)    : ");
		int sugar_Qty = input.nextInt();
		
		System.out.print("\n");
		
		System.out.print("Higland Qty      : ");
		int highland_Qty = input.nextInt();
		
		System.out.print("\n");
		
		System.out.print("Yoghurt Qty      : ");
		int yoghurt_Qty = input.nextInt();
		
		System.out.print("\n");
		
		System.out.print("Flour Qty(Kg)    : ");
		int flour_Qty = input.nextInt();
		
		System.out.print("\n");
		
		System.out.print("Soup Qty         : ");
		int soap_Qty = input.nextInt();	
		//below codes represents
		double basmathi_Price = 250.0;
		double dhal_Price = 180.0;
		double sugar_Price = 150.0;
		double highland_Price = 1200.0;
		double yoghurt_Price = 50.0;
		double flour_Price = 120.0;
		double soap_Price = 160.0;
		//below codes represents
		double basmathiTotal = basmathi_Qty * basmathi_Price;
		double dhalTotal = dhal_Qty * dhal_Price;
		double sugarTotal = sugar_Qty * sugar_Price;
		double highlandTotal = highland_Qty * highland_Price;
		double yoghurtTotal = yoghurt_Qty * yoghurt_Price;
		double flourTotal = flour_Qty * flour_Price;
		double soapTotal = soap_Qty * soap_Price;
		//this shows total
		double total = basmathiTotal + dhalTotal + sugarTotal + highlandTotal + yoghurtTotal + flourTotal + soapTotal; 
		//below code represent discount code
		double discount_Add = total * 0.1;
		//this code represent final Price of after the discout add
		double final_Price = total - discount_Add;
		System.out.println("\n");
		
		
		System.out.println("+---------------------------------------------------------------+");
		System.out.println("|                _   __  __          _____ _______               |");
		System.out.println("|               (_) |  \\/  |   /\\   |  __ \\__   __|              |");
		System.out.println("|                _  | \\  / |  /  \\  | |__) | | |                 |");
		System.out.println("|               | | | |\\/| | / /\\ \\ |  _  /  | |                 |");
	    System.out.println("|               | | | |  | |/ ____ \\| | \\ \\  | |                 |");
		System.out.println("|               |_| |_|  |_/_/    \\_\\_|  \\_\\ |_|                 |");
		System.out.println("|                    225,Galle Road,Panadura.                    |");
		System.out.println("|                                                                |");
		System.out.println("+----------------------------------------------------------------+");
		System.out.printf("|                        # Tel  : %-30s | \n" , c_tel);
		System.out.printf("|                        # Name : %-30s | \n" , c_name);
		System.out.println("+-----------------+-----------+----------------+-----------------+");
		System.out.println("|                 |   Qty     |    Unit price  |     Price       |");
		System.out.println("+-----------------+-----------+----------------+-----------------+");
		System.out.printf("| # Basmathi      |   %-8d|      %-10.1f|       %-10.1f| \n",basmathi_Qty,basmathi_Price,basmathiTotal);
		System.out.printf("| # Dhal          |   %-8d|      %-10.1f|       %-10.1f| \n",dhal_Qty,dhal_Price,dhalTotal);
		System.out.printf("| # Hignland      |   %-8d|      %-10.1f|       %-10.1f| \n",highland_Qty,highland_Price,highlandTotal);
		System.out.printf("| # Yoghurt       |   %-8d|      %-10.1f|       %-10.1f| \n",yoghurt_Qty,yoghurt_Price,yoghurtTotal);
		System.out.printf("| # Sugar         |   %-8d|      %-10.1f|       %-10.1f| \n",sugar_Qty,sugar_Price,sugarTotal);
		System.out.printf("| # Flour         |   %-8d|      %-10.1f|       %-10.1f| \n",flour_Qty,flour_Price,flourTotal);
		System.out.printf("| # Soap          |   %-8d|      %-10.1f|       %-10.1f| \n",soap_Qty,soap_Price,soapTotal);
		System.out.println("+-----------------+-----------+----------------+-----------------+");
		System.out.printf("|                             |  Total         |       %-10.1f| \n",total);
		System.out.println("|                             +----------------+-----------------+");
		System.out.printf("|                             |  Discount(10%%) |       %-10.1f| \n",discount_Add);
		System.out.println("|                             +----------------+-----------------+");
		System.out.printf("|                             |  Price         |       %-10.1f| \n",final_Price);
		System.out.println("+-----------------+-----------+----------------+-----------------+");
	}
}
