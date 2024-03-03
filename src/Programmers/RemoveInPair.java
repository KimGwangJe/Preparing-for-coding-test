package Programmers;

import java.util.Stack;
class RIP{
    public int solution(String s){
        char[] carr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i=0;i<carr.length;i++) {
            char c = carr[i];
            if (stack.isEmpty()) stack.push(c);
            else {
                if (stack.peek() == c) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}

public class RemoveInPair {
    public static void main(String[] args){
        RIP rip = new RIP();
        rip.solution("baabaa");
    }
}
