package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2112_보호필름 {
	private static int D,W,K,min;
//	private static boolean visited[];
	private static boolean [][]film;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new boolean[D][W];
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken())==1?true:false;
				}
			}
//			visited = new boolean[D];
			min = K;
			if(min!=1)
				insert(0,0);
			else min = 0;
			sb.append("#" + t + " "+min+"\n");
		}
		System.out.println(sb.toString());
	}
	private static void insert(int count,int idx) {
		if(count>=min) return;
		
		if(idx==D) {
			for(int i=0; i<W; i++) {
				if(!possible(i)) return;
			}
			if(min>count)
				min = count;
			return;
		}
		// 성능검사 통과 못하면 해당 열 , 값 건네줘서 insert
		
		
		insert(count, idx+1);

		boolean copyfilm[] = new boolean[W];
		boolean n = true;
		for(int j=0; j<W; j++) {
			copyfilm[j] = film[idx][j];
			film[idx][j] = n;
		}
		
		insert(count+1, idx+1);
		
		n = false;
		for(int j=0; j<W; j++)
			film[idx][j] = n;
		insert(count+1, idx+1);
		
		for(int j=0; j<W; j++) {
			film[idx][j]=copyfilm[j];
		}
	}
	private static boolean possible(int row) {
		boolean tmp =film[0][row];
		int cnt=1;
		boolean v;
		for(int i=1; i<D;i++) {
			v = film[i][row];
			if(v==tmp) {
				cnt++;
				if(cnt==K) return true;
			}else {
				if(i==D-K+1) return false;
				tmp = v;
				cnt = 1;
			}
		}
		return false;
	}
}
