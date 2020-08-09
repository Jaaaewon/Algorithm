package level1;

public class E016³â {
	public String solution(int a, int b) {
        String answer = "";
        String [] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int dayNum[] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int total=0;
        for(int i=0; i<a-1; i++) {
        	total += dayNum[i];
        }
        
        total+=b;
        total = total%7-1;
        if(total==-1) total=6;
        answer = day[total];
        
        return answer;
    }
}