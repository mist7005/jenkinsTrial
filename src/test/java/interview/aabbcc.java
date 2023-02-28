package interview;

public class aabbcc {

	public static void main(String[] args) {
		String s="aabcbbdeaa";
		//		for (int i = 0; i < s.length()-1; i++) {
		//			System.out.println(s.substring(i,i+2));
		//		}

		for (int i = 0; i < s.length()-1; i++) {
			for (int j = i; j < i+2; j++) {
				System.out.print(s.charAt(j));
			}
			System.out.println();
		}
	}
}
