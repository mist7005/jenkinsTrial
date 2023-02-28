package tyss;

import java.util.ArrayList;

public class Matrix {

	public static void main(String[] args) {
		int ar[][]= {{2,6,3},{7,11,22},{15,21,4}};
		
		ArrayList<Integer> even=new ArrayList<>();
		ArrayList<Integer> odd=new ArrayList<>();
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar.length; j++) {
				if(ar[i][j]%2==0)
				{
					even.add(ar[i][j]);
				}
				else
				{
					odd.add(ar[i][j]);
				}
			}
		}
		for (Integer integer : even) {
			System.out.print(integer+" ");
		}
		System.out.println();
		for (Integer integer : odd) {
			System.out.print(integer+" ");
		}
	}
}
