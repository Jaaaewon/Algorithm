package level1;

public class 문자열다루기기본 {
	public boolean solution(String s) {
        boolean answer = true;
        char[] chrs = s.toCharArray();
        if(chrs.length==4||chrs.length==6){
            for(char c:chrs){
                if(c<48||c>57)
                    return false;
            }
        }else return false;
        return true;
    }
}