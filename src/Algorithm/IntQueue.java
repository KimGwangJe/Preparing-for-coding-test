package Algorithm;

public class IntQueue {
    private int[] que;
    private int capacity;
    private int front; // 맨 앞 요소
    private int rear; // 맨 뒤 요소
    private int num; // 현재 데이터 개수

    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException(){ }
    }

    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException() { }
    }

    //생성자
    public IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;
        try {
            que = new int[capacity];
        } catch (OutOfMemoryError e){
            capacity = 0;
        }
    }

    // 큐에 데이터 넣음
    public int enque(int x) throws OverflowIntQueueException {
        if( num >= capacity) {
            throw new OverflowIntQueueException();
        }
        que[rear++] = x;
        num++;
        if(rear == capacity){
            rear = 0; // rear가 용량보다 커지는것을 방지
        }
        return x;
    }

    public int deque() throws EmptyIntQueueException {
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        int x = que[front++]; // front 위치 변경
        num--; // 갯수 축소
        if(front == capacity){ // 맨 위에 있었다면 다시 맨 아래가 front가 됨
            front = 0;
        }
        return x;
    }

    public int peek() throws EmptyIntQueueException {
        if(num <= 0){
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    public void clear(){
        num = front = rear = 0;
    }

    public int indexOf(int x){
        for(int i = 0; i < num; i++){
            int idx = (i + front) % capacity; //i + front가 capacity와 같다면 0번째로 이동하기 위해 capacity로 나눈 나머지를 이용
            if(que[idx] == x){
                return idx;
            }
        }
        return -1;
    }

    public int getCapacity(){
        return capacity;
    }
    public int size(){
        return num;
    }
    public boolean isEmpty(){
        return num <= 0;
    }
    public boolean isFull(){
        return num >= capacity;
    }

    public void dump(){
        if(num <= 0){
            System.out.println("큐가 비어있음");
        } else {
            for(int i = 0; i < num; i++){
                //i + front가 capacity와 같다면 0번째로 이동하기 위해 capacity로 나눈 나머지를 이용
                System.out.println(que[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }


}
