package tyss;

public class FetchProdPrice {

	public static void main(String[] args) {
		String s="i have 1000 products";
		String str[]=s.split(" ");

		for (int i = 0; i < str.length; i++) 
		{
			try 
			{
				System.out.println(Integer.parseInt(str[i]));
			} 
			catch (Exception e) {
			}
		}
	}
}


