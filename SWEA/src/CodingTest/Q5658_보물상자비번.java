package CodingTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Q5658_보물상자비번 {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int step = N/4;
            int K = Integer.parseInt(st.nextToken());
            sb.append("#"); sb.append(test_case);
            String s = br.readLine();
            String[] strs = s.split("");
        	List<Integer> arr = new ArrayList<Integer>();
            //List<String> arr = new ArrayList<String>();
        	
            for(int start=0; start<step; start++) {
	            int i=0;
	            int convertIndex = step-start;
	            StringBuilder temp = new StringBuilder();
	            while(true) {
	            	if(convertIndex==N)
	            		convertIndex = 0;
	            	if(i%step==0&&i!=0) {
	            		if(!arr.contains(Integer.parseInt(temp.toString(),16)))
	            		//if(!arr.contains(temp.toString()))
	            			//arr.add(temp.toString());
	            			arr.add(Integer.parseInt(temp.toString(), 16));
	            		temp = new StringBuilder();
		            	if(i==N)
		            		break;
	            	}
	            	temp.append(strs[convertIndex]);
	            	convertIndex++;
	            	i++;
	            }
            }
            Collections.sort(arr,new Comparator<Integer>() {
            	@Override
            	public int compare(Integer a1, Integer a2) {
            		return a1>=a2? -1: 1;
            	}
            });
            sb.append(" "+arr.get(K-1));
            sb.append("\n");
        }
		System.out.println(sb.toString());
	}
}