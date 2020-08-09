package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4013_특이한자석 {
	/*
	 * K번 회전 시킴 1번째 톱니를.
	 * 1번째 톱니의 index(2) 와 각 톱니의 index==2 0?1 을 비교함
	 * 2번째 톱니의 index(2) 와 3번째 톱니의 index 2 를 비교함.
	 * 여기서 index는 우로 회전시 -1 좌로 회전시 +1 그대로 = 0 만큼 증가해야함.
	 * 그와 동시에 다음 톱니와 물리는점 attach 부분도 
	 * 우로 회전시 -1 좌로회전시 +1 그대로 = 0
	 * 
	 * 그럼 여기서 bfs는 언제쓸까.
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
				// true = 다른경우
				if(checkLeft(index, i)) {
					rotate[i] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = 같은경우
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
				// true = 다른경우
				if(checkLeft(index, i)) {
					rotate[i-1] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = 같은경우
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
			// 톱니 중간꺼 돌린경우인데
			// 톱니 중간돌림 -> 오른쪽 톱니 체크
			int temp=arrRotate[start][1];
			rotate[arrRotate[start][0]-1] = arrRotate[start][1];
			for(int i=arrRotate[start][0]; i<4; i++) {
				// true = 다른경우
				if(checkLeft(index, i)) {
					rotate[i] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = 같은경우
				}else {
					break;
				}
			}
			arrRotate[start][1] = temp;
			for(int i=arrRotate[start][0]-1; i>0; i--) {
				// true = 다른경우
				if(checkLeft(index, i)) {
					rotate[i-1] = -arrRotate[start][1];
					arrRotate[start][1] = -arrRotate[start][1];
					// false = 같은경우
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
