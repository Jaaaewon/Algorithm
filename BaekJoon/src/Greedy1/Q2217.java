package Greedy1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q2217 {
	private static int num;
	private static int arr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		arr = new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(greedyMax());
	} 
	public static int greedyMax1() {
		int max = arr[num-1];
		int loop = 1;
		for(int i=num-1;i>=0;i--) {
			if(max <= loop* arr[i]) {
				max = loop*arr[i];
			}
		}
		return max;
	}
	public static int greedyMax() {
		Arrays.sort(arr);
		int max = arr[num-1];
		for(int j=0;j<num;j++) {
			for(int i=num-j;i>=1;i--) {
				if(arr[j]*i<=max)
					break;
				if(arr[j]*i>max )
					max = arr[j]*i;
			}
		}
		return max;
	}
}
