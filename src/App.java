public class App {
    public static void main(String[] args) throws Exception {
        println("顺序结构排序测试:");
        seqtest();
        println("链式结构排序测试:");
        linktest();
    }

    private static void seqtest() throws Exception {
        Sort_seq seq = new Sort_seq();
        seq.autoBuild(10,5,20);
        println("插入排序");
        float begin = System.nanoTime();
        seq.insertSort(true);
        seq.print();
        float end = System.nanoTime();
        System.out.println("运行时间:" + (end - begin));

        seq.autoBuild(10,5,20);
        println("冒泡排序");
        begin = System.nanoTime();
        seq.bubbleSort(true);
        seq.print();
        end = System.nanoTime();
        System.out.println("运行时间:" + (end - begin));

        seq.autoBuild(10,5,20);
        println("希尔排序");
        begin = System.nanoTime();
        seq.shellSort(true);
        seq.print();
        end = System.nanoTime();
        System.out.println("运行时间:" + (end - begin));

        seq.autoBuild(10,5,20);
        println("快速排序");
        begin = System.nanoTime();
        seq.quickSort();
        seq.print();
        end = System.nanoTime();
        System.out.println("运行时间:" + (end - begin));

        println("选择排序");
        seq.autoBuild(10,5,20);
        begin = System.nanoTime();
        seq.selectSort();
        seq.print();
        end = System.nanoTime();
        System.out.println("运行时间:" + (end - begin));
    }



    private static void linktest() throws Exception {
        Sort_link<Integer> sl = new Sort_link<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>(10,5,10);
        println("链表内元素:");
        list.print();
        println("直接插入排序后:"); 
        float begin = System.nanoTime();
        sl.insertSort(list,true);
        list.print();
        float end = System.nanoTime();
        System.out.println("运行时间:" + (end - begin));

        list = new LinkedList<Integer>(10,5,10);
        println("链表内元素:");
        list.print();
        println("简单选择排序后:");
        begin = System.nanoTime();
        sl.selectSort(list,true);
        list.print();
        end = System.nanoTime();
        System.out.println("运行时间:" + (end - begin));
    }

    public static void println(Object obj) throws Exception {
        System.out.println(obj);
    }
}
