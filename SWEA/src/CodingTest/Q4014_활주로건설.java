package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4014_Ȱ�ַΰǼ� {

	private static int N, X;
	private static int map[][];
	private static boolean possible[];
	private static int count=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int n = Integer.parseInt(st.nextToken());
					map[i][j] = n;
				}
			}
			gogo();
			sb.append("#"+t+" "+count+"\n");
			count=0;
		}
		System.out.println(sb);
	}
	private static void gogo() {
		int allT;
		// ���ο� ���Ѱ�.
		for(int i=0; i<N; i++) {
			allT=0;
			possible = new boolean[N-1];
			boolean isUsed[] = new boolean[N];
			for(int j=0;j<N-1; j++) {
				if(map[i][j]==map[i][j+1])
					possible[j] = true;
			}
			// ���� �� �� ���� Ȱ�ַ� �ϼ����� Ȯ��.
			for(int j=0; j<N-1; j++) {
				if(!possible[j]) {
					allT = countClimb(i,j,0,isUsed);
					if(allT==1) break;
				}
			}
			if(allT==0) count++;
//			System.out.println((i+1)+"��° ���� == " + allT);
		}
		// ���ο� ���� ��.
		for(int i=0; i<N; i++) {
			allT = 0;
			possible = new boolean[N-1];
			boolean isUsed[] = new boolean[N];
			for(int j=0;j<N-1; j++) {
				if(map[j][i]==map[j+1][i])
					possible[j] = true;
			}
			// ���� �� �� ���� Ȱ�ַ� �ϼ����� Ȯ��.
			for(int j=0; j<N-1; j++) {
				if(!possible[j]) {
					allT = countClimb(j, i,1,isUsed);
					if(allT==1) break;
				}
			}
			if(allT==0) count++;
//			System.out.println((i+1)+"��° ���� == " + allT);
		}
	}
	//�ϴ� ���ο� �����ΰ� �����.
	private static int countClimb(int xIndex,int yIndex, int direction, boolean[] isUsed) {
		// direction == 0  => ���� , ==1 => ����
		// if index > index+1 (�� ������ X��ŭ ������?)&&(index+1 �̶� index�� 1����?)
		// 0 ����.
		int temp=0, count=0;
		int col, row;
		int nextCol, nextRow;
		if(direction==0) {
			col = xIndex;
			row = yIndex;
			nextCol = col;
			nextRow = row+1;
		}else {
			col = xIndex;
			row = yIndex;
			nextCol = col+1;
			nextRow = row;
		}
		if(map[col][row]>map[nextCol][nextRow]) {
			if(map[col][row]==map[nextCol][nextRow]+1) {
				temp = map[nextCol][nextRow];
				for(int i=nextRow, j=nextCol;i<N&&j<N;) {
					int flag = direction==0?i:j;
					if(temp == map[j][i]&&!isUsed[flag]) {
						count++;
						isUsed[flag] = true;
					}
					else break;
					if(count==X)
						return 0;

					i += direction==0?1:0;
					j += direction==0?0:1;
				}
			}
		// else index<index+1 (�������� X��ŭ ������?)&&(index�̶� index+1�̶� 1����?)
		// 0����
		} else if(map[col][row]<map[nextCol][nextRow]) {
			if(map[col][row]+1==map[nextCol][nextRow]) {
				temp = map[col][row];
				for(int i=row, j=col;i>=0&&j>=0;) {
					int flag = direction==0?i:j;
					if(temp == map[j][i]&&!isUsed[flag]) {
						count++;
						isUsed[flag] = true;
					}
					else break;
					if(count==X) 
						return 0;

					i -= direction==0?1:0;
					j -= direction==0?0:1;
				}
			}
		}
		return 1;
	}
}
