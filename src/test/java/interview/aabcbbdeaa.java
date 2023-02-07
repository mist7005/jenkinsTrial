package interview;

public class aabcbbdeaa {

	public static void main(String[] args) {
		String ss="I am Selenium";
		char str[]=ss.toCharArray();
		StringBuffer s=new StringBuffer("I am Selenium").reverse();
		String z=s.toString().replaceAll(" ", "");
		int x=0;
		for (int i = 0; i <str.length; i++) {
			if(str[i]!=' ')
			{
				str[i]=z.charAt(x);
				x++;
			}
		}
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i]);
		}

//		String s1="aabcbbdeaa";
//		for (int i = 0; i < str.length; i++) {
//			
//		}
	}
	
}
