package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 문자열내마음대로정렬하기 {
	public String[] solution(String[] strings, int n) {
        List<String> arr = new ArrayList<String>();
        for(String s : strings)
        	arr.add(s);
        
        Collections.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.charAt(n)==s2.charAt(n))
                    return s1.compareTo(s2);
                return s1.charAt(n)>s2.charAt(n)?1:-1;
            }
        });
        String answer[] = arr.toArray(new String[arr.size()]);
        return answer;
    }
}
