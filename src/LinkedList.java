public class LinkedList<T> {
    Node<T> head;

    LinkedList(T[] elements) {
        this.head = new Node<T>();
        Node<T> pos = this.head;
        for (int i = 0; i < elements.length; i++) {
            pos.next = new Node<T>(elements[i], null);
            pos = pos.next;
        }
    }

    /**
     * 自动构造
     * 
     * @param size
     *              表长度
     * @param base
     *              基准值
     * @param noise
     *              噪音大小
     */
    @SuppressWarnings("unchecked")
    LinkedList(int size, int base, int noise) {
        Integer[] ele = new Integer[size];
        this.head = new Node<T>();
        Node<T> pos = this.head;
        for (int i = 0; i < size; i++) {
            ele[i] = (int) (base * Math.random() * 10 + noise * Math.random() * 10 - noise * Math.random() * 8);
            pos.next = new Node<T>((T) ele[i], null);
            pos = pos.next;
        }
    }

    void print() {
        Node<T> pos = this.head.next;
        while (pos != null) {
            System.out.print(pos.data + "\t");
            pos = pos.next;
        }
        System.out.println();
    }
}
