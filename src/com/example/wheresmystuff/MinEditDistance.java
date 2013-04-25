package com.example.wheresmystuff;

public class MinEditDistance {

	public static int minEdit(String a, String b) {

		int i = a.length();
		int j = b.length();

		int array[][] = new int[i + 1][j + 1];

		

		for (int index = 0; index <= i; index++) {
			array[index][0] = index;
		}

		for (int index2 = 0; index2 <= j; index2++) {
			array[0][index2] = index2;
		}
		array[0][0] = 0;
		for (int row = 1; row <= i; ++row) {

			for (int col = 1; col <= j; ++col) {
				if (a.charAt(row - 1) == b.charAt(col - 1)) {
					array[row][col] = array[row - 1][col - 1];
				} else {
					int min1 = Math.min(array[row - 1][col] + 1,
							array[row][col - 1] + 1);
					int min2 = Math.min(array[row - 1][col - 1] + 1, min1);
					array[row][col] = min2;
				}
			}
		}

		return array[i][j];
	}

}
