package CodingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q5656_벽돌깨기 {

	static int[] xx = { 0, 0, 1, -1 };
	static int[] yy = { 1, -1, 0, 0 };
	private static int maxNum = 0;
	private static int W, H,N, block,answer=0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= T; TC++) {
			sb.append("#"+TC + " ");
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			int map[][] = new int[H][W];
			int visited[][] = new int[H][W];
			block=0;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j]!=0) {
						visited[i][j]= 1;
						block++;
					}
				}
			}
			solve(1,0,map,visited);
			sb.append(block-answer);
			sb.append("\n");
			answer=0;
		}
		System.out.println(sb.toString());
	}
	static void solve(int n, int broken, int map[][], int visited[][]) {
		if(n==N+1) {
			answer = Math.max(broken, answer);
			return;
		}
		int brokenArr[] = new int[W];
		for(int w=0; w<W; w++) {
			int copiedMap[][] = new int[H][W];
			int copiedVisited[][] = new int [H][W];
			for(int a=0;a<W;a++) {
				for(int b=0; b<H; b++) {
					copiedMap[b][a] = map[b][a];
					copiedVisited[b][a] = visited[b][a];
				}
			}
			for(int h=0; h<H; h++) {
				if(map[h][w]!=0) {
					dfs(h, w, 1, 0, map[h][w]-1, copiedMap, copiedVisited);
					brokenArr[w] = maxNum;
					maxNum=0;
					break;
				}
			}
			for(int a=0;a<W;a++) {
				for(int b=0; b<H; b++) {
					if(copiedVisited[b][a]==0)
						copiedMap[b][a]=0;
				}
			}
			compact(copiedMap);
			compact(copiedVisited);
			solve(n+1, brokenArr[w]+broken, copiedMap, copiedVisited);
		}
	}
	// 벽돌이 부셔진 이후에 벽돌을 바닥으로 몰아넣는 함수
	private static void compact(int[][] copy) {
		Queue<Integer> temp;
		
		for(int w = 0 ; w < W ; ++w) {
			temp = new LinkedList<>();
			
			for(int h = H - 1 ; h >= 0 ; --h) {
				if(copy[h][w] > 0) temp.offer(copy[h][w]);
			}
			
			for(int h = H - 1 ; h >= 0 ; --h) {
				if(!temp.isEmpty()) {
					copy[h][w] = temp.poll();
				} else {
					copy[h][w] = 0;
				}
			}
		}
	}
	static void dfs(int nowX, int nowY, int goX, int goY, int life, int[][] map, int[][] visited) {
		if(life<0 || nowX>=H || nowX<0 || nowY>=W || nowY<0) {
			return;
		}
		
		if(map[nowX][nowY]>1) {
			if(visited[nowX][nowY]==1) {
				maxNum++;
				visited[nowX][nowY]=0;
				for(int i=0; i<4;i++) {
					int nextX = nowX + xx[i];
					int nextY = nowY + yy[i];
					if(goX==xx[i]&&goY==yy[i]) {
						if(map[nowX][nowY]-1>life) {
							dfs(nextX,nextY,xx[i],yy[i],map[nowX][nowY]-2,map,visited);
						}
						else {
							dfs(nextX,nextY,xx[i],yy[i],life-1,map,visited);
						}
					}
					else {
						dfs(nextX,nextY,xx[i],yy[i],map[nowX][nowY]-2,map,visited);
					}
				}
			}else {
				if(life>=0) {
					dfs(nowX+goX, nowY+goY, goX, goY, life-1, map, visited);
				}
			}
		}else {
			if(map[nowX][nowY]==1) {
				if(visited[nowX][nowY]==1&&life>=0) {
					maxNum++;
					visited[nowX][nowY]=0;
				}
				// 0 따로 빼면 dfs 한번 덜 불림.
				if(life>=0) {
					dfs(nowX+goX, nowY+goY, goX, goY, life-1, map, visited);
				}else{ return; }
			}else {
				if(goX!=0)
					return;
				dfs(nowX+goX, nowY+goY, goX, goY, life-1, map, visited);
			}
		}
	}
}
