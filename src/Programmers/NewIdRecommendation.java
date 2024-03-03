package Programmers;

import java.util.ArrayList;

class NIR {
    public String solution(String new_id) {
        StringBuilder answer = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        // 1단계: 대문자를 소문자로 변환
        new_id = new_id.toLowerCase();

        // 2단계: 특수문자 제거
        for (int i = 0; i < new_id.length(); i++) {
            char ch = new_id.charAt(i);
            if (Character.isLowerCase(ch) || Character.isDigit(ch) || ch == '-' || ch == '_' || ch == '.') {
                list.add(Character.toString(ch));
            }
        }

        // 3단계: 연속된 마침표 제거
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).equals(".") && list.get(i + 1).equals(".")) {
                list.remove(i);
                i--;
            }
        }

        // 4단계: 처음과 끝에 위치한 마침표 제거
        if (!list.isEmpty() && list.get(0).equals(".")) {
            list.remove(0);
        }
        if (!list.isEmpty() && list.get(list.size() - 1).equals(".")) {
            list.remove(list.size() - 1);
        }

        // 5단계: 빈 문자열인 경우 "a" 대입
        if (list.isEmpty()) {
            list.add("a");
        }

        // 6단계: 16자 이상이면 15자까지만 남기기
        if (list.size() >= 16) {
            list.subList(15, list.size()).clear();
        }
        // 마지막 마침표 제거
        while (!list.isEmpty() && list.get(list.size() - 1).equals(".")) {
            list.remove(list.size() - 1);
        }

        // 7단계: 길이가 2자 이하면 마지막 문자 반복
        while (list.size() <= 2) {
            list.add(list.get(list.size() - 1));
        }

        // 리스트를 문자열로 변환
        for (String str : list) {
            answer.append(str);
        }

        return answer.toString();
    }
}


public class NewIdRecommendation {
    public static void main(String[] args){
        NIR nir = new NIR();
        System.out.println(nir.solution("...!@BaT#*..y.abcdefghijklm"));
    }
}
