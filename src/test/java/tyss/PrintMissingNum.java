package tyss;

public class PrintMissingNum {

	public static void main(String[] args) {
		int a[]= {1,2,8};
		for (int i = 1; i < 8; i++) {
			boolean print= checkIfPresent(i,a);
			if(print)
			{
				System.out.println(i);
			}
		}
	}

	private static boolean checkIfPresent(int i, int[] a) {
		for (int j = 0; j < a.length; j++) {
			if (i==a[j]) {
				return false;
			}
		}

		return true;
	}

}
