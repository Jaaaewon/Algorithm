package Greedy1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Q1931 {

	static int arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		arr = new int[num][2];
		
		StringTokenizer st;
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}
		//Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[1]));
		Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] arg0, int[] arg1) {
                if(arg0[1] == arg1[1]) {
                    return arg0[0] - arg1[0];
                } else {
                    return arg0[1] - arg1[1];
                }
            }
        });
		System.out.println(greedyMax());
	}
	public static int greedyMax() {
		int res=0;
		int end =-1;
		for(int i=0; i<arr.length; i++) {
			if(arr[i][0]>=end) {
				end = arr[i][1];
				res++;
			}
		}
		return res;
	}
}
