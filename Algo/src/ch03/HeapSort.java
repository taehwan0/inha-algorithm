package src.ch03;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int[] array = {9, 5, 25, 70, 60, 30, 1, 8};
        System.out.println("정렬 전 배열 : " + Arrays.toString(array));
        heapSortDESC(array);
        System.out.println("정렬 후 배열 : " + Arrays.toString(array));

        System.out.println("정렬 전 배열 : " + Arrays.toString(array));
        heapSortASC(array);
        System.out.println("정렬 후 배열 : " + Arrays.toString(array));
    }

    public static void heapSortDESC(int[] array) {
        MaxHeap heap = new MaxHeap();
        for(int i : array) {
            heap.insert(i);
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = heap.delete();
        }
    }

    public static void heapSortASC(int[] array) {
        MinHeap heap = new MinHeap();
        for(int i : array) {
            heap.insert(i);
        }
        for(int i = 0; i < array.length; i++) {
            array[i] = heap.delete();
        }
    }
}
