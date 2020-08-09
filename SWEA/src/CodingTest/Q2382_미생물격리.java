package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2382_�̻����ݸ� {

	private static int N,M,K,count;
	private static int move[][] = {{-1, 0} , {1,0}, {0,-1}, {0,1} };
	
	static public void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			int karr[][] = new int[K][4];
			for(int k=0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				for(int l=0; l<4; l++) {
					karr[k][l] = Integer.parseInt(st.nextToken());
				}
			}
			
			isolation(karr,0);
			sb.append("#" + t+ " "+ count+"\n");
			count=0;
		}
		System.out.println(sb);
	}
	private static void isolation(int karr[][], int m) {
		if(m==M) {
			for(int k=0; k<K; k++)
				if(karr[k][2]!=-1)
					count+=karr[k][2];
			return;
		}
		
		for(int k=0;k<K; k++) {
			// -1 �� �̻����� �̹� ����� ������.
			if(karr[k][2]==-1) continue;
			// <=0 && N-1<=   -> �׵θ� ���� �� /=2 & ���� �ݴ�
			int v = move[karr[k][3]-1][0];
			int h = move[karr[k][3]-1][1];
			karr[k][0] +=v;
			karr[k][1] +=h;
			// �׵θ��� ������ /=2 && ���� �ݴ�.
			if(karr[k][0]<=0 || karr[k][0]>=N-1 || karr[k][1]<=0 || karr[k][1]>=N-1) {
				karr[k][2]/=2;
				if(v!=0) karr[k][3] = v==1? 1: 2;
				else karr[k][3] = h==1?3:4;
			}
		}

		
		int maxindex=0;
		int maxcount=0;
		for(int k=0; k<K; k++) {
			if(karr[k][2]==-1) continue;
			maxindex = k;
			maxcount=karr[k][2];
			for(int j=0;j<K;j++) {
				if(j==k || karr[j][2]==-1) continue;
				// ���� ���� �����ְ� ������?
				if(karr[k][0]==karr[j][0] && karr[k][1]==karr[j][1]) {
					// ����ģ ������ ���� ū �༮�� index�� value�� ������.
					// ���� ����ģ���� ���� ����ũ�� ������ ������ ���ϴ°�.
					// ����ģ ���� �ٸ��ְ� ���� ũ�� �ٸ������� �������� ������
					if(karr[maxindex][2]<karr[j][2]) {
						karr[maxindex][2] = -1;
						maxindex = j;
						maxcount += karr[j][2];
					}else {
						maxcount+= karr[j][2];
						karr[j][2] = -1;
					}
				}
			}
			// ����ū index�� ������ value���� ��� || ������ �����ֵ��� -1�� value����.
			karr[maxindex][2] = maxcount;
		}
		isolation(karr,m+1);
	}
}
