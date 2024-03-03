package Programmers;

/*
두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다).
X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다.
다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.

제한사항
3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
X, Y는 0으로 시작하지 않습니다.
X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.
입출력 예
X	Y	result
"100"	"2345"	"-1"
"100"	"203045"	"0"
"100"	"123450"	"10"
"12321"	"42531"	"321"
"5525"	"1255"	"552"
*/

// 이거 시간 초과 나옴
// import java.util.*;

// class Solution {
//     public String solution(String X, String Y) {
//         String answer = "";
//         String[] x = X.split("");
//         String[] y = Y.split("");

//         ArrayList<Integer> list = new ArrayList<>();

//         for (int i = 0; i < x.length; i++) {
//             if (x[i].equals("-1")) continue;

//             for (int j = 0; j < y.length; j++) {
//                 if (x[i].equals(y[j])) {
//                     list.add(Integer.parseInt(x[i]));
//                     x[i] = "-1";
//                     y[j] = "-1";
//                     break;
//                 }
//             }
//         }

//         Collections.sort(list, Collections.reverseOrder());

//         for (int num : list) {
//             answer += num;
//         }

//         if (answer.equals("")) return "-1";

//         // "00"일 경우 "0"으로 처리
//         if (answer.startsWith("0")) return "0";

//         return answer;
//     }
// }

import java.util.HashMap;

class NumMat {
    public String solution(String X, String Y) {
        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();

        for(String data : X.split("")){
            int cur = Integer.parseInt(data);
            xmap.put(cur, xmap.getOrDefault(cur, 0) + 1);
        }

        for(String data : Y.split("")){
            int cur = Integer.parseInt(data);
            ymap.put(cur, ymap.getOrDefault(cur, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 9; i >= 0 ; i --){
            if(xmap.containsKey(i) && ymap.containsKey(i)){
                int cnt = Math.min(xmap.get(i), ymap.get(i));
                for (int j = 0; j < cnt; j++) {
                    sb.append(i);
                }
            }
        }

        if(sb.toString().startsWith("0")){
            return "0";
        }
        else if(sb.toString().equals("")){
            return "-1";
        }

        return sb.toString();
    }
}

public class NumberMatching {
    public static void main(String[] args){
        NumMat nm = new NumMat();
        System.out.println(nm.solution("100","2345"));
    }
}
