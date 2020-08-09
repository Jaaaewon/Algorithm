package CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Q2383_점심식사 {

	private static int N,total=Integer.MAX_VALUE;
	private static int pNum = 0;
	private static int stairidx[][];
	private static int map[][];
	private static int person[][];
	private static int where[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {

			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			int sc=0;
			stairidx = new int[2][2];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						pNum++;
					else if (map[i][j] != 0) {
						stairidx[sc][0] = i;
						stairidx[sc++][1] = j;
					}
				}
			}
			person = new int[pNum][2];
			int pc = 0;
			
			//person에는 계단0번까지 거리 & 1번까지거리 들어있음.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]==1) {
						person[pc][0] = Math.abs(i-stairidx[0][0]) + Math.abs(j-stairidx[0][1]);
						person[pc++][1] = Math.abs(i-stairidx[1][0]) + Math.abs(j-stairidx[1][1]);
					}
					if(pc==pNum) break;
				}
				if(pc==pNum) break;
			}
			where = new int[pNum];
			lunch(0);
//			System.out.println("#"+t+" "+total);
			sb.append("#"+t+" "+total+"\n");
			total=Integer.MAX_VALUE;
			pNum = 0;
//			System.out.println("완료: "+ total);
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	// 0 = 이동시간. 1 = 계단의 이동시간
	static void lunch(int count) {
		if (count==pNum) {
			go();
			return;
		}
		for(int k=0; k<2; k++) {
			where[count] = k;
			lunch(count+1);
		}
		
	}

	static void go() {
		int count = 0;
		int time[]= new int[pNum];
		int stair[][] = new int[2][3];
		for(int i=0; i<pNum;i++) {
			time[i] = person[i][where[i]];
		}
		int downperson = pNum;
		boolean visited[] = new boolean[pNum];
		while(true) {
			if(count>total) return;
			if(downperson==0) {
				int sum=0;
				sum= max(stair[0]);
				sum= sum>= max(stair[1]) ?sum:max(stair[1]);
//				System.out.print(count+ "   ");
				count+=sum;
//				System.out.println(count);
				if(total>count) {
					total = count+1;
				}
				
				return;
				
			}

			count++;
			// 사람 이동
 			minus(time);
 			// 계단에 머무르는사람도 시간 줄여
			minus(stair[0]);
			minus(stair[1]);
			for(int i=0; i<pNum; i++) {
				// 도착 안했어 i 사람
				if(time[i]!=0)
					continue;
				if(visited[i]) continue;
				// i번째 사람이 n번 계단으로 내려가려는데 거기가 비었니 ?
				int emptyidx = empty(stair[where[i]]);
				//비었으면, 사람수 줄이고, 고
				if(emptyidx!=-1) {
					stair[where[i]][emptyidx] = map[stairidx[where[i]][0]][stairidx[where[i]][1]];
					visited[i] = true;
					downperson--;
					continue;
				}else {
					// 도착 했는데 맨위에서 minus 일괄처리하기때문에 +1 해줌.
					time[i] +=1;
				}
			}
		}
	}
	static int max(int arr[]) {
		int max=0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max)
				max = arr[i];
		}
		return max;
	}
	static void minus(int arr[]) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i]!=0)
				arr[i] -=1;
		}
	}
	static int empty(int[] stair) {
		int count=0;
		int idx = -1;
		// 0 이 빈거 -> count++
		for(int i=0; i<stair.length; i++) {
			if(stair[i]==0) {
				count++;
				idx = i;
			}
		}
		// count ==0 안비어있다.
		if(count==0) return -1;
		return idx;
	}
}
