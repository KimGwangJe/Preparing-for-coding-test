package Algorithm;

class Murge{
    static int[] buffer;
    Murge(int n){
        buffer = new int[n];
    }
    public int[] murge(int[] a, int left, int right){
        if(left < right){
            int i;
            int center = (left+right)/2;
            int p = 0;
            int j = 0;
            int k = left;

            murge(a,left,center);
            murge(a,center+1,right);

            for(i = left; i <= center; i++){
                buffer[p++] = a[i];
            }
            while(i <= right && j < p){
                a[k++] = (buffer[j] <= a[i]) ? buffer[j++]: a[i++];
            }
            while(j<p){
                a[k++] = buffer[j++];
            }

        }

        return a;
    }
}

public class MurgeSorting {
    public static void main(String[] args){
        int[] a = {2,4,6,8,10,11,13,1,3,5,7,9,12};
        Murge m = new Murge(a.length);
        a = m.murge(a,0,a.length-1);
        for(int q:a) System.out.println(q);
    }
}
