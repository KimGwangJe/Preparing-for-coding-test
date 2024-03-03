package Programmers;

import java.util.*;

/*
실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때,
실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

입출력 예 #1
1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 따라서 1번 스테이지의 실패율은 다음과 같다.

1 번 스테이지 실패율 : 1/8
2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 따라서 2번 스테이지의 실패율은 다음과 같다.

2 번 스테이지 실패율 : 3/7
마찬가지로 나머지 스테이지의 실패율은 다음과 같다.

3 번 스테이지 실패율 : 2/4
4번 스테이지 실패율 : 1/2
5번 스테이지 실패율 : 0/1
각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.

[3,4,2,1,5]
*/

class FR {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N]; // 실패 확률이 높은 스테이지부터 내림차순으로
        Double[] ratio = new Double[N]; // 실패율

        for (int i = 1; i <= N; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) {
                    left++;
                    right++;
                }
                if (i < stages[j]) right++;
            }
            ratio[i - 1] = (right == 0) ? 0 : (double) left / right;
        }

        Integer[] indexArray = new Integer[N];
        for (int i = 0; i < N; i++) {
            indexArray[i] = i;
        }

        Arrays.sort(indexArray, (a, b) -> Double.compare(ratio[b], ratio[a]));

        // 정렬된 인덱스로 answer 배열 채우기
        for (int i = 0; i < N; i++) {
            answer[i] = indexArray[i] + 1;
        }

        return answer;
    }
}

public class FailRate {
    public static void main(String[] args){
        FR fr = new FR();
        System.out.println(fr.solution(5,new int[]{2, 1, 2, 6, 2, 4, 3, 3}));
    }
}
