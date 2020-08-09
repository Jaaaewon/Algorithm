package KOI96;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Solution {
	    public int solution(int[] A) {
	        // write your code in Java SE 8
	    	int result=0;
	    	List<Integer> intList = new ArrayList<Integer>(A.length);
	    	for (int i : A)
	    	{
	    	    intList.add(i);
	    	}
	    	int max = intList.stream().max(Integer::compare).orElse(-1);
	    	
	        for(int i=1; i<=max;i++) {
	        	if(!contains(A, i)) {
		           return i;
	        	}
	        }
	        if(max>0)
	        	return max+1;
	        else
	        	return 1;
	    }
	    public boolean contains(final int[] arr, final int key) {
	        return Arrays.stream(arr).anyMatch(i -> i == key);
	    }
	}
	
}
