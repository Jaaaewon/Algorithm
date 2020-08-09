package CodingTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Q5653_줄기재구성 {

	static private int ax[] = {0,0,-1,1};
	static private int ay[] = {-1,1,0,0};
	static private int K,N,M;
	static private int count=0;
	static private int map[][];
	static private LinkedList<Pair> q;
	static private int toN,toM;
	static class Pair{
		
		//life =0 되고 활성 -> 번식 = 얘는 life-1 뒤에 0 만들어줘야함
		int x,y,life,after=0,v;
		Pair(int y, int x, int life){
			this.x=x;
			this.y=y;
			this.life =life;
			this.v=life;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			q = new LinkedList<Pair>();
			toN = N%2==0?N/2:(N/2)+1;
			toM = M%2==0?M/2:(M/2)+1;
			map = new int[650][650];
			for(int n=325-N/2;n<325+toN; n++) {
				st = new StringTokenizer(br.readLine());
				for(int m=325-M/2; m<325+toM; m++) {
					map[n][m] =Integer.parseInt(st.nextToken());
				}
			}
			for(int n=325-N/2;n<325+toN; n++) {
				for(int m=325-M/2; m<325+toM; m++) {
					if(map[n][m]!=0) {
						q.offer(new Pair(n, m, map[n][m]));
						count++;
					}
				}
			}
			int k=0;
			

			while(!q.isEmpty()) {
				if(k==K) break;
				q.sort(new Comparator<Pair>() {
		            @Override
		            public int compare(Pair p1, Pair p2) {
		                return p2.v-p1.v;
		            }
		        });
				int size = q.size();
				for(int i=0; i<size; i++) {
					Pair p = q.poll();
					if(p.life==0&&p.after==0) {
						count--;
						continue;
					}
					bfs(p);
				}
				k++;
			}
			
			sb.append("#"+t+" "+count+"\n");
			
			count=0;
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs(Pair p) {
		if(p.life!=0) {
			p.life-=1;
			if(p.life==0)
				p.after = p.v;
			q.offer(p);
		}else {
			if(p.after!=0) {
				p.after-=1;
				if(p.after!=0)
					q.offer(p);
				else
					count--;
			}
			for(int i=0; i<4; i++) {
				int nextY = p.y + ay[i];
				int nextX = p.x + ax[i];
				
				if(nextX<0||nextX>=650||nextY<0||nextY>=650|| map[nextY][nextX]!=0) continue;
				count++;
				q.offer(new Pair(nextY, nextX, p.v));
				map[nextY][nextX] = p.v;
			}
		}
	}
}
