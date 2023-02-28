package tyss;

public class RegexPrac {

	public static void main(String[] args) {
		String s="12a%bhi34@$";
		
		System.out.println(s.replaceAll("[^a-z]", ""));
		System.out.println(s.replaceAll("[^0-9]", ""));
		System.out.println(s.replaceAll("[^$ % @]", ""));
	}

}
