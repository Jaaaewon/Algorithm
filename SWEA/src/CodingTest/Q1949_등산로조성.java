package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1949_등산로조성 {
	static int N, K,count;
	static int map[][];
	static Queue<Pair> q;
	static int ax[] = {0,0,-1,1};
	static int ay[] = {-1,1,0,0};
	static class Pair{
		int x,y,v,prex,prey;
		boolean usedK;
		Pair(int x, int y, int prex, int prey, int v, boolean usedK){
			this.x=x;
			this.y=y;
			this.prex =prex;
			this.prey=prey;
			this.v=v;
			this.usedK =usedK;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new int [N][N];
			int max = 0;
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]>max) max = map[i][j];
				}
			}
			q = new LinkedList<Pair>();
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==max) {
						q.offer(new Pair(j,i,-1,-1,map[i][j],false));
					}
				}
			}
//			q.offer(new Pair(4,2,-1,-1,map[2][4],false));
			count = 0;
			while(!q.isEmpty()) {
				int size = q.size();
				count++;
				for(int i=0; i<size; i++) {
					Pair now = q.poll();
//					if(count==2)
//						System.out.println(now.y+" "+now.x+" "+now.usedK);
					bfs(now);
				}
			}
			sb.append("#"+ t +" "+count +"\n");
//			System.out.println(count);
		}
		System.out.println(sb);
	}
	static void bfs(Pair now) {
		for(int i=0; i<4; i++) {
			int nextX = now.x+ax[i];
			int nextY = now.y+ay[i];
			if(nextX<0||nextX>=N||nextY<0||nextY>=N||(nextX==now.prex&&nextY==now.prey)) continue;;

			// 정상적 경우 진행하면됨.
			if(map[nextY][nextX]<now.v) {
				q.offer(new Pair(nextX, nextY,now.x,now.y, map[nextY][nextX],now.usedK));
			}else {
				// usedK가 false면 깎을수 있다는 뜻임.
				if(now.usedK==false && map[nextY][nextX]-K<now.v) {
					if(now.y==0&&now.x==1&& count==5) {
						System.out.println(nextY+" "+nextX+" "+now.y+" "+now.x+" "+now.usedK);
					}
//					System.out.println("깎음 " +nextY+" "+nextX+" v "+(now.v-1));
					q.offer(new Pair(nextX, nextY,now.x,now.y, now.v-1, true));
				}
				// 깎고 범위 해당되면 정상으로 진행. usedK=true ㅇㅋ
			}
		}
	}
}
