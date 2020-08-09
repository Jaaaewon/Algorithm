package KOI96;

import java.util.Scanner;

public class test1 {

	public static void main(String[] args) {
		
	        
	}
	public int solution(int[] A) {
		 int B[] = new int[A.length];
		int C[] = new int[A.length];
		int D[] = new int[A.length];
		
		for(int i=0; i<B.length;i++) {
			B[i] = A[i];
		}
		int count1=0;
		int count2=0;
		int count3=0;
		int count4=0;
		
	    for(int i=0; i<A.length-1;i++) {
	    	if(A[i]==A[i+1]) {
	    		if(A[i]==0) {
	    			A[i+1]=1;
	    			count1++;
	    		}
	    		else {
	    			A[i+1]=0;
	    			count1++;
	    		}
	    	}
	    }
	    for(int i=0; i<C.length-1;i++) {
	    	if(C[i]==C[i+1]) {
	    		if(C[i]==0) {
	    			C[i]=1;
	    			count2++;
	    		}
	    		else {
	    			C[i]=0;
	    			count2++;
	    		}
	    	}
	    }
	    for(int i=B.length-1; i>0;i--) {
	    	if(B[i]==B[i-1]) {
	    		if(B[i]==0) {
	    			B[i]=1;
	    			count3++;
	    		}
	    		else {
	    			B[i]=0;
	    			count3++;
	    		}
	    	}
	    }
	    for(int i=D.length-1; i>0;i--) {
	    	if(D[i]==D[i-1]) {
	    		if(D[i]==0) {
	    			D[i-1]=1;
	    			count4++;
	    		}
	    		else {
	    			D[i-1]=0;
	    			count4++;
	    		}
	    	}
	    }
	    
	    int a = count1<count2?count1:count2;
	
	    int b = count3< a? count3 : a;
	
	    int c = count4< b? count4: b;
	    
	    return c;
    }
}
