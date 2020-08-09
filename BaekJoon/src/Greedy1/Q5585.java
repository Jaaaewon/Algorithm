package Greedy1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5585 {
	private static int arr[] = {500, 100, 50, 10, 5, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		System.out.println(greedyCoin(num));
	}
	
	public static int greedyCoin(int num) {
		int res=0;
		num = 1000 - num;
		for(int i=0; i<arr.length; i++) {
			res += num/arr[i];
			num %= arr[i];
		}
		return res;
	}
}
