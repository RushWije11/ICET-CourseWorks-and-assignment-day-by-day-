import java.util.*;
class Q45 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the size : ");
		int size = input.nextInt();
		System.out.print(" * | ");
		for(int i = 1; i<=size;i++){

			System.out.print(" "+i+" ");
		}
			System.out.println();
			for(int b = 1; b<=size;b++){
				System.out.print("----");
			
			}
			System.out.println();
		for(int d = 1 ;d<=size;d++){
			System.out.print(" "+d+" |  ");
			
			
			for(int j = 1 ;j<=size ; j++){
				System.out.print((d*j) +"  ");
				}
			System.out.println();
		}
	}
}
