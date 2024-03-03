package Programmers;

import java.util.*;

class TYPT {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> temp = new HashMap<String, Integer>() {{
            put("R", 0);
            put("T", 0);
            put("C", 0);
            put("F", 0);
            put("J", 0);
            put("M", 0);
            put("A", 0);
            put("N", 0);
        }};
        int[] score = {3, 2, 1, 0, 1, 2, 3}; // 점수 표

        for (int i = 0; i < choices.length; i++) {
            if (choices[i] > 4) {
                String a = Character.toString(survey[i].charAt(1));
                int num = temp.get(a);
                temp.put(a, num + score[choices[i] - 1]);
            } else {
                String a = Character.toString(survey[i].charAt(0));
                int num = temp.get(a);
                temp.put(a, num + score[choices[i] - 1]);
            }
        }
        if (temp.get("R") > temp.get("T")) answer += "R";
        else if (temp.get("R") < temp.get("T")) answer += "T";
        else answer += "R";

        if (temp.get("C") > temp.get("F")) answer += "C";
        else if (temp.get("C") < temp.get("F")) answer += "F";
        else answer += "C";

        if (temp.get("J") > temp.get("M")) answer += "J";
        else if (temp.get("J") < temp.get("M")) answer += "M";
        else answer += "J";

        if (temp.get("A") > temp.get("N")) answer += "A";
        else if (temp.get("A") < temp.get("N")) answer += "N";
        else answer += "A";
        return answer;
    }
}


public class TestingYourPersonalityType {
    public static void main(String[] args){
        TYPT typt = new TYPT();
        System.out.println(typt.solution(new String[]{"AN", "CF", "MJ", "RT", "NA"},new int[]{5, 3, 2, 7, 5}));
    }
}
