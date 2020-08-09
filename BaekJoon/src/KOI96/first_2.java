package KOI96;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class first_2 {

	static int N=0;
	static int arr[];
	static int start=0;
	static boolean visited[];
	
	static ArrayList<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int [N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i=0; i<N;i++) {
			visited[i] = true;
			start = i+1;
			dfs(i);
			visited[i] = false;
		}
		System.out.println(result.size());
		Collections.sort(result);
		for(int a: result) {
			System.out.println(a);
		}
	}
	
	private static void dfs(int i) {
		if(!visited[arr[i]-1]) {
			visited[arr[i]-1] = true;
			dfs(arr[i]-1);
			visited[arr[i]-1] = false;
		}
		if(arr[i] == start) {
			result.add(i+1);
		}
	}
}
