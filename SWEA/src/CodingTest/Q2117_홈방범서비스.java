package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2117_홈방범서비스 {
	private static int N, M, HC = 0, max = 0;
	private static int home[][];

	static public void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			home = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					home[i][j] = Integer.parseInt(st.nextToken());
					if (home[i][j] == 1)
						HC++;
				}
			}
			int maxK=0;
			for (int i = 0; i < Integer.MAX_VALUE; i++) {
				if(!possible(HC, i)) {
					maxK = i-1;
					break;
				}
			}
			int flag = 0;
			for (int i = 0; i < maxK; i++) {
				flag += i;
			}
			secure(maxK, flag);
			sb.append("#"+ t + " "+ max+"\n");
			max = 0;
		}
		System.out.println(sb);
	}
	private static boolean possible(int hc, int k) {
		if(M*hc>= (k*k)+(k-1)*(k-1))
			return true;
		return false;
	}
	private static void secure(int maxK, int flag) {
		if (max == 0 && maxK == 1) {
			max = 1;
			return;
		}
		// max가 전 크기 마름모 개수보다 커지면 멈춰도됨.
		if (max >= (maxK + maxK - 1) * (maxK + maxK - 1) - 4 * flag)
			return;
		if (maxK == 0)
			return;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int hc = countHome(i, j, maxK);
				if(hc<max) continue;
				else {
					if (possible(hc, maxK)) {
						max = hc;
						return;
					}
				}
			}
		}
		secure(maxK - 1, flag - maxK + 1);
	}
	private static int countHome(int i, int j, int maxK) {
		int count = 0;
		int up = (i - maxK + 1) >= 0 ? (i - maxK + 1) : 0;
		int down = (i + maxK - 1) < N ? (i + maxK - 1) : N - 1;
		int left = (j - maxK + 1) >= 0 ? (j - maxK + 1) : 0;
		int right = (j + maxK - 1) < N ? (j + maxK - 1) : N - 1;
		for(int c = up;c<=down; c++) {
			for(int d=left; d<=right; d++) {
				if(home[c][d]==1) {
					if(Math.abs(c-i)+ Math.abs(d-j)<=maxK-1) {
						count++;
					}
				}
			}
		}
		return count;
	}
}
