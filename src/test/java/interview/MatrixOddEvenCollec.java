package interview;

import java.util.ArrayList;

public class MatrixOddEvenCollec {

	public static void main(String[] args) {
		int ar[][] = {{2,1,7},{13,16,5},{11,19,20}};
		
		ArrayList<Integer> oddList=new ArrayList<>();
		ArrayList<Integer> evenList=new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				if(ar[i][j]%2!=0)
				{
					oddList.add(ar[i][j]);
				}
				else
				{
					evenList.add(ar[i][j]);
				}
			}
		}
		for (Integer integer : evenList) {
			System.out.print(integer+" ");
		}
		System.out.println();
		for (Integer integer : oddList) {
			System.out.print(integer+" ");
		}
	}

}
