package level1;

public class 체육복 {
	// lost 배열을 전체 돌아. reserve배열 전체 돌아. 
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        int lostperson = lost.length;
        for(int i=0; i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                if(lost[i]==reserve[j]){
                    reserve[j] = -1;
                    lost[i] = -1;
                    lostperson--;
                    break;
                }
            }
        }
        for(int i=0; i<lost.length;i++){
            for(int j=0;j<reserve.length;j++){
                    if((lost[i]==reserve[j]+1) || (lost[i]==reserve[j]-1)){
                        reserve[j] = -1;
                        lostperson--;
                        break;
                    }
                }
        }
        return answer-lostperson;
    }
}