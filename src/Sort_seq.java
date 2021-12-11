public class Sort_seq{

    int [] elements;

    Sort_seq(int [] elements){
        this.elements = elements;
    }
    
    Sort_seq(){
        elements = null;
    }

    public void autoBuild(int size, int base,int noise) {
        elements = new int [size];
        for(int i = 0; i < elements.length; i++){
            elements[i] = (int) (base * Math.random() * 10 + noise * Math.random() * 10 - noise * Math.random() * 8);
        }
    }

    public void print() {
        for (int i = 0; i < elements.length; i++){
            System.out.print(elements[i] + "\t");
        }
        System.out.println();
    }

    /**
     * 交换器
     * @param elements
     *          数据存储器
     * @param i
     *          交换位置1
     * @param j
     *          交换位置2
     */
    private void swap(int i,int j){
        elements[i] = elements[i] ^ elements[j];
        elements[j] = elements[i] ^ elements[j];
        elements[i] = elements[i] ^ elements[j];
    }

    /**
     * 插入排序
     * @param elements
     *          数据存储器
     * @param asc
     *          升降序
     */
    public void insertSort(boolean asc) {
        for (int i = 1; i < elements.length; i++) {
            int p = elements[i],j;
            for (j = i-1; j >= 0 &&( asc? p < elements[j]: p > elements[j]) ; j--) {
                elements[j + 1] = elements[j];
            }
            elements[j + 1] = p;
        }
    }

    /***
     * 希尔排序
     * @param elements
     *          数据存储器
     * @param asc
     *          升降序
     */
    public void shellSort(boolean asc) {
        for(int detla = elements.length/2;detla > 0;detla/=2){
            for(int i = detla;i  < elements.length;i++){
                int x = elements[i],j;
                for(j = i - detla;j >= 0 &&( asc? x < elements[j]: x > elements[j]);j -= detla){
                    elements[j + detla] = elements[j];
                }
                elements[j + detla] = x;
            }
        }
    }

    /**
     * 冒泡排序
     * @param elements
     *          数据存储器
     * @param asc
     *          升降序
     */
    public void bubbleSort(boolean asc) {
        boolean changed = true;
        for(int i = 1; i < elements.length & changed; i++){
            changed = false;
            for (int j = 0;j < elements.length - i;j++){
                if((asc? elements[j] > elements[j + 1]:elements[j] < elements[j + 1])){
                    swap(j,j + 1);
                    changed = true;
                }
            }
        }
    }

    /**
     * 快速排序
     * @param elements
     * @param asc
     */
    public void quickSort(){
        quickSort(0,elements.length-1);
    }

    private void quickSort(int begin, int end) {
        if(begin >= 0 && begin < end && end < elements.length){
            int i = begin,j = end;
            int x = elements[i];
            while(i != j){
                while(i < j && elements[j] >= x){
                    j--;
                }
                if(i < j){
                    elements[i++] = elements[j];
                }
                while(i < j && elements[i] <= x){
                    i++;
                }
                if(i < j){
                    elements[j--] = elements[i];
                }
            }
            elements[i] = x;
            quickSort(begin,j-1);
            quickSort(i + 1,end);
        }
    }

    /**
     * 选择排序
     * @param elements
     * @param asc
     */
    public void selectSort(){
        for(int i = 0; i < elements.length - 1; i++){
            int min = i;
            for(int j = i + 1;j < elements.length;j++){
                if(elements[j] < elements[min]){
                    min = j;
                }
            }
            if(min != i){
                swap(i,min);
            }
        }
    }
}
