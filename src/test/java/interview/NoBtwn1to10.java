package interview;

public class NoBtwn1to10 {

	public static void main(String[] args) {
		int ar[]= {1,5,8};
		for (int i = 0; i < ar.length-1; i++) {
			int c=ar[i+1]-ar[i];
			int count=1;
			
			while(c>1)
			{
				System.out.println(ar[i]+count);
				c--;
				count++;
			}
				
			
			
		}
	}

}
