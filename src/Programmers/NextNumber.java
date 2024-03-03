package Programmers;

/*등차수열 혹은 등비수열 common이 매개변수로 주어질 때, 마지막 원소 다음으로 올 숫자를 return 하도록 solution 함수를 완성해보세요.*/

class Next {
    public int solution(int[] common) {
        int temp = 0;
        boolean sum = true;
        for(int i = 0; i < common.length-1; i++){
            if(i == 0){
                temp = common[i+1] - common[i];
            }
            if(temp != common[i+1] - common[i]){
                temp = common[i+1]/common[i];
                sum = false;
            }
        }
        return sum ? common[common.length-1] + temp : common[common.length-1] * temp;
    }
}

public class NextNumber {
    public static void main(String[] args){
        Next n = new Next();
        System.out.println(n.solution(new int[]{2,4,8}));
    }
}
