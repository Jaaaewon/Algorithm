package KOI96;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


public class first_1 {
	
	static int map[][];
	static int townCnt=0;
	private static int[] addRow = { -1, 0, 1, 0 };
	private static int[] addCol = { 0, 1, 0, -1 };
	static int N=0;
	static int arrSize[] = new int[323];
	static int result[];
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		String input;
		for(int i=0;i<N;i++) {
			input = br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j] = input.charAt(j)-'0';
			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]==1) {
					townCnt++;
					dfs(i, j, townCnt+1);
				}
			}
		}

		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]>1) {
					arrSize[map[i][j]-2]++;
				}
			}
		}
		result = new int[townCnt];
		for(int i=0; i<townCnt;i++) {
			result[i] = arrSize[i];
		}
		Arrays.sort(result);
		System.out.println(townCnt);
		for(int i=0; i<result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	private static void dfs(int x, int y, int val) {
		map[x][y] = val;
		for(int i=0; i<4; i++) {
			int ddx = x + addRow[i];
			int ddy = y + addCol[i];
			
			if((ddx>=0 && ddx<N) && (ddy>=0 && ddy<N) && (map[ddx][ddy]==1))
				dfs(ddx, ddy, val);
		}
	}
}
