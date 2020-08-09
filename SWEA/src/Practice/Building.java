package Practice;

import java.util.Scanner;

public class Building {

	public static void main(String[] args) {

		StringBuffer stringBuffer = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		final int T = 10;
		int test_length = 0, sum = 0;
		int[] array;
		for (int test_case = 1; test_case <= T; test_case++) {
			sum=0;
			test_length = sc.nextInt();
			array = new int[test_length + 4];
			for (int j = 1; j <= test_length; j++) {
				array[j + 1] = sc.nextInt();
			}
			for (int j = 1; j <= test_length; j++) {
				if (array[j + 1] > array[j - 1] && array[j + 1] > array[j] && array[j + 1] > array[j + 2]
						&& array[j + 1] > array[j + 3]) {
					sum+=(array[j+1]-(array[j-1]> array[j]&& array[j-1]>array[j+2] && array[j-1]>array[j+3]? array[j-1]: 
						((array[j]> array[j+2])&&(array[j]>array[j+3]) 
								? array[j]: (array[j+3]> array[j+2]? array[j+3]: array[j+2]))));
				}
			}
			stringBuffer.append("#" + test_case + " " + sum +"\n");
		}
		System.out.println(stringBuffer.toString());
		sc.close();
	}
}
