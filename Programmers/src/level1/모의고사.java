package level1;

public class 모의고사 {
	public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int []arr = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i] == first[i%first.length]) arr[0]++;
            if(answers[i] == second[i%second.length]) arr[1]++;
            if(answers[i] == third[i%third.length]) arr[2]++;
        }
        int max=arr[0]>=arr[1]?(arr[0]>=arr[2]?arr[0]:arr[2])
            :(arr[1]>=arr[2]?arr[1]:arr[2]);
        int same=0;
        for(int i=0; i<arr.length;i++){
            if(max==arr[i])
                same++;
        }
        int[] answer = new int[same];
        int k=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == max){
                answer[k++] = i+1;
            }
        }
        return answer;
    }
}