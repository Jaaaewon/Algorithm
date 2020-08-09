package KOI96;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class first_3 {

	static int result =0;
	static int map[][] = new int[101][101];
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int x,y,w,h;
		int total =0;
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			for(int j=y; j<h;j++) {
				for(int k=x;k<w;k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i=0; i<101; i++) {
			for(int j=0;j<101;j++) {
				if(map[i][j]==1) {
					total++;
				}
			}
		}
		System.out.println(total);
	}
}
