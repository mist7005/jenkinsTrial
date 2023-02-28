package tyss;

public class WelcomeToTyss {

	public static void main(String[] args) {
					//0    1  2
		String s="Welcome to Tyss";
		/*
		 * to Tyss Welcome
		 * Tyss Welcome to
		 * Welcome to Tyss
		 */

		String[] str= customSplit(s);
		
		int ar[]=new int[str.length];//0 1 2
		for (int i = 0; i < ar.length; i++) {
			ar[i]=i;
		}
		
		
		for (int i = 0; i < str.length; i++) {
			
			int temp=ar[0];
			for (int j = 1; j < ar.length; j++) {
				ar[j-1]=ar[j];
			}
			ar[ar.length-1]=temp;
			//1 2 0
			//2 0 1
			//0 1 2
			for (int j = 0; j < str.length; j++) {
				System.out.print(str[ar[j]]+" "); //to tyss welcome
												// tyss welcome to 
			}									// welcome to Tyss
			System.out.println();
		}
	}
	public static String[] customSplit(String s)
	{
		String ob[]=new String[1];
		int len=1;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)==' ')
				len++;
		}

		String str[]=new String[len];
		int x=0;
		String temp="";
		for (int j = 0; j < s.length(); j++) {

			if(s.charAt(j)!=' ')
			{
				temp=temp+s.charAt(j);
				str[x]=temp;
			}
			else
			{
				temp="";
				x++;
			}
		}
		ob=str;
		return ob;
	}
}
