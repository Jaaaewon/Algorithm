package KOI96;

public class test3 {
	public static void main(String[] args) throws Exception{
		solution("?a?");
		solution("?ab??a");
		
	}
	static public String solution(String S) {
		// write your code in Java SE 8
		StringBuffer stringBuffer = new StringBuffer();
		
		char [] chs = S.toCharArray();
		for(int i=0; i<chs.length;i++) {
			if(chs.length%2!=0) {
				if(i==chs.length) {
					if(chs[i]=='?') {
						chs[i] = 'z';
					}
					else continue;
				}	
			}
			if(chs[i]=='?') {
				chs[i] = chs[chs.length-(i+1)];
			}
			else{
				chs[chs.length-(i+1)] = chs[i];
			}
		}
		for(int i=0;i<chs.length;i++) {
			stringBuffer.append(chs[i]);
		}
		String S1 = stringBuffer.toString();
		int p = 0;
		int q = S1.length() - 1;
		while (p < q) {
			if (S1.charAt(p) != S.charAt(q)) {
				return "No";
			}
			p += 1;
			q -= 1;
		}
		return S1;

	}
}
