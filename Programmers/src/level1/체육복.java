package level1;

public class ü���� {
	// lost �迭�� ��ü ����. reserve�迭 ��ü ����. 
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