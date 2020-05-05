import java.util.Arrays;

public class TestDemo {
    public static void main(String[] args) {
        int[] array = {10,2,30,4,5,6,7,8};
        TestHeap testHeap = new TestHeap();
        testHeap.initHeap(array);

        testHeap.show();
        testHeap.AdjustUp(0,55);
        testHeap.show();
        testHeap.pushHeap(11);
        testHeap.show();
        testHeap.popHeap();
        testHeap.show();

    }
}
