package interview;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class StringProb {

	public static void main(String[] args) {
		
//		String s1="HelloY";
//		for (int i = 0; i < s1.length(); i++) {
//			if(s1.charAt(i)>='a'&& s1.charAt(i)<='z')
//			{
//				System.out.println((char)(s1.charAt(i)-32));
//			}
//		}
//		
		
	
		
		
		
//		String s[]= {"good","hi","Java","Python","bye"};
//		for (int i = 0; i < s.length; i++) {
//			if(i!=0&&i!=s.length-1)
//			{
//				System.out.println(s[i]);
//			}
//		}
		
//		String s2="cabbdef";
//		
//		int a[]=new int[126];
//		for (int i = 0; i < s2.length(); i++) {
//			a[s2.charAt(i)]++;
//		}
//		int x=0;
//		for (int i = 0; i < a.length; i++) {
//			if(a[s2.charAt(x)]==1)
//			{
//				System.out.println(s2.charAt(x));
//				break;
//			}
//			x++;
//		}
		
		
		
		String s="a12b10z10";
		String z=s.replaceAll("[0-9]", " " ).trim();
		String str[]=z.split(" ");
		int sum=0;
		for (int i = 0; i < str.length; i++) {
			sum=sum+Integer.parseInt(str[i]);
		}
		System.out.println(sum);
		
	}

}
