package Practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class September9 {

	public static void main(String[] args) throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		//sc.nextLine().contain
        int T = Integer.parseInt(bufferReader.readLine());
        for(int i=0; i<T;i++) {
        	if(bufferReader.readLine().contains("9")) {
        		stringBuffer.append("#" + (i+1) + " Yes\n");
        	}
        	else {
        		stringBuffer.append("#" + (i+1) + " No\n");
        	}
        }
        System.out.println(stringBuffer.toString());
	}

}
