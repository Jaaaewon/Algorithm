package Greedy2;
// 3+4-2+4-3   3-4+2
// 55-50+40 숫자가 입력되는데  +위치를 찾고. + 가 수식 중 맨앞이 아니면,
// +수식 앞뒤 숫자 덧셈 하고 -> 맨 앞숫자에서 뒤에 숫자들 다 빼면 되네 ?
// 입력된 string 값에서 -를 찾고 배열에 집어넣어. 
// if contains+ -> 얘는 덧셈 숫자. 앞 숫자랑 비교.
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
