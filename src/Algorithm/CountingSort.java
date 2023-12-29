package Algorithm;

class Count{
    public int[] count(int[] a){
        int[] b = new int[a.length];
        int len = a.length;
        int max = 0;
        //
        for(int i = 0; i < a.length; i++){
            if(max < a[i]) max = a[i];
        }
        int[] f = new int[max+1];
        // 1단계 도수분포표
        for(int j = 0; j < len; j++) f[a[j]]++;
        // 2단계 누적합
        for(int k = 1; k <= max; k++) f[k] = f[k -1] + f[k];
        // 3단계 목표 배열 만들기
        for(int q = len - 1; q >= 0; q--){
            b[--f[a[q]]] = a[q];
        }
        // 4단계 배열 복사
        for(int w = 0; w < len; w++) a[w] = b[w];
        return a;
    }
}
public class CountingSort {
    public static void main(String[] args){
        Count c = new Count();
        int[] a = c.count(new int[]{0,1,4,6,3,10,9});
        for(int b: a) System.out.println(b);
    }
}
