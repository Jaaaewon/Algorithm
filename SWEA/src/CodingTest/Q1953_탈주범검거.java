package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q1953_Å»ÁÖ¹ü°Ë°Å {
	private static int N,M,R,C,L,count=1;
	private static int map[][];
	private static int ax[] = {0,0,-1,1};
	private static int ay[] = {-1,1,0,0};
	private static boolean[][] visited;
	private static Queue<Pair> q;
	static class Pair{
		int x,y;
		Pair(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int [N][M];
			visited = new boolean[N][M];
			for(int i=0;i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<M;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			q = new LinkedList<Pair>();
			visited[R][C] = true;
			q.offer(new Pair(C,R));
			int cnt=0;
			while(!q.isEmpty()) {
				int size = q.size();
				if(++cnt>=L) break;
				for(int i=0; i<size; i++) {
					Pair now = q.poll();
					find(now.x, now.y ,q);
				}
			}
			sb.append("#" + t+" "+count+"\n");
			count=1;
		}
		System.out.println(sb);
	}
	private static void find(int nowX, int nowY, Queue<Pair> qu) {
		
		for(int i=0; i<4; i++) {
				
			int nextX = nowX+ax[i];
			int nextY = nowY+ay[i];
			
			if(nextX<0||nextX>=M||nextY<0||nextY>=N) continue;
			if(map[nextY][nextX]==0||visited[nextY][nextX]) continue;
			int direction = possible(i,map[nowY][nowX]);
			if(i==2&&(direction==1||direction==3||direction==6||direction==7)) {
				if(left(nextX,nextY)){
					if(!visited[nextY][nextX]) {
						count++;
						visited[nextY][nextX] = true;
						qu.offer(new Pair(nextX,nextY));
					}
					continue;
				}
			}
			if(i==3&&(direction==1||direction==3||direction==4||direction==5)) {
				if(right(nextX,nextY)){
					if(!visited[nextY][nextX]) {
						count++;
						visited[nextY][nextX] = true;
						qu.offer(new Pair(nextX,nextY));
					}
					continue;
				}
			}
			if(i==0&&(direction==1||direction==2||direction==4||direction==7)) {
				if(up(nextX,nextY)){
					if(!visited[nextY][nextX]) {
						count++;
						visited[nextY][nextX] = true;
						qu.offer(new Pair(nextX,nextY));
					}
					continue;
				}
			}
			if(i==1&&(direction==1||direction==2||direction==5||direction==6)) {
				if(down(nextX,nextY)) {
					if(!visited[nextY][nextX]) {
						count++;
						visited[nextY][nextX] = true;
						qu.offer(new Pair(nextX,nextY));
					}
					continue;
				}
			}
		}
	}
	private static int possible(int to, int pipe) {
		if(pipe==1) return 1;
		else if(pipe==2) {
			if(to==0||to==1) return 2;
		}else if(pipe==3) {
			if(to==2||to==3) return 3;
		}else if(pipe==4) {
			if(to==0||to==3) return 4;
		}else if(pipe==5) {
			if(to==1||to==3) return 5;
		}else if(pipe==6) {
			if(to==1||to==2) return 6;
		}else if(pipe==7) {
			if(to==0||to==2) return 7;
		}
		return 0;
	}
	private static boolean left(int nextX, int nextY) {
		if(map[nextY][nextX]==1||map[nextY][nextX]==3
				||map[nextY][nextX]==4||map[nextY][nextX]==5)
			return true;
		return false;
	}
	private static boolean right(int nextX, int nextY) {
		if(map[nextY][nextX]==1||map[nextY][nextX]==3
				||map[nextY][nextX]==7||map[nextY][nextX]==6)
			return true;
		return false;
	}
	private static boolean up(int nextX, int nextY) {
		if(map[nextY][nextX]==1 || map[nextY][nextX]==2
				|| map[nextY][nextX]==6 || map[nextY][nextX]==5)
			return true;
		return false;
	}
	private static boolean down(int nextX, int nextY) {
		if(map[nextY][nextX]==1||map[nextY][nextX]==2
				||map[nextY][nextX]==4||map[nextY][nextX]==7)
			return true;
		return false;
	}
}
