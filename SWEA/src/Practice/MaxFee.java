package Practice;

import java.util.Scanner;

public class MaxFee {

	private static int count, maxprize;
	private static int[] array;
	public static void main(String[] args) {
		StringBuffer stringBuffer = new StringBuffer();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int change;
		String stringNum;
		for (int test_case = 1; test_case <= T; test_case++) {
			stringNum = sc.next();
			count = sc.nextInt();
			array = new int[stringNum.length()];
			maxprize=0;
			for (int i = 0; i < stringNum.length(); i++)
				array[i] = (stringNum.charAt(i) - '0');

			sortMaxPrize(0, 0);
			stringBuffer.append("#"+test_case+" "+ maxprize+"\n");
		}
		System.out.println(stringBuffer.toString());
		sc.close();
	}

	private static void sortMaxPrize(int change, int cur) {
		if (change == count) {
			int temp=0;
			for(int n : array) {
				temp *=10;
				temp += n;
			}
			maxprize = temp>maxprize?temp:maxprize;
			return;
		}
		for (int i = cur; i < array.length; i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]<=array[j]) {
					swap(i,j);
					sortMaxPrize(change+1, i);
					swap(i,j);
				}
			}
		}
	}

	private static void swap(int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
}
