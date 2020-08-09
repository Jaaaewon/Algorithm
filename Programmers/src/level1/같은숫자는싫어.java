package level1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
	public int[] solution(int []arr) {
        List<Integer> listArr = new ArrayList<Integer>();
        int temp=-1;
        int i=0;
        for(int n : arr){
            if(temp!=n){
                listArr.add(n);
                temp = n;
                i++;
                continue;
            }
        }
        
        int [] answer = new int[i];
        for(int n=0; n<listArr.size(); n++)
            answer[n] = listArr.get(n);
        return answer;
    }
}
