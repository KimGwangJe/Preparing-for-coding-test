package Algorithm;

class Select{
    public int[] select(int[] arr){
        int temp = 0;
        for(int i = 0; i < arr.length - 1; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}

public class SelectingSort {
    public static void main(String[] args){
        Select s = new Select();
        int[] a = s.select(new int[]{1,4,5,3,2,6,7,3});
        for(int q:a) System.out.println(q);
    }
}
