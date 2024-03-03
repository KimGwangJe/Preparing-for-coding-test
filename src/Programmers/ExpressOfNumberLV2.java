package Programmers;

class EON {
    public int solution(int n) {
        int answer = 0; //총 갯수
        int temp = 0; //더해진 값

        for(int i = 1; i < n+1; i++){
            int a = 1; //i에서 a만큼 더해서 다음 숫자를 더함
            temp=i;
            while(true){
                if(temp == n){
                    answer++;
                    a = 1;
                    break;
                } else if(temp > n){
                    a = 1;
                    break;
                } else{
                    temp+=i+a;
                    a++;
                }
            }
        }

        return answer;
    }
}


public class ExpressOfNumberLV2 {
    public static void main(String[] args){
        EON eon = new EON();
        System.out.println(eon.solution(15));
    }
}
