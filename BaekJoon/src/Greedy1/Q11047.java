package Greedy1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11047 {
	private static int valueArr[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int total = Integer.parseInt(st.nextToken());
		
		valueArr = new int[num];
		for(int i=0; i<valueArr.length; i++) {
			valueArr[i] = Integer.parseInt(br.readLine());
		}
		System.out.println(greedyCoin(total));
		br.close();
	}
	public static int greedyCoin(int total) {
		int coinNum = 0;
		
		for(int i=valueArr.length-1; i>=0; i--) {
			coinNum += total / valueArr[i];
			total %= valueArr[i];
		}
		return coinNum;
	}
}
