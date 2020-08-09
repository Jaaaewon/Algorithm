package Greedy2;

// A 와 B 의 길이를 비교. -> A의 앞에 추가시 차이 & A의 뒤에 추가시 차이 비교
// 비교 결과로 -> 추가. 다시 greedy
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1120 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String s1 = st.nextToken();
		String s2 = st.nextToken();
		int max = 0;
		for(int i=0; i<s2.length()-s1.length()+1;i++) {
			String temp = s2.substring(i, i+s1.length());
			System.out.println(temp);
			int count=0;
			for(int j=0;j<temp.length();j++) {
				if(temp.charAt(j)==s1.charAt(j))
					count++;
			}
			if(count>max)
				max = count;
		}
		System.out.println(s1.length()-max);
	}
}