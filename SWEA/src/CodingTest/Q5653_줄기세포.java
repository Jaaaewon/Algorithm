package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
// 리스트 사용해서 타임아웃뜸.
s
public class Q5653_줄기세포 {
	static private int ax[] = {0,0,1,-1};
	static private int ay[] = {1,-1,0,0};
	static private int K;
	static private List<MyCell> map = new ArrayList<MyCell>();
	static private List<MyCell> next = new ArrayList<MyCell>();
	public static void main(String[] args) throws Exception{
		int a;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			for(int h=0;h<H; h++) {
				st = new StringTokenizer(br.readLine());
				MyCell m1;
				for(int w=0; w<W; w++) {
					int n =Integer.parseInt(st.nextToken());
					if(n!=0) {
						 m1 = new MyCell(h,w,n);
						map.add(m1);
						next.add(m1);
					}
				}
			}
//			long start = System.currentTimeMillis();
			gogo(0);
			int count=0;
			for(MyCell mc : map) {
				if((mc.life>=0 && mc.isUsed)||mc.num>0)
					count++;
			}
			map.clear();
			next.clear();
//			long end = System.currentTimeMillis();
//			sb.append("#"+t+" "+count+" 시간: "+ (( end - start )/1000.0) + "\n");
			sb.append("#"+t+" "+count+"\n");
		}
	}
	public static void gogo(int k) {
		if(k==K) return;
//		System.out.println(map);
		for(int i=0; i<map.size(); i++) {
			if(map.get(i).isUsed && map.get(i).life==0) {
				int nextLife = map.get(i).num;
				map.get(i).life -=1;
				map.get(i).isUsed = false;
				map.get(i).num -=1;
				for(int j=0; j<4; j++) {
					int nextX = map.get(i).x + ax[j];
					int nextY = map.get(i).y + ay[j];
					MyCell nextCell = new MyCell(nextX, nextY,nextLife);
					
					// 이미 맵에 등록된 셀이면? -> 새로 생성 불가능. 그럼 ? continue;
					if(map.contains(nextCell)) {
						continue;
					}else { // 맵에 등록되지 않은 셀이면 ? 셀을 추가해 그냥 바로 & next 셀로 줘
						next.add(nextCell);
					}
				}
			}else {
				if(map.get(i).isUsed && map.get(i).life>0)
					map.get(i).life -=1;
				if(!map.get(i).isUsed && map.get(i).num>0)
					map.get(i).num-=1;
			}
			if(i==map.size()-1) {
//				Collections.sort(next, new Comparator<MyCell>() {
//					@Override
//					public int compare(MyCell c1, MyCell c2) {
//						if(c1.life==c2.life)
//							return 0;
//						return c1.life>c2.life?-1:1;
//					}
//				});
				for(MyCell cell : next) {
					if(!map.contains(cell)|| cell.num>map.get(map.indexOf(cell)).num)
						map.add(cell);
				}
				next.clear();
				break;
			}
		}
//		System.out.println(map);
		gogo(k+1);
	}
	public static class MyCell{
		int x,y,life,num;
		boolean isUsed=true;
		public MyCell(int x, int y, int life) {
			this.x = x; this.y = y; this.life = life; this.num = life;
		}
		@Override
		public int hashCode() {
			int prime = 31;
			int result = prime*x;
			result = prime*y;
			result = prime*life;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if(obj instanceof MyCell) {
				return ((MyCell)obj).x==x&&((MyCell)obj).y==y;
//						&& ((MyCell)obj).life==life;
			}
			return false;
		}
		public String toString() {
			return Integer.toString(x)+Integer.toString(y)+Integer.toString(life)
			+Integer.toString(num);
		}
	}
}
