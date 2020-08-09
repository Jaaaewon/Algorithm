package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q5644_무선충전 {
	static private final int temp[][] = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static private int total = 0;
	static private int move, apNum,bCharger,aCharger;
	
	static public void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			move = Integer.parseInt(st.nextToken());
			apNum = Integer.parseInt(st.nextToken());
			int rootArr[][][] = new int[2][move + 1][2];
			rootArr[0][0][0] = 1;
			rootArr[0][0][1] = 1;
			rootArr[1][0][0] = 10;
			rootArr[1][0][1] = 10;
			for (int person = 0; person < 2; person++) {
				st = new StringTokenizer(br.readLine());
				for (int i = 1; i <= move; i++) {
					int m = Integer.parseInt(st.nextToken());
					rootArr[person][i][0] = rootArr[person][i - 1][0] + temp[m][0];
					rootArr[person][i][1] = rootArr[person][i - 1][1] + temp[m][1];
				}
			}
			int apArr[][] = new int[apNum][4];
			for (int i = 0; i < apNum; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					apArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			gogo(rootArr, apArr);
			sb.append("#"+(t+1)+" "+total+"\n");
			total=0;
		}
		System.out.println(sb);
	}

	static private void gogo(int rootArr[][][], int apArr[][]) {

		for (int i = 0; i <= move; i++) {
			boolean[] a = new boolean[apNum];
			boolean[] b = new boolean[apNum];
			for (int apN = 0; apN < apNum; apN++) {
				a[apN] = inCharger(rootArr[0][i][0], rootArr[0][i][1], apArr[apN]);
				b[apN] = inCharger(rootArr[1][i][0], rootArr[1][i][1], apArr[apN]);
			}
			int temp1 = 0, temp2=0;
			temp1 += first(b, apArr, 1);
			temp1 += second(a, apArr, bCharger);
			temp2 += first(a, apArr, 0);
			temp2 += second(b, apArr, aCharger);
			total += temp1>=temp2?temp1:temp2;
		}
	}
	static private int first(boolean[] ab, int apArr[][],int charger) {
		int temp=0;
		for (int j = 0; j < apNum; j++)
			if (ab[j] && apArr[j][3] >= temp) {
				temp = apArr[j][3];
				if(charger==1)
					bCharger = j;
				else aCharger = j;
			}
		return temp;
	}
	static private int second(boolean[] ab, int apArr[][], int ex) {
		int temp=0;
		for (int j = 0; j < apNum; j++)
			if (ab[j] && apArr[j][3] >= temp && j!=ex) {
				temp = apArr[j][3];
			}
		return temp;
	}
	
	static private boolean inCharger(int y, int x, int apArr[]) {
		if (x >= apArr[0] - apArr[2] && x <= apArr[0] + apArr[2])
			if (y >= apArr[1] - apArr[2] && y <= apArr[1] + apArr[2])
				if(Math.abs(apArr[1]-y)+Math.abs(apArr[0]-x)>=-apArr[2] 
						&& Math.abs(apArr[1]-y)+Math.abs(apArr[0]-x)<=apArr[2])
				return true;
		return false;
	}
}
