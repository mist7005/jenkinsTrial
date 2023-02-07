package interview;

public class CharacterInAStringNotDup {

	public static void main(String[] args) {
		
		String s="pankaj";
		int arr[]=new int[126];
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)]=arr[s.charAt(i)]+1;
		}
		
		for (int i = 0; i < s.length(); i++) {
			if(arr[s.charAt(i)]>0)
			{
				System.out.println(s.charAt(i)+" count==>  ");
			}
		}
	}

}
