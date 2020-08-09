package Practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MM {
	private static int TC;
    private static StringBuilder sb = new StringBuilder();
    private static StringBuilder NUM;
    private static int CNT, MAX;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        TC = Integer.parseInt(br.readLine());
        for (int t = 1; t <= TC; t++) {
            sb.append("#").append(t).append(" ");
            MAX = Integer.MIN_VALUE;
            // type solution for tc here
            StringTokenizer info = new StringTokenizer(br.readLine());
            NUM = new StringBuilder(info.nextToken());
            CNT = Integer.parseInt(info.nextToken());
            dfs(0, 0);
            sb.append(MAX);
            ////////////////////////////
            sb.append("\n");
        }
        System.out.println(sb);
    }
 
    private static void dfs(int changed, int cur) {
        if (changed == CNT) {
            MAX = Math.max(MAX, Integer.parseInt(NUM.toString()));
            return;
        }
 
        for (int i = cur; i < NUM.length(); i++) {
            for (int j = i + 1; j < NUM.length(); j++) {
                if (NUM.charAt(i) <= NUM.charAt(j)) {// 뒤에 나오는 녀석이 더 크다면 바꿔주자.
                    swap(i, j);
                    dfs(changed + 1, i);
                    swap(i, j);
                }
            }
        }
    }
 
    private static void swap(int a, int b) {
        char temp = NUM.charAt(a);
        NUM.setCharAt(a, NUM.charAt(b));
        NUM.setCharAt(b, temp);
    }
}
