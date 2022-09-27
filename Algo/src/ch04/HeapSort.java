package src.ch04;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {9, 5, 25, 70, 60, 30, 1, 8};
        System.out.println("정렬 전 배열 : " + Arrays.toString(array));
        heapSort(array);
        System.out.println("정렬 후 배열 : " + Arrays.toString(array));
    }

    public static void heapSort(int[] array) {
        MaxHeap heap = new MaxHeap();
        for(int i : array) {
            heap.insert(i);
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = heap.delete();
        }
    }
}
