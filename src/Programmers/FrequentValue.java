package Programmers;

/*최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.*/

class Frequent {
    public int solution(int[] array) {
        int answer = 0;
        int sum = 0; //몇개?
        int temp = 0;
        for(int i = 0; i < array.length; i++){
            int a = 1;
            if(answer == array[i]){
                continue;
            }
            for(int j = 0; j < array.length; j++){
                if(i == j){
                    continue;
                }
                if(array[i] == array[j]){
                    a++;
                }
            }
            if(sum < a){
                sum = a;
                answer = array[i];
                temp = 0;
            } else if(sum == a){
                temp = -1;
            }
        }
        return temp == -1 ? -1 : answer;
    }
}
public class FrequentValue {
    public static void main(String[] args){
        Frequent f = new Frequent();
        System.out.println(f.solution(new int[]{1, 2, 3, 3, 3, 4}));
    }
}
