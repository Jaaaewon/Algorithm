package practiceCodingTest;

public class ���ڿ���p��y�ǰ��� {
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