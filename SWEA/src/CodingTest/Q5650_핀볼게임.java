package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5650_핀볼게임 {
	private static int map[][];
	private static int ax[] = { 0, 0, 1, -1 };
	private static int ay[] = { 1, -1, 0, 0 };
	private static int start[] = new int[2];
	private static int N, max = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int m = 0; m < N; m++) {
					map[n][m] = Integer.parseInt(st.nextToken());
				}
			}
			run();
			sb.append("#" + t + " " + max + "\n");
			max = 0;
		}
		System.out.println(sb);
	}

	private static void run() {
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < N; m++) {
				if (map[n][m] == 0) {
					for (int i = 0; i < 4; i++) {
						start[0] = n;
						start[1] = m;
						pinball(ax[i], ay[i], n, m, 0);
					}
				}
			}
		}
	}

	private static void pinball(int toX, int toY, int nowX, int nowY, int count) {
//		System.out.println();
		while (true) {
//			System.out.println("X: "+nowX +" Y: " + nowY+" toX: "+toX+" toY: "+ toY
//					+" count"+ count +"   "+ map[nowX][nowY]);
			nowX = nowX + toX;
			nowY = nowY + toY;
			if (nowX == start[0] && nowY == start[1]) {
				if (max < count)
					max = count;
				return;
			} else if ( (nowX>=N || nowX<0 || nowY>=N || nowY<0)|| map[nowX][nowY] == 5) {
				// 반대 & 벽 = toX toY -붙임
				toX = -toX;
				toY = -toY;
				count++;
			} else if (map[nowX][nowY] == -1) {
				if (max < count)
					max = count;
				return;
			} else if (map[nowX][nowY] == 1 || map[nowX][nowY] == 3) {
				// 상 (-1, 0) - 우 ( 0 , -1) // 하 (1, 0) - 좌 ( 0 , 1)
				if ((map[nowX][nowY] == 3 && (toX == 1 || toY == -1))
						|| (map[nowX][nowY] == 1 && (toX == -1 || toY == 1))) {
					toX = -toX;
					toY = -toY;
				} else {
					int temp = toX;
					toX = toY;
					toY = temp;
				}
				count++;
			} else if (map[nowX][nowY] == 2 || map[nowX][nowY] == 4) {
				// 하 (1, 0) - 우 ( 0 , -1) // 상 (-1, 0)- 좌(0, 1);
				if ((map[nowX][nowY] == 2 && (toX == 1 || toY == 1))
						|| (map[nowX][nowY] == 4 && (toX == -1 || toY == -1))) {
					toX = -toX;
					toY = -toY;
				} else {
					int temp = -toX;
					toX = -toY;
					toY = temp;
				}
				count++;
			} else if (map[nowX][nowY] >= 6 && map[nowX][nowY] <= 10) {
				int flag = 0;
				for (int n = 0; n < N; n++) {
					for (int m = 0; m < N; m++) {
						if (map[n][m] == map[nowX][nowY] && (n != nowX || m != nowY)) {
							nowX = n;
							nowY = m;
							flag = 1;
							break;
						}
					}
					if (flag == 1)
						break;
				}
			}
		}
	}
}