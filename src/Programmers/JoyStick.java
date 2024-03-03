package Programmers;

// class Solution {
//     public int solution(String name) {
//         int answer = 0;
//         char[] li = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//         int lastidx = 0;

//         for(int i = 0; i < name.length(); i++){
//             if(name.charAt(i) == 'A'){
//                 continue;
//             } else{
//                 if(Math.abs(name.length() - i) < lastidx + i){
//                     answer+=Math.abs(name.length() - i);
//                 } else {
//                     answer = lastidx + i;
//                 }
//             }

//             int idx = 0; // 원하는 문자의 인덱스 들어감
//             for(int j = 0; j < li.length; j++) {
//                 if(name.charAt(i) == li[j]){
//                     idx = j;
//                 }
//             }

//             if(Math.abs(li.length - idx) < 0 + idx){
//                 answer += Math.abs(li.length - idx);
//             } else {
//                 answer += idx;
//             }
//             lastidx = i;
//             answer++;
//         }
//         return answer - 1;
//     }
// }

// class Solution {
//     public int solution(String name) {
//         int answer = 0;

//         for(int i = 0; i < name.length(); i++){
//             int minMoves = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
//             answer += minMoves;
//         }

//         int minMovesToChange = name.length() - 1;
//         for(int i = 0; i < name.length(); i++){
//             if(name.charAt(i) != 'A'){
//                 int nextIdx = i + 1;
//                 while(nextIdx < name.length() && name.charAt(nextIdx) == 'A'){
//                     nextIdx++;
//                 }
//                 int moves = i + name.length() - nextIdx + Math.min(i, name.length() - nextIdx);
//                 minMovesToChange = Math.min(minMovesToChange, moves);
//             }
//         }

//         answer += minMovesToChange;

//         return answer;
//     }
// }

class JS {
    public int solution(String name) {
        int answer = 0;
        int index;
        int move = name.length()-1;

        for(int i=0;i<name.length();i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            index = i+1;
            while(index<name.length() && name.charAt(index) == 'A') {
                index++;
            }
            move = Math.min(move, i*2+name.length()-index);
            move = Math.min(move, (name.length()-index)*2 + i);
        }
        return answer + move;
    }
}


public class JoyStick {
    public static void main(String[] args){
        JS js = new JS();
        System.out.println(js.solution("JAS"));
    }
}
