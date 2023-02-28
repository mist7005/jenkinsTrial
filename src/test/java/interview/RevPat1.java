package interview;

import java.util.Iterator;

public class RevPat1 {

	public static void main(String[] args) {
		String s="This is my interview";
		String str[]=s.split(" ");
		String temp1=str[1];
		str[1]=str[2];
		str[2]=temp1;
		String revVal="";
		for (int i = 0; i < str.length; i++) {
			String temp=str[i];
			for (int j = 0; j < temp.length(); j++) {
				revVal=revVal+temp.charAt(temp.length()-1-j);
			}
			revVal=revVal+" ";
		}
		System.out.println(revVal);
		revVal=revVal.trim();
		for (int i = 0; i < revVal.length(); i++) {
			System.out.print(revVal.charAt(revVal.length()-1-i));
		}
	}

}
