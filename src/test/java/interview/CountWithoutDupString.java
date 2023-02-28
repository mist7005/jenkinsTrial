package interview;

public class CountWithoutDupString {

	public static void main(String[] args) {
		String s="pankaj is a good boy good pankaj";
		String str[]=s.split(" ");
		
		boolean s1[]=new boolean[str.length];
		for (int i = 0; i < str.length; i++) {
			if(s1[i]==false)
			{
				int count=0;
				for (int j = 0; j < str.length; j++) {
					if(str[i].equals(str[j]))
					{
						count++;
						s1[j]=true;
					}
				}
				System.out.println(str[i]+"=====>"+count);
			}
		}

	}

}
