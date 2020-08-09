package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2105_디저트카페 {
	public static int N;
	public static int map[][];
	public static int ax[] = { 1, -1, -1, 1 };
	public static int ay[] = { 1, 1, -1, -1 };
	public static int count=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int visited[];

			visited = new int[(N - 1) * 2+1];
			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					circuit(j, i, 0, 0,0,1,visited);
				}
			}
			count = count==0?-1:count;
			sb.append("#" + t + " "+ count+"\n");
			count = 0;
		}
		System.out.println(sb);
	}

	private static void circuit(int nowX, int nowY, int to, int xC, int yC,int idx,int visited[]) {
		if(idx==(xC+yC)*2+1&&to==3) {
			int tmp=0;
			for(int i=1; i<visited.length; i++) {
				if(visited[i]==0) { tmp = i; break;}
				for(int j=1; j<visited.length; j++) {
					if(visited[j]==0) break;
					if(i!=j && visited[i]==visited[j]) {
						return;
					}
				}
			}
			
			tmp = tmp==0?visited.length:tmp;
			if(count<tmp-1) {
				count=tmp-1;
			}
			return;
		}
		if(idx==(N - 1) * 2+1) return;
		if(to>=2&& (xC+yC)*2<=count) return;
		//안꺾는경우 보내
		int nextX = nowX + ax[to];
		int nextY = nowY + ay[to];
		if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
			if(to==0) {
				visited[idx] = map[nowY][nowX];
				circuit(nextX, nextY, to, xC+1, yC, idx+1, visited);
				visited[idx] = 0;
			}else if(to==1) {
				visited[idx] = map[nowY][nowX];
				circuit(nextX, nextY, to, xC, yC+1, idx+1, visited);
				visited[idx] = 0;
			}else {
				if(to==2&& idx-yC-xC-1==xC) {}
				else {
					visited[idx] = map[nowY][nowX];
					circuit(nextX, nextY, to, xC, yC, idx+1, visited);
					visited[idx] = 0;
				}
			}
				
		}
		if(xC==0) return;
		//꺾는경우 1 보내
		if(to==2 && idx<=xC*2+yC) return;
		if(to==3) return;
		nextX = nowX+ax[to+1];
		nextY = nowY+ay[to+1];
		if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N){
			visited[idx] = map[nowY][nowX];
			if(to==0)
				circuit(nextX, nextY, to+1, xC, yC+1, idx+1, visited);
			else
				circuit(nextX, nextY, to+1, xC, yC, idx+1, visited);
			visited[idx] = 0;
		}
	}
}
