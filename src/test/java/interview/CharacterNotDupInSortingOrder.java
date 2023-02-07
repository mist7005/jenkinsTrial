package interview;

import java.util.Arrays;

public class CharacterNotDupInSortingOrder {

	public static void main(String[] args) {
		String s="pankaj";
		char ch1[]=s.toCharArray();
		Arrays.sort(ch1);
		boolean b[]=new boolean[ch1.length];
		for (int i = 0; i < ch1.length; i++) {
			if(b[i]==false)
			{
				int count=0;
			for (int j = 0; j < ch1.length; j++) {
				if(ch1[i]==ch1[j])
				{
						b[i]=true;
						count++;
				}
			}
			if(count==1)
			{
				System.out.println(ch1[i]);
			}
			}
		}
//		int[] a=new int[126];
//		for (int i = 0; i < s.length(); i++) {
//			a[s.charAt(i)]++;
//		}
//		String z="";
//		for (int i = 0; i < s.length(); i++) {
//			if(a[s.charAt(i)]==1)
//			{
//				z=z+s.charAt(i);	
//
//			}
//		}
////		System.out.println(z);
//		char ch[]=z.toCharArray();
//		for (int i = 0; i < ch.length; i++) {
//			for (int j = 0; j < ch.length; j++) {
//				if(ch[i]<ch[j])
//				{
//					char temp=ch[i];
//					ch[i]=ch[j];
//					ch[j]=temp;
//				}
//			}
//		}
//		for (int i = 0; i < ch.length; i++) {
//			System.out.println(ch[i]+"  "+(int)(ch[i]));
//		}
	}
}



