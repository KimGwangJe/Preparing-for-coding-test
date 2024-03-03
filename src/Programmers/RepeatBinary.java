package Programmers;

class RB {
    public int[] solution(String s) {
        int[] answer = new int[2];
        int delete = 0;
        while(true){
            if(s.equals("1")) break;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0') delete ++;
            }
            answer[0]++;
            answer[1] += delete;
            s = Integer.toBinaryString(s.length() - delete);
            delete = 0;
        }
        return answer;
    }
}

public class RepeatBinary {
    public static void main(String[] args){
        RB rb = new RB();
        System.out.println(rb.solution("110010101001"));
    }
}
