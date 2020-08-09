package level1;

public class 가운데글자가져오기 {
	public String solution(String s) {
        char [] chrs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        int num = chrs.length;
        if(num%2==0){
            sb.append(chrs[(num/2)-1]);
            sb.append(chrs[num/2]);
        }else{
            sb.append(chrs[num/2]);
        }
            
        return sb.toString();
    }
}
