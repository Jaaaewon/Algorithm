package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
s
// �̰� Ÿ�Ӿƿ��ߴµ�?
public class Q5648_���ڼҸ�ù� {
	private static int T, N;
	private static int atom[][];
	private static int energy = 0;
	private static boolean visited[];
	public static void main(String[] args) throws Exception {
		long start = System.currentTimeMillis();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			atom = new int[N][4];
			for (int n = 0; n < N; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int m=0;m<4;m++) {
					atom[n][m] = Integer.parseInt(st.nextToken());
				}
			}

			check2();
			sb.append("#" + t + " " + energy + "\n");
			energy = 0;
		}
		System.out.println(sb);
		long end = System.currentTimeMillis();

		System.out.println( "���� �ð� : " + ( end - start )/1000.0 );


	}

	private static void check2() {
		visited = new boolean[N];
		int distance = 4002;
		for (int i = 0; i < N; i++) {
			if (atom[i][3] == 0)
				continue;

			for (int j = 0; j < N; j++) {
				if (i != j) {
					if (atom[j][3] == 0)
						continue;
					// �� �� �� �� 0 1 2 3
					// �� �� ����
					if (atom[i][1] == atom[j][1]) {
						int dis = Math.abs(atom[i][0] - atom[j][0]);
						if (dis <= distance) {
							if (atom[i][2] == 3 && atom[j][2] == 2 && atom[i][0] <= atom[j][0]) {
								// �� �� ����
							} else if (atom[i][2] == 2 && atom[j][2] == 3 && atom[i][0] >= atom[j][0]) {
								// �� �� ����
							} else
								continue;
							if (dis == distance) {
								visited[j] = true;
								visited[i] = true;
							} else {
								visited = new boolean[N];
								visited[j] = true;
								visited[i] = true;
								distance = dis;
							}

						}
					} else if (atom[i][0] == atom[j][0]) {
						int dis = Math.abs(atom[i][1] - atom[j][1]);
						if (dis <= distance) {
							if (atom[i][2] == 0 && atom[j][2] == 1 && atom[i][1] <= atom[j][1]) {
								// �� �� ����
							} else if (atom[i][2] == 1 && atom[j][2] == 0 && atom[i][1] >= atom[j][1]) {
							} else
								continue;

							if (dis == distance) {
								visited[j] = true;
								visited[i] = true;
							} else {
								visited = new boolean[N];
								visited[j] = true;
								visited[i] = true;
								distance = dis;
							}
						}
					} else {
						if (Math.abs(atom[i][0] - atom[j][0]) == Math.abs(atom[i][1] - atom[j][1])) {
							// �� �� or �� �츸��
							int dis = Math.abs(atom[i][1] - atom[j][1])*2;
							if (dis <= distance) {
								if (atom[i][2] == 0 && atom[i][1] <= atom[j][1]) {
									if ((atom[j][2] == 3 && atom[i][0] < atom[j][0])
											|| (atom[j][2] == 2 && atom[i][0] >= atom[j][0])) {
										if (dis == distance) {
											visited[j] = true;
											visited[i] = true;
										} else {
											visited = new boolean[N];
											visited[j] = true;
											visited[i] = true;
											distance = dis;
										}
									} // �� �� or �� �� 
								}else if (atom[i][2] == 1 && atom[i][1] >= atom[j][1]) {
									if ((atom[j][2] == 3 && atom[i][0] > atom[j][0])
											|| (atom[j][2] == 2 && atom[i][0] < atom[j][0]))// ��
									{
										if (dis == distance) {
											visited[j] = true;
											visited[i] = true;
										} else {
											visited = new boolean[N];
											visited[j] = true;
											visited[i] = true;
											distance = dis;
										}
									}// �� �� or �� ��
								}else if (atom[i][2] == 2 && atom[i][0] >= atom[j][0]) {
									if ((atom[j][2] == 0 && atom[i][1] > atom[j][1])
											|| (atom[j][2] == 1 && atom[i][1] < atom[j][1]))// �»� ���
									{
										if (dis == distance) {
											visited[j] = true;
											visited[i] = true;
										} else {
											visited = new boolean[N];
											visited[j] = true;
											visited[i] = true;
											distance = dis;
										}
									} // �� �� or �� ��
								}else if (atom[i][2] == 3 && atom[i][0] <= atom[j][0]) {
									if ((atom[j][2] == 0 && atom[i][1] > atom[j][1])
											|| (atom[j][2] == 1 && atom[i][1] < atom[j][1]))// �� �� ���
									{
										if (dis == distance) {
											visited[j] = true;
											visited[i] = true;
										} else {
											visited = new boolean[N];
											visited[j] = true;
											visited[i] = true;
											distance = dis;
										}
									}
								}
							}
						}
					}
				}
			}
		}
		if (distance == 4002)
			return;
//			System.out.println();
		for (int a = 0; a < N; a++) {
			if (visited[a]) {
//				System.out.print(atom[a][0] +" " + atom[a][1] + " "+atom[a][2]+"// ");
				energy += atom[a][3];
				atom[a][3] = 0;
			}
		}
		System.gc();
//		System.out.println();
		check2();
	}

}
