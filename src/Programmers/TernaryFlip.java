package Programmers;

/*
* 자연수 n이 매개변수로 주어집니다. n을 3진법 상에서 앞뒤로 뒤집은 후,
* 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
*/

class TF {
    public int solution(int n) {
        String answer = "";

        while(n != 0){ // 뒤집어서 들어감
            answer += n % 3;
            n /= 3;
        }
        return Integer.parseInt(answer,3); // 3진수를 10진수로 변경하는 방법
    }
}

public class TernaryFlip {
    public static void main(String[] args){
        TF tf = new TF();
        System.out.println(tf.solution(45));
    }
}
