package interview;

public class CountOfCharacters {

	public static void main(String[] args) {
		String s="pankaj";
		boolean[] b=new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {

			if(b[i]==false)
			{
				int count=0;
				for (int j = 0; j < s.length(); j++) {
					if(s.charAt(i)==s.charAt(j))
					{
						count++;
						b[j]=true;
					}
				}
				System.out.println(s.charAt(i)+" count==> "+count);
			}

		}
	}

}
