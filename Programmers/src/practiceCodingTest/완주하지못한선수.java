package practiceCodingTest;

import java.util.Arrays;

public class �����������Ѽ��� {
	public String solution(String[] participant, String[] completion) {
        String answer="0";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                answer=participant[i];
                break;
            }
        }
        if(answer.equals("0")) answer = participant[participant.length-1];
        return answer;
    }
}