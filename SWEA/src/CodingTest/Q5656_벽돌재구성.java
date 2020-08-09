package CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5656_벽돌재구성 {
	static int N, W, H;
	static int total = 0;
	static int ax[] = { 0, 0, -1, 1 };
	static int ay[] = { -1, 1, 0, 0 };
	static Queue<Integer> q= new LinkedList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			int map[][] = new int[H][W];
			for (int h = 0; h < H; h++) {
				st = new StringTokenizer(br.readLine());
				for (int w = 0; w < W; w++) {
					map[h][w] = Integer.parseInt(st.nextToken());
				}
			}
			total = Integer.MAX_VALUE;
			dfs(map, 0);
			if(total==Integer.MAX_VALUE)
				total = 0;
			sb.append("#" + t + " "+ total+ "\n" );
			total = 0;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	static int count(int[][] map) {
		int c=0;
		for(int i=0; i<H; i++) {
			for(int j=0; j<W; j++) {
				if(map[i][j]!=0) c++;
			}
		}
		return c;
	}

	static void dfs(int[][] map, int n) {
		if (n == N) {
			total = Math.min(count(map), total);
			
			return;
		}
		
		int copymap[][] = new int[H][W];
		
		for (int w = 0; w < W; w++) {
			copymap = copyMap(map);
			for (int h = 0; h < H; h++) {
				if (map[h][w] == 0)
					continue;
				boom(h, w, copymap);
				copymap = downSort(copymap);
				dfs(copymap,n+1);
				break;
			}
		}
	}

	static void boom(int y, int x, int[][] map) {
		int boomCount = map[y][x];
		map[y][x] = 0;
		for(int i=0; i<4; i++) {
			for(int bc=1; bc<=boomCount-1; bc++) {
				int nexty= y+ay[i]*bc;
				int nextx= x+ax[i]*bc;
				if(nextx<0 || nextx>=W || nexty<0 || nexty>=H) break;
				if(map[nexty][nextx]==0) 
					continue;
				boom(nexty, nextx, map);
			}
		}
		
	}

	static int[][] downSort(int[][] map) {
		int temp[][] = new int[H][W];

		q.clear();;

		for (int w = 0; w < W; w++) {
			for (int h = H - 1; h >= 0; h--) {
				if (map[h][w] != 0) {
					q.offer(map[h][w]);
				}
			}
			
			for(int h= H-1; h>=0; h--) {
				if(q.isEmpty()) break;
				temp[h][w] = q.poll();
			}
			
		}

		return temp;
	}

	static int[][] copyMap(int[][] map) {
		int temp[][] = new int[H][W];
		for (int h = H - 1; h >= 0; h--) {
			for (int w = 0; w < W; w++) {
				temp[h][w] = map[h][w];
			}
		}
		return temp;
	}
}
