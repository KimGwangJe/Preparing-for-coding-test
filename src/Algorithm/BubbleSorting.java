package Algorithm;

class Bubble{
    public int[] bubble(int[] arr1){
        int temp = 0;
        int count = 0;
        for(int i = 0; i < arr1.length - 1; i++){
            for(int j = 0; j < arr1.length - i - 1; j++){
                if(arr1[j] > arr1[j+1]){
                    count++;
                    temp = arr1[j];
                    arr1[j] = arr1[j+1];
                    arr1[j+1] = temp;
                }
            }
            //더이상 교환이 없을시 종료
            if(count == 0){
                break;
            }
        }
        System.out.println("count 횟수는 : " +count);
        return arr1;
    }
}
public class BubbleSorting {
    public static void main(String[] args){
        Bubble b = new Bubble();
        int[] a = b.bubble(new int[]{2,4,5,1,3});
        for(int q : a) System.out.println(q);
    }
}
