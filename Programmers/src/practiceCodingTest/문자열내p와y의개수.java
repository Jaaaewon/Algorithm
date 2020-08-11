package practiceCodingTest;

public class 문자열내p와y의개수 {
	boolean solution(String s) {
        int p=0,y=0;
        
        char[] chrs=s.toCharArray();
        for(char c: chrs){
            if(c=='p'||c=='P')
                p++;
            if(c=='y'||c=='Y')
                y++;
        }
        
        return p==y?true:false;
    }
}