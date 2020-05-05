import java.util.Arrays;

public class TestHeap implements Heap {
    private int[] elem;
    private int useSize;
    private static final int DEFAULT_SIZE = 10;
     public TestHeap() {
         this.elem = new int[DEFAULT_SIZE];
         this.useSize = 0;
     }

    @Override
    public void AdjustDown(int root, int len) {
         int parent = root;
         int child = 2*parent+1;
         while(child < len) {
             //判断是否有右孩子   找到最大值下标
             if(child+1 < len && this.elem[child] < this.elem[child+1]) {
                 ++child;
             }
             if(elem[child] > elem[parent]) {
                 int tmp = elem[child];
                 elem[child] = elem[parent];
                 elem[parent] = tmp;
                 parent = child;
                 child = 2*parent+1;
             }else {
                 break;
             }
         }
    }

    @Override
     public void initHeap(int[] array) {
        for (int i = 0; i <array.length ; i++) {
            this.elem[i] = array[i];
            this.useSize++;
        }

        for (int i = (this.elem.length-1-1)/2; i >= 0 ; i--) {
            AdjustDown(i,this.useSize);
        }
    }

    @Override
    public void AdjustUp(int child, int len) {
         int parent = (child - 1)/2;
         while (child > 0) {
             if(child+1 < len && this.elem[child] < this.elem[child+1]) {
                 ++child;
             }
             if(this.elem[child] > this.elem[parent]) {
                 int tmp = elem[child];
                 elem[child] = elem[parent];
                 elem[parent] = tmp;
                 child = parent;
                 parent = (child-1)/2;
             }else {
                 break;
             }
         }
    }

    private boolean isFull() {
         return this.useSize == this.elem.length;
    }
    @Override
     public void pushHeap(int item) {
         if(isFull()) {
             this.elem = Arrays.copyOf(this.elem,
                     2*this.elem.length);
         }
         this.elem[this.useSize] = item;
         this.useSize++;
         AdjustUp(this.useSize-1,this.useSize);
    }

    @Override
     public int popHeap() {
         if(this.useSize == 0) {
             throw new UnsupportedOperationException("堆为空");
         }
         int tmp = this.elem[0];
         this.elem[0] = this.elem[this.useSize-1];
         this.elem[this.useSize-1] = tmp;
         this.useSize--;
         AdjustDown(0,this.useSize);
        return 0;
    }

    @Override
     public int getHeapTop() {
         if(this.useSize == 0) {
             throw new UnsupportedOperationException("堆为空");
         }
        return this.elem[0];
    }

    @Override
     public void HeapSort() {
         if(this.useSize == 0) {
             throw new UnsupportedOperationException("堆为空");
         }
         int end = this.useSize -1;
         while (end > 0) {
             AdjustDown(0,end);
             end--;
         }
    }

    @Override
     public void show() {
        for (int i = 0; i <this.useSize ; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }
}
