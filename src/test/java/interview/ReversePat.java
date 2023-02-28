package interview;

public class ReversePat {

	public static void main(String[] args) {
//		String str="i am asim";
		String s="i am asim".replaceAll(" ", "");
		System.out.println(s);
		String rev="";
		
		
		for (int i = 0; i < s.length(); i++) {
			rev=rev+(s.charAt(i));
			if(i%3==0)
			{
				rev=rev+" ";
			}
		}
//		System.out.println(rev);
		rev=rev.trim();
		for (int i = 0; i < rev.length(); i++) {
			System.out.print(rev.charAt(rev.length()-1-i));
		}
	}

}
