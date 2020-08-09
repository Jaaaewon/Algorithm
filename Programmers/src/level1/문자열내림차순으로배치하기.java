package level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 문자열내림차순으로배치하기 {
	public String solution(String s) {
        List<String> arr = new ArrayList<String>();
        for(char c: s.toCharArray()){
            arr.add(String.valueOf(c));
        }
        Collections.sort(arr, new Comparator<String>(){
            @Override
            public int compare(String c1, String c2){
                return c2.compareTo(c1);
            }
        });
        //answer = arr.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
        StringBuilder sb = new StringBuilder();
        for(String ss: arr)
            sb.append(ss);
        return sb.toString();
    }
}