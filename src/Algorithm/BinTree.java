package Algorithm;

import java.util.Comparator;

// 이진 트리에서는 부모 보다 작은 자식은 왼쪽에 부모 보다 큰 자식은 오른쪽에 배치한다.
public class BinTree<K,V> {
    static class Node<K,V> {
        private K key;
        private V data;
        private Node<K,V> left;  // 왼쪽 자식 노드를 가리킵니다.
        private Node<K,V> right; // 오른쪽 자식 노드를 가리킵니다.

        Node(K key, V data, Node<K,V> left, Node<K,V> right){
            this.data = data;
            this.key = key;
            this.left = left;
            this.right = right;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return data;
        }

        void print(){
            System.out.println(data);
        }
    }
    private Node<K,V> root;
    private Comparator<? super K> comparator = null;

    public BinTree(){
        root = null;
    }
    public BinTree(Comparator<? super K> c){
        this();
        comparator = c;
    }

    //키값 2개 비교
    private int comp(K key1, K key2){
        return (comparator == null) ? ((Comparable<K>)key1).compareTo(key2) : comparator.compare(key1,key2);
    }

    public V search(K key){
        Node<K,V> p = root;

        while(true){
            if(p == null){
                return null;
            }
            int cond = comp(key,p.getKey());
            if(cond == 0){
                return p.getValue();
            } else if(cond < 0){
                p = p.left;
            } else {
                p = p.right;
            }
        }
    }

    private void addNode(Node<K,V> node, K key, V data){
        int cond = comp(key, node.getKey());
        if(cond == 0){
            return;
        } else if(cond < 0){
            if(node.left == null){
                node.left = new Node<K,V>(key,data,null,null);
            } else{
                addNode(node.left, key, data);
            }
        } else {
            if(node.right == null){
                node.right = new Node<K,V>(key,data,null,null);
            } else {
                addNode(node.right, key, data);
            }
        }
    }
    public void add(K key, V data){
        if(root == null){
            root = new Node<K,V>(key,data,null,null);
        } else {
            addNode(root, key, data);
        }
    }

    public boolean remove(K key){
        Node<K,V> p = root;
        Node<K,V> parent = null;
        boolean isLeftChild = true;

        while(true){
            if(p == null){
                return false;
            }
            int cond = comp(key, p.getKey());
            if(cond == 0){
                break;
            } else {
                parent = p;
                if(cond < 0){
                    isLeftChild = true;
                    p = p.left;
                } else {
                    isLeftChild = false;
                    p = p.right;
                }
            }
        }
        if(p.left == null){
            if(p == root){
                root = p.right;
            } else if(isLeftChild){
                parent.left = p.right;
            } else {
                parent.right = p.right;
            }
        } else if(p.right == null){
            if(p == root){
                root = p.left;
            } else if(isLeftChild){
                parent.left = p.left;
            } else {
                parent.right = p.left;
            }
        } else {
            parent = p;
            Node<K,V> left = p.left;
            isLeftChild = true;
            while(left.right != null){
                parent = left;
                left = left.right;
                isLeftChild = false;
            }
            // left를 p로 옮김
            p.key = left.key;
            p.data = left.data;
            if(isLeftChild){
                parent.left = left.left; // left 삭제
            } else {
                parent.right = left.left; // left 삭제
            }
        }
        return true;
    }

    //node를 루트로 하는 서브트리의 노드를 키값의 오름차순으로 출력
    public void printSubTree(Node node){
        if(node != null){
            printSubTree(node.left); // 왼쪽 서브트리를 키값의 오름차순으로 출력
            System.out.println(node.key + " " + node.data); // node 출력
            printSubTree(node.right); // 오른쪽 서브트리를 키값의 오름차순으로 출력
        }
    }

    //모든 노드를 키값의 오름차순으로 출력
    public void print(){
        printSubTree(root);
    }
}
