package interview;

public class MatrixOddEven {

	public static void main(String[] args) {
		
		int ar[][] = {{2,1,7},{13,16,5},{11,19,20}};
		String odd="";
		String even="";
		
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				if(ar[i][j]%2!=0)
				{
					odd=odd+ar[i][j]+"|";
				}
				else
				{
					even=even+ar[i][j]+"|";
				}
			}
		}
		String oddStr[]=odd.split("[|]");
		
		String evenStr[]=even.split("[|]");
		int oddArr[]=new int[oddStr.length];
		int evenArr[]=new int[evenStr.length];
		for (int i = 0; i < oddArr.length; i++) {
			oddArr[i]=Integer.parseInt(oddStr[i]);
		}
		for (int i = 0; i < evenArr.length; i++) {
			evenArr[i]=Integer.parseInt(evenStr[i]);
		}
		
		for (int i = 0; i < evenArr.length; i++) {
			System.out.print(evenArr[i]+" ");
		}
		System.out.println();
		for (int i = 0; i < oddArr.length; i++) {
			System.out.print(oddArr[i]+" ");
		}
	}

}
