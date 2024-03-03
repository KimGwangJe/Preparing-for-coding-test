package Programmers;
import java.util.*;

/*정수 배열 numbers가 주어집니다.
numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는
모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.*/

class Add {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(numbers[0] + numbers[1]);
        int a = 1;
        for(int i = 0; i < numbers.length - 1; i++){
            for(int j = i+1; j < numbers.length; j++){
                boolean t = false;
                for(int k = 0; k < answer.size(); k++){
                    if(numbers[i] + numbers[j] == answer.get(k)){
                        t = true;
                        break;
                    }
                }
                if(!t){
                    answer.add(numbers[i] + numbers[j]);
                    a++;
                }
            }
        }

        int[] temp = answer.stream().mapToInt(x->x).toArray();
        Arrays.sort(temp);
        return temp;
    }
}

public class PullOutAndAdd {
    public static void main(String[] args){
        Add a = new Add();
        System.out.println(a.solution(new int[]{2,1,3,4,1}));
    }
}
