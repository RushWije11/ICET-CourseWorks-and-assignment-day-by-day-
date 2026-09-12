import java.util.*;
class Q19 {
	public static void selectRandom(){
		Scanner input =new Scanner(System.in);
		
		System.out.print("Enter name : ");
		String name =input.nextLine();
		
		String[] group01 = {
			"Business & Accounting","Geography","Citizenship Education ","Entrepreneurship studies","2nd Language Sinhala",
			"2nd Language Tamil","Foreign Languages"
		};
		
		String[] foreignLanguage = {"Arabic","Hindi","French","Japan"};
		
		String[] group02 = {"Art","Tamil Literature","English Literature","Sinhala Literature","Music","Dancing" };
		
		String[] group03 = {"Information & technology","Agriculture","Home Economics","Health Science","Art & Craft","Media"};
		
		Random r =new Random();
		
		String subject1 = group01[r.nextInt (group01.length)];
		if(subject1==group01[6]){
			String selectlanguage = foreignLanguage[r.nextInt(foreignLanguage.length)];
			subject1= "Foreign Language : "+selectlanguage;
		}
		String subject2 = group02[r.nextInt (group02.length)];
		String subject3 = group03[r.nextInt (group03.length)];
		
		System.out.println(name+" has selected random subject in the system \n ");
		System.out.println("              First  Subject: "+subject1);
		System.out.println("              Second Subject: "+subject2);
		System.out.println("              Third  Subject: "+subject3);
		
		
	}
	public static void main(){
		selectRandom();
	}
}
