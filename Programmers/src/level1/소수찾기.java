package level1;

import java.util.HashSet;

public class 소수찾기 {
    private static String[] arrs;
    HashSet<Integer> hs = new HashSet<Integer>();
    
    public int solution(String numbers) {
        
        arrs = numbers.split("");
        
        boolean visited[] = new boolean[arrs.length];
        
        for(int i=0; i<arrs.length; i++){
            visited[i] = true;
            comb(arrs[i], visited, 0, arrs.length);
            visited[i]= false;
        }
        
        return hs.size();
    }
    public void comb(String s, boolean[] visited, int idx, int len){
        if(idx==len-1){
            if(find(Integer.parseInt(s))&&!s.startsWith("0"))
                hs.add(Integer.parseInt(s));
            return;
        }
        for(int i=0; i<arrs.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            comb(s+arrs[i], visited, idx+1, len);
            visited[i] = false;
        }
        
        if(find(Integer.parseInt(s))&&!s.startsWith("0"))
            hs.add(Integer.parseInt(s));
    }
    public boolean find(int a){
        if(a<=1) return false;
        for(int i=2; i<=Math.sqrt(a); i++){
            if(a%i==0) return false;
        }
        return true;
    }
}