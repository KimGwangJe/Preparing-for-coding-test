package Algorithm;

import java.util.Comparator;

public class DoubleLinkedList<E> {
    class Node<E> {
        private E data;
        private Node<E> prev;
        private Node<E> next;

        Node(){
            data = null;
            prev = next = this;
        }

        Node(E obj, Node<E> prev, Node<E> next){
            data = obj;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> crnt;

    public DoubleLinkedList(){
        head = crnt = new Node<E>();
    }

    // 원형이니까 헤드의 NEXT가 헤드를 가리키게 설정해둬야됨
    public boolean isEmpty(){
        return head.next == head;
    }

    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head.next; // 헤드의 다음부터 검색

        while(ptr != head){ // 아무것도 없거나(헤드의 next가 head이거나) 원하는 것을 찾지 못했을때
            if(c.compare(obj,ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }
        return null;
    }

    public void printCurrentNode(){
        if(isEmpty()){
            System.out.println("선택 노드가 없음");
        } else {
            System.out.println(crnt.data);
        }
    }

    public void dump(){
        Node<E> ptr= head.next; // 헤드부터 시작해서

        while(ptr != head){ // 다시 헤드가 될때까지 반복
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }

    public void dumpReverse(){
        Node<E> ptr = head.prev; // 꼬리 선택

        while(ptr != head){ // 헤드까지 갔을시에
            System.out.println(ptr.data);
            ptr = ptr.prev; // 꼬리부터 이전으로 옮기면서 헤드까지 이동
        }
    }

    public boolean next(){
        if(isEmpty() || crnt.next == head){
            return false; // 진행 불가
        }
        crnt = crnt.next;
        return true;
    }

    public boolean prev(){
        if(isEmpty() || crnt.prev == head){
            return false; // 진행 불가
        }
        crnt = crnt.prev;
        return true;
    }

    public void add(E obj){
        Node<E> node = new Node<E>(obj, crnt, crnt.next); // 삽입할 노드 생성
        crnt.next = crnt.next.prev = node;
        crnt = node;
    }

    public void addFirst(E obj){
        crnt = head;
        add(obj);
    }

    public void addLast(E obj){
        crnt = head.prev; // 헤드의 prev가 꼬리임
        add(obj);
    }

    public void removeCurrentNode(){
        if(!isEmpty()){
            crnt.prev.next = crnt.next; // 이전 노드가 가리키는 다음 노드를 현재 노드의 다음 노드가 되도록 설정
            crnt.next.prev = crnt.prev; // 다음 노드가 가리키는 이전 노드를 현재 노드의 이전 노드가 되도록 설정
            crnt = crnt.prev;
            if(crnt == head) crnt = head.next;
        }
    }

    public void remove(Node p){
        Node<E> ptr = head.next;

        while(ptr != head){
            if(ptr == p){
                crnt = p;
                removeCurrentNode();
                break;
            }
            ptr = ptr.next;
        }
    }

    public void removeFirst(){
        crnt = head.next;
        removeCurrentNode();
    }

    public void removeLast(){
        crnt = head.prev;
        removeCurrentNode();
    }

    public void clear(){
        while(!isEmpty()){
            removeFirst();
        }
    }
}
