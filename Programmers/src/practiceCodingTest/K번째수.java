package practiceCodingTest;

import java.util.Arrays;

public class K¹øÂ°¼ö {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int i=0; i<commands.length; i++){
            int cutted[] = new int[ (commands[i][1]-commands[i][0]+1) ];
            for(int j=commands[i][0]-1; j<commands[i][1]; j++){
                cutted[j-commands[i][0]+1] = array[j];
            }
            Arrays.sort(cutted);
            answer[i] = cutted[commands[i][2]-1];
        }
        return answer;
    }
}