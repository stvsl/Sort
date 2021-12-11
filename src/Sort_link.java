public class Sort_link<T> {

    /**
     * 比较器
     * 
     * @param a
     *          元素1
     * @param b
     *          元素2
     * @return
     *         1 ：a > b;
     *         <p>
     *         0 : a = b;
     *         <p>
     *         -1 : a < b;
     *         <p>
     */
    int compare(T a, T b) {
        if ((int) a > (int) b) {
            return 1;
        } else if ((int) a == (int) b) {
            return 0;
        } else {
            return -1;
        }
    };


    /**
     * 交换a.next和b.next
     * 此段代码未使用(脑子抽了写这个...)
     * @param a
     * @param b
     */
    public void swap(Node<T> a, Node<T> b) {
        Node<T> an = a.next;
        Node<T> bn = b.next;
        if (an.next == bn) {
            // 在链表中抹除bn位置结点
            an.next = an.next.next;
            // 将an位置元素顶替成bn
            a.next = bn;
            // 此时bn的后一元素应该是an
            bn.next = an;
        } else {
            // 删除bn结点
            b.next = b.next.next;
            // an元素位置替换成bn
            a.next = bn;
            //位置交换
            bn.next = an.next;
            an.next = b.next;
            b.next = an;
        }
    }

    /**
     * 插入排序
     * @param list
     * @param high
     *      升降序排序控制,ture 升序,false降序
     */
    public void insertSort(LinkedList<T> list,boolean high) {
        //存储当前趟的操作位置(操作结点为p.next)
        Node<T> p = list.head.next;
        //循环遍历直到操作完成
        while (p != null) {
            //用于矛定比较位置,根据插入排序定义可以确定其位置区间为头结点到操作位置
            Node<T> frunner = list.head;
            //防止结点传染,保存下一趟p应该在的位置
            Node<T> next = p.next;
            //插入操作事件循环
            while (frunner.next != p.next && p.next != null) {
                //确定操作结点的插入位置,找到后进行插入操作
                if (this.compare(frunner.next.data, p.next.data) == (high?1:-1)) {
                    //存储操作结点
                    Node<T> tmp = p.next;
                    //操作结点删除
                    p.next = p.next.next;
                    // 操作结点next指针继承待插入位置的next指针
                    tmp.next = frunner.next;
                    //结点插入
                    frunner.next = tmp;
                    //执行完毕后跳出事件循环
                    break;
                }
                frunner = frunner.next;
            }
            //p位置调整
            p = next;
        }
    }

    /**
     * 选择排序
     * @param list
     * @param high
     *      升降序排序控制,ture 升序,false降序
     */
    public void selectSort(LinkedList<T> list,boolean high) {
        //存储剩余的待排序的结点(或理解为将当前链表中的元素交给ready)
        Node<T> ready = list.head;
        //存储已排序结点并将已排序结点串交给list
        Node<T> sorted = new Node<T>(null,null);
        list.head = sorted;
        //循环遍历剩余结点直到剩余结点为空
        while(ready.next != null){
            //用于在剩余结点中游离
            Node<T> prepared = ready;
            //寻找最小结点(最小结点的位置是min.next)
            Node<T> min = prepared;
            while(prepared.next != null){
                if(this.compare(min.next.data,prepared.next.data) == (high?1:-1)){
                    min = prepared;
                }
                prepared = prepared.next;
            }
            //在已排序序列中添加当前趟最小值
            sorted.next = min.next;
            //删除此趟最小值
            min.next = min.next.next;
            //重新矛定已排序的末尾位置
            sorted = sorted.next;
        }
    }

}
