package Programmers;

import java.util.Arrays;
class CM
{
    public int solution(int[] A, int[] B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i = 0; i < A.length; i++){
            answer+= A[i] * B[B.length-1-i];
        }
        return answer;
    }
}

public class CreateMinLV2 {
    public void main(String[] args){
        CM cm = new CM();
        System.out.println(cm.solution(new int[]{1,4,2}, new int[]{5,4,4}));
    }
}
