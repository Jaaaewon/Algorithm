package Greedy1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[num];
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(greedyResult(arr));
		
	}
	public static int greedyResult(int arr[]) {
		Arrays.sort(arr);
		int min = arr[0];
		for(int i=1; i<arr.length; i++) {
			arr[i] += arr[i-1];
			min += arr[i];
		}
		return min;
	}
}