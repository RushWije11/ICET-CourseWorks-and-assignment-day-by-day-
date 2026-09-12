import java.util.*;
class Q23 {
	public static int vowelCount(String word){
		
		
		int vowel_count = 0;
		for(int i=0;i<word.length();i++){
			char ch = word.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
			   ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
			   
			   vowel_count++;
			}
		}
		return vowel_count;
	}
	public static void main(){
	Scanner input = new Scanner(System.in);
		
		System.out.print("Enter String Word : ");
		String in_word = input.nextLine();
		int v_count = vowelCount(in_word);
		System.out.println("There are "+v_count+" vowels in this word");
	}
}
