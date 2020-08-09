package Greedy1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q10610 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(input);
		if(!input.contains("0"))
			System.out.println("-1");
		else {
			isCorrect(input);
		}
	}
	public static void isCorrect(String s) {
		int num=0;
		char chrs[] = s.toCharArray();
		StringBuilder stb = new StringBuilder();
		Arrays.sort(chrs);
		for(int i=chrs.length-1; i>=0; i--) {
			System.out.println(chrs[i]-'0');
			num += chrs[i]-'0';
			stb.append(chrs[i]);
		}
		if(num%3==0) System.out.println(stb.toString());
		else System.out.println("-1");
	}
}