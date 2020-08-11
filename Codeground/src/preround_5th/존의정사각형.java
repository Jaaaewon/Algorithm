package preround_5th;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
   As the name of the class should be Solution , using Solution.java as the filename is recommended.
   In any case, you can execute your program by running 'java Solution' command.
 */
public class 존의정사각형 {
	static int Answer, pNum, M;
	static int points[][];
	public static void main(String args[]) throws Exception	{
//		long start = System.currentTimeMillis(); //시작하는 시점 계산

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		Scanner sc = new Scanner(System.in);
		for(int test_case = 0; test_case < T; test_case++) {
			M = Integer.parseInt(br.readLine());
			pNum = Integer.parseInt(br.readLine());
			points = new int[pNum][2];
			for(int i=0; i<pNum; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				points[i][0] = Integer.parseInt(st.nextToken());
				points[i][1] = Integer.parseInt(st.nextToken());
			}
			Answer = 0;
//			Arrays.sort(points, Comparator.comparingInt(o1 -> o1[0]));
			Arrays.sort(points, new Comparator<int[]>() {
	            // Override된 compare 함수를 어떻게 정의하냐에 따라서 다양한 정렬이 가능해집니다
	            @Override
	            public int compare(int[] o1, int[] o2) {
	                return o1[0] - o2[0];
	            }
	        });
	        
			for(int i=0; i<pNum; i++) {
				countMaxWidth(i);
//				sb.append("\n points : "+ points[i][0]+" "+points[i][1] +" -> " +Answer);
			}
			sb.append("Case #"+(test_case+1)+"\n"+Answer + "\n");
//			bw.write("Case #"+(test_case+1)+"\n"+Answer + "\n");
		}
		System.out.println(sb.toString());
//		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
//		bw.write( "\n실행 시간 : " + ( end - start )/1000.0 +"초\n");
//		bw.flush();
//		bw.close();
		br.close();
	}
	
	static void countMaxWidth(int n) {
		int maxtmp = (M-points[n][0])<=(M-points[n][1])?(M-points[n][0]):(M-points[n][1]);
		int width = Integer.MAX_VALUE;
		for(int i=n+1; i<pNum; i++) {
			if(points[i][1]<= points[n][1]||points[i][0] ==points[n][0]) continue;
			if(points[i][1] > points[n][1] ) {
				int tmp = Math.abs(points[i][1]-points[n][1])>=Math.abs(points[i][0]-points[n][0])?
						Math.abs(points[i][1]-points[n][1]):Math.abs(points[i][0]-points[n][0]);
				tmp = tmp<=maxtmp?tmp:maxtmp;
				if(tmp<width) {
					width = tmp;
				}
//				System.out.println(width);
			}
		}
		if(width==Integer.MAX_VALUE) {
			Answer+=maxtmp;
		}else {
			Answer+=width;
		}
	}
}