package practiceCodingTest;

public class 두정수사이의합 {
	public long solution(int a, int b) {
        long answer = 0;
        int big = a>=b?a:b;
        int small = a<b?a:b;
        for(int i=small;i<=big;i++)
            answer+=i;
        return answer;
    }
}

