package Practice;

import java.util.Scanner;

public class SpotMart {

	public void spot() {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int num,max,temp1=0,temp2=0, tempSum1=0,tempSum2=0, result;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			num = sc.nextInt();
			max = sc.nextInt();
			
			for(int i=0;i<num-1;i++) {
				temp1 = sc.nextInt();
				temp2 = sc.nextInt();
				if(tempSum1>tempSum2) {
					tempSum1 += temp1;
				}else {
					
				}
				
			}
			
			

		}
	}
}
