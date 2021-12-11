public class Node<T> {
    T data;
    Node<T> next;

    Node(T data,Node<T> next) {
        this.data = data;
        this.next = next;
    }
    
    Node(){
        this.data = null;
        this.next = null;
    }

}
