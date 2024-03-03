package Programmers;

import java.util.*;
class MML2 {
    public String solution(String s) {
        String answer = "";
        String[] list = s.split(" ");
        int[] num = new int[list.length];

        for(int i = 0; i < list.length; i++){
            num[i] = Integer.parseInt(list[i]);
        }
        Arrays.sort(num);

        answer += Integer.toString(num[0]) + " " + Integer.toString(num[num.length-1]);

        return answer;
    }
}

public class MaxMinLV2 {
    public static void main(String[] args){
        MML2 mml2 = new MML2();
        System.out.println(mml2.solution("-1 -2 -3 -4"));
    }
}
