package Programmers;

class EP {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while(a != b) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            answer++;
        }

        return answer;
    }
}

public class ExpectedBraketLV2 {
    public static void main(String[] args){
        EP ep = new EP();
        System.out.println(ep.solution(8,4,7));
    }
}
