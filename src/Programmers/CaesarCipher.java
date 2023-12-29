package Programmers;

/*
* 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
* 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
* "z"는 1만큼 밀면 "a"가 됩니다. 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.*/

class CC {
    public String solution(String s, int n) {
        String answer = "";
        String[] al = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch != ' ') {
                int idx = -1;
                for(int j = 0; j < al.length; j++) {
                    if(Character.isUpperCase(ch)) {
                        if(Character.toLowerCase(ch) == al[j].charAt(0)) {
                            idx = j;
                            break;
                        }
                    } else {
                        if(ch == al[j].charAt(0)) {
                            idx = j;
                            break;
                        }
                    }
                }

                if(idx != -1) {
                    if(Character.isUpperCase(ch)) {
                        int newIndex = (idx + n) % al.length;
                        answer += al[newIndex].toUpperCase();
                    } else {
                        int newIndex = (idx + n) % al.length;
                        answer += al[newIndex];
                    }
                }
            } else {
                answer += " ";
            }
        }
        return answer;
    }
}


public class CaesarCipher {
    public static void main(String[] args){
        CC c = new CC();
        System.out.println(c.solution("AB",1));
        System.out.println(c.solution("a B z",4));
    }
}
