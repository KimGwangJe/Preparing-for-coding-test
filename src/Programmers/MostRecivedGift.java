package Programmers;

import java.util.*;

class MRG {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;

        // 지수를 알기 위한 hashmap
        Map hash = new HashMap<String, Integer>();
        Map<String,Integer> present = new HashMap<>();

        // map에 기본값 입력
        for(int i = 0; i < friends.length; i++){
            hash.put(friends[i],0);
            present.put(friends[i],0);
        }

        // 지수 변경
        // 준놈은 높아지고 받은놈은 작아짐
        for(int i = 0; i < gifts.length; i++){
            String[] temp = gifts[i].split(" ");
            String receive = temp[0];
            int receiveNum = hash.get(temp[0]);
            String gift = temp[1];
            int giftNum = hash.get(temp[1]);
            hash.put(receive, receiveNum + 1);
            hash.put(gift, giftNum - 1);
        }

        //받을 선물 계산
        for(int i = 0; i < friends.length-1; i++){
            for(int j = i+1; j < friends.length; j++){
                String a = friends[i];
                String b = friends[j];
                // 아래 두개 비교해서 한명한테 선물 한개만
                int left = 0; //a가 준 횟수
                int right = 0; //b가 준 횟수
                // 둘중 더 큰놈이 받을거임
                // 같으면 지수로 비교해서 지수가 더 큰놈이 받을거임
                for(int k = 0; k < gifts.length; k++){
                    String[] temp = gifts[k].split(" ");
                    if(temp[0].equals(a) && temp[1].equals(b)){
                        left++;
                    } else if(temp[0].equals(b) && temp[1].equals(a)){
                        right++;
                    }
                }
                if(left > right){
                    present.put(a,present.get(a)+1);
                } else if(right > left){
                    present.put(b,present.get(b)+1);
                } else if(left == right){
                    int aJisoo = hash.get(a);
                    int bJisoo = hash.get(b);
                    if(aJisoo > bJisoo){
                        present.put(a,present.get(a)+1);
                    } else if(bJisoo > aJisoo){
                        present.put(b,present.get(b)+1);
                    }
                }
            }
        }

        for(int i = 0; i < friends.length; i++){
            if(present.get(friends[i]) > answer) answer = present.get(friends[i]);
        }


        return answer;
    }
}


public class MostRecivedGift {
    public static void main(String[] args){
        MRG mrg = new MRG();
        mrg.solution(new String[]{"muzi", "ryan", "frodo", "neo"}, new String[]{"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"});
    }
}
