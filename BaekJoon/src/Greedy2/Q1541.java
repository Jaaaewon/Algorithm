package Greedy2;
// 3+4-2+4-3   3-4+2
// 55-50+40 ���ڰ� �ԷµǴµ�  +��ġ�� ã��. + �� ���� �� �Ǿ��� �ƴϸ�,
// +���� �յ� ���� ���� �ϰ� -> �� �ռ��ڿ��� �ڿ� ���ڵ� �� ���� �ǳ� ?
// �Էµ� string ������ -�� ã�� �迭�� ����־�. 
// if contains+ -> ��� ���� ����. �� ���ڶ� ��.
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1541 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strs[] = br.readLine().split("\\-");
		String plus[];
		int res=0;
		if(strs[0].contains("+")) {
			plus = strs[0].split("\\+");
			for(String s: plus) 
				res+=Integer.parseInt(s);
		}else res = Integer.parseInt(strs[0]);
		for(int i=1; i<strs.length; i++) {
			if(strs[i].contains("+")) {
				plus = strs[i].split("\\+");
				for(String s : plus)
					res -= Integer.parseInt(s);
			}else res-= Integer.parseInt(strs[i]);
		}
		System.out.println(res);
	}
}
