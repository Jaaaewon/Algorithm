package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class AttachNum {

	static int[] xx = {0,0,1,-1};
	static int[] yy = {1,-1,0,0};
	static int map[][];
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder stb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T; test_case++) {
			map = new int[4][4];
			set.clear();
			
			for(int i=0; i<4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++)
					attach(i,j,map[i][j], 0);
			}
			stb.append("#"+test_case+" "+set.size()+"\n");	
		}
		System.out.println(stb.toString());
	}
	private static void attach(int x, int y, int num, int cnt) {
		if(cnt == 6) { 
			set.add(num);
			return;
		}
		for(int i=0; i<4; i++) {
			int ax = x + xx[i];
			int ay = y + yy[i];
			
			if( ax<0 || ax >=4 || ay<0 || ay>=4)
				continue;
			attach(ax, ay, num*10 + map[ax][ay], cnt+1);
		}
	}

}
