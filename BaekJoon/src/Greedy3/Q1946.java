package Greedy3;

// ¼ºÀû Á¤·Ä. ³·Àº³ğ + ³ôÀº³ğ < °í¸£¸é µÊ.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q1946 {
	private static int testcase;
	private static int num;
	private static int count,maxcount;
	private static int arr[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		testcase = Integer.parseInt(br.readLine());
		for(int i=0; i<testcase; i++) {
			count=0;
			maxcount=0;
			num = Integer.parseInt(br.readLine());
			arr = new int[num][2];
			for(int j=0; j<num; j++) {
				st = new StringTokenizer(br.readLine()); 
				arr[j][0] = Integer.parseInt(st.nextToken());
				arr[j][1] = Integer.parseInt(st.nextToken());
			}
			for(int j=1;j<num;j++) {
				for(int k=0; k<j; k++) {
					if(arr[j][0] < arr[k][0] && arr[j][1] < arr[k][1]) {
						count++;
						break;
					}
				}
			}
			for(int j=1;j<num;j++) {
				for(int k=0; k<j; k++) {
					if(arr[j][0] > arr[k][0] && arr[j][1] > arr[k][1]) {
						maxcount++;
						break;
					}
				}
			}
			System.out.println(num-(count>=maxcount?count:maxcount));
		}
	}
}
