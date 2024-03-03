package Algorithm;


import java.util.Comparator;

public class LinkedList <E>{
    private Node<E> head;
    private Node<E> crnt;
    public LinkedList(){
        head = crnt = null;
    }
    class Node<E> {
        private E data;
        private Node<E> next; // 다음 노드를 참조
        Node(E data, Node<E> next){
            this.data = data;
            this.next = next;
        }
    }

    public E search(E obj, Comparator<? super E> c){
        Node<E> ptr = head;

        while(ptr != null){ //꼬리만 아니면 됨
            if(c.compare(obj,ptr.data) == 0){ // 같네 반환
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next; //다르네 다음
        }
        return null;
    }

    public void addFirst(E obj){
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj,ptr); // 새로운거를 맨 앞에 추가하니 다음 노드가 이전의 head가 됨
    }

    public void addLast(E obj){
        if(head == null){
            addFirst(obj);
        } else{
            Node<E> ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj,null);
        }
    }

    public void removeFirst(){
        if(head != null){
            head = crnt = head.next;
        }
    }

    public void removeLast(){
        if(head != null){
            if(head.next == null){
                removeFirst();
            } else{
                Node<E> ptr = head;
                Node<E> pre = head;

                while(ptr.next != null){
                    pre = ptr;
                    ptr = ptr.next;
                }
                pre.next = null;
                crnt = pre;
            }
        }
    }

    // 원하는거 삭제
    public void remove(Node p){
        if(head != null){
            if(p == head){
                removeFirst();
            } else{
                Node<E> ptr = head;
                while(ptr.next != p){
                    ptr = ptr.next;
                    if(ptr == null) return;
                }
                ptr.next = p.next; // 한 칸 건너뛰기
                crnt = ptr; // 삭제한거 이전 노드 선택
            }
        }
    }

    // 현재 선택 노드 삭제
    public void removeCurrentNode(){
        remove(crnt);
    }

    public void clear(){
        while(head != null){
            removeFirst();
        }
        crnt = null;
    }

    public boolean next(){
        if(crnt == null || crnt.next == null){
            return false;
        }
        crnt = crnt.next;
        return true;
    }

    public void printCurrentNode(){
        if(crnt == null){
            System.out.println("선택한 노드 없음");
        } else{
            System.out.println(crnt.data);
        }
    }

    public void dump(){
        Node<E> ptr = head;
        while(ptr != null){
            System.out.println(ptr.data);
            ptr = ptr.next;
        }
    }
}
