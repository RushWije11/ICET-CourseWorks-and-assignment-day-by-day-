import java.util.*;
class Q20 {
	public static void main(String[]args){
		char vowels1[]={'A','E','I','O','U'};
		char vowels2[]={'a','e','i','o','u'};
		
		char[] temp1=new char[vowels1.length+vowels2.length];
		
		for (int i = 0; i < vowels1.length; i++) {
			temp1[i] = vowels1[i];
		}
		for (int i = 0; i < vowels2.length; i++) {
			temp1[vowels1.length + i] = vowels2[i];
		}
		System.out.println(Arrays.toString(temp1));
		char[] temp2=new char[vowels1.length+vowels2.length];
		
		for(int i=0;i<vowels1.length;i++){
			temp2[i*2]=vowels1[i];
			temp2[i*2+1]=vowels2[i];
		}
		System.out.println(Arrays.toString(temp2));
		
		char[] temp3 = new char[vowels1.length + vowels2.length];

		for (int i = 0; i < vowels1.length; i++) {
			temp3[i * 2] = vowels1[vowels1.length - 1 - i];     
			temp3[i * 2 + 1] = vowels2[vowels2.length - 1 - i];
		}
		System.out.println(Arrays.toString(temp3));
		char[] temp4 = new char[vowels1.length + vowels2.length];

		for (int i = 0; i < vowels1.length; i++) {
			temp4[i * 2] = vowels1[i];     
			temp4[i * 2 + 1] = vowels2[vowels2.length - 1 - i];
		}
		System.out.println(Arrays.toString(temp4));
	}
}
