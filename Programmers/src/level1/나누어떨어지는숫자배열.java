package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열 {
	public int[] solution(int[] arr, int divisor) {
		List<Integer> arrL = new ArrayList<Integer>();
        for(int i=0; i<arr.length; i++){
            if(arr[i]%divisor==0){
                System.out.println(arr[i]);
                arrL.add(arr[i]);
            }
        }
        if(arrL.size()==0) arrL.add(-1);
        Collections.sort(arrL);
        int[] answer = new int[arrL.size()];
        for(int n=0; n<arrL.size(); n++)
            answer[n] = arrL.get(n);
        
        return answer;
    }
}