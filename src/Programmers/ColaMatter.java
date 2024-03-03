package Programmers;

/*문제를 풀던 상빈이는 콜라 문제의 완벽한 해답을 찾았습니다.
상빈이가 푼 방법은 아래 그림과 같습니다.
우선 콜라 빈 병 20병을 가져가서 10병을 받습니다.
받은 10병을 모두 마신 뒤, 가져가서 5병을 받습니다.
5병 중 4병을 모두 마신 뒤 가져가서 2병을 받고, 또 2병을 모두 마신 뒤 가져가서 1병을 받습니다.
받은 1병과 5병을 받았을 때 남은 1병을 모두 마신 뒤 가져가면 1병을 또 받을 수 있습니다.
이 경우 상빈이는 총 10 + 5 + 2 + 1 + 1 = 19병의 콜라를 받을 수 있습니다.
문제를 열심히 풀던 상빈이는 일반화된 콜라 문제를 생각했습니다.
이 문제는 빈 병 a개를 가져다주면 콜라 b병을 주는 마트가 있을 때, 빈 병 n개를 가져다주면 몇 병을 받을 수 있는지 계산하는 문제입니다.
기존 콜라 문제와 마찬가지로, 보유 중인 빈 병이 a개 미만이면, 추가적으로 빈 병을 받을 순 없습니다.
*/

class Cola {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true) {
            answer += (n/a)*b;
            int remain = n % a;
            n = (n/a) * b + remain;
            if(n < a) break;
        }
        return answer;
    }
}

public class ColaMatter {
    public static void main(String[] args){
        Cola c = new Cola();
        System.out.println(c.solution(2,1,20));
    }
}
