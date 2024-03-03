package Programmers;

import java.util.*;
class LB {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int i = 0;
        int j = people.length - 1;

        while(true){
            if(people[i] + people[j] <= limit){
                answer++;
                i++;
                j--;
            } else {
                answer++;
                j--;
            }
            if(i == j){
                answer++;
                break;
            } else if(i > j) break;
        }

        return answer;
    }
}

public class LifeBoat {
    public static void main(String[] args){
        LB lb = new LB();
        System.out.println(lb.solution(new int[]{70, 50, 80, 50},100));
    }
}
