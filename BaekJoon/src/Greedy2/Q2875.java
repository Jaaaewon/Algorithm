package Greedy2;
// 여자 N 남자 M 인턴참여 K -> N ? 2M 누가 더 큰지 비교.
// -> N ? 2M 중 더 큰 수에서 1~K만큼 차례대로 인원 수 제거.
// -> 제거 하면서, 계속 N ? 2M 비교 해야함.
// N M - 짝 갯수 N이 2배 M은 1배 가 짝임. 큰수 비교해서 N= /2 M = M

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2875 {
	private static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		greedy(n, m, k);
		System.out.println(cnt);
		
		for(int i=0; i<k; i++) {
			if(n>=2*m) n-=1;
			else m-=1;
		}
		System.out.println(n >= 2*m ? m : n/2);
	}
	private static void greedy(int n, int m, int k) {
		if(k==0) {
			cnt = n >= 2*m ? m : n/2;
			return;
		}
		else {
			if(n >= 2*m) {
				if(k>=2) greedy(n-2, m, k-2);
				else greedy(n-1, m, k-1);
			}
			else 
				greedy(n, m-1, k-1);	
		}
	}
}
