package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4013_Ư�����ڼ� {
	/*
	 * K�� ȸ�� ��Ŵ 1��° ��ϸ�.
	 * 1��° ����� index(2) �� �� ����� index==2 0?1 �� ����
	 * 2��° ����� index(2) �� 3��° ����� index 2 �� ����.
	 * ���⼭ index�� ��� ȸ���� -1 �·� ȸ���� +1 �״�� = 0 ��ŭ �����ؾ���.
	 * �׿� ���ÿ� ���� ��Ͽ� �������� attach �κе� 
	 * ��� ȸ���� -1 �·�ȸ���� +1 �״�� = 0
	 * 
	 * �׷� ���⼭ bfs�� ��������.
	 */
	static private int arr[][];
	static private int arrRotate[][];
	static private int K=0;
	static private int answer=0;
	static public void main(String []args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t<=T; t++) {
			arr = new int[4][8];
			K = Integer.parseInt(br.readLine());
			for(int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			arrRotate = new int[K][2];
			int start =0;
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<2; j++) {
					arrRotate[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int index[] = new int[4];
			for(int i=0; i<4; i++)
				index[i] = 0;
			gogo(index,start);
			sb.append("#").append(t).append(" ").append(answer).append("\n");
			answer=0;
		}
		System.out.println(sb);
		
	}
	static private void gogo(int[] index,int start) {
		if(start==K) {
			for(int i=0; i<4; i++) {
				answer+=score(i, index[i]);
			}
			return;
		}
		int rotate[] = new int[4];
		if(arrRotate[start][0]==1) {
			rotate[0] = arrRotate[start][1];
			for(int i=1; i<4; i++) {
				// true = �ٸ����
				if(checkLeft(index, i)) {
					rotate[i] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = �������
				}else {
					break;
				}
			}
			for(int i=0; i<4; i++) {
				index[i]-=rotate[i];
				if(index[i]<0) index[i]+=8;
				if(index[i]>7) index[i]-=8;
			}
			gogo(index, start+1);
		}else if(arrRotate[start][0]==4) {
			rotate[3] = arrRotate[start][1];
			for(int i=3; i>0; i--) {
				// true = �ٸ����
				if(checkLeft(index, i)) {
					rotate[i-1] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = �������
				}else {
					break;
				}
			}
			
			for(int i=0; i<4; i++) {
				index[i]-=rotate[i];
				if(index[i]<0) index[i]+=8;
				if(index[i]>7) index[i]-=8;
			}
			gogo(index, start+1);
		}else {
			// ��� �߰��� ��������ε�
			// ��� �߰����� -> ������ ��� üũ
			int temp=arrRotate[start][1];
			rotate[arrRotate[start][0]-1] = arrRotate[start][1];
			for(int i=arrRotate[start][0]; i<4; i++) {
				// true = �ٸ����
				if(checkLeft(index, i)) {
					rotate[i] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = �������
				}else {
					break;
				}
			}
			arrRotate[start][1] = temp;
			for(int i=arrRotate[start][0]-1; i>0; i--) {
				// true = �ٸ����
				if(checkLeft(index, i)) {
					rotate[i-1] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = �������
				}else {
					break;
				}
			}
			for(int i=0; i<4; i++) {
				index[i]-=rotate[i];
				if(index[i]<0) index[i]+=8;
				if(index[i]>7) index[i]-=8;
			}
			gogo(index, start+1);
		}
	}
	static private boolean checkLeft(int index[],int circle) {
		int leftValueIndex, rightValueIndex;
		if(index[circle]-2<0)
			leftValueIndex = index[circle]+6;
		else
			leftValueIndex = index[circle]-2;
		if(index[circle-1]+2>7)
			rightValueIndex = index[circle-1]-6;
		else
			rightValueIndex = index[circle-1]+2;
		if(arr[circle-1][rightValueIndex]==arr[circle][leftValueIndex]) {
			return false;
		}else return true;
	}
	static private int score(int circle,int index) {
		if(arr[circle][index]==1)
			return (int) Math.pow(2,circle);
		return 0;
	}
}
