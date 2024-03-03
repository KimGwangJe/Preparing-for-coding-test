package Programmers;

/*정수 n을 기준으로 n과 가까운 수부터 정렬하려고 합니다.
이때 n으로부터의 거리가 같다면 더 큰 수를 앞에 오도록 배치합니다.
정수가 담긴 배열 numlist와 정수 n이 주어질 때 numlist의 원소를 n으로부터 가까운 순서대로 정렬한 배열을 return하도록
solution 함수를 완성해주세요.*/

class UA {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        for(int i = 0; i < numlist.length; i++){
            int temp = 0;
            for(int j = 0; j < numlist.length; j++){
                if(i == j){
                    continue;
                }
                if(Math.abs(numlist[i] - n) > Math.abs(numlist[j] - n)){
                    temp++;
                }
            }
            if(answer[temp] != 0){
                int tmp = 0;
                if(answer[temp] > numlist[i]){
                    answer[temp+1] = numlist[i];
                } else{
                    tmp = answer[temp];
                    answer[temp] = numlist[i];
                    answer[temp+1] = tmp;
                }
            } else{
                answer[temp] = numlist[i];
            }
        }
        return answer;
    }
}
public class UnusualArrangement {
    public static void main(String[] args){
        UA ua = new UA();
        System.out.println(ua.solution(new int[]{10000,20,36,47,40,6,10,7000},30));
    }
}
