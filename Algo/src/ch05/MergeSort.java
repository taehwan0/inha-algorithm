package src.ch05;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] array = {91, 82, 13, 85, 68, 80, 98, 24};

        System.out.print("주어진 배열: ");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.print("\n정렬된 배열: ");
        printArray(array);
    }

    private static void mergeSort(int[] array, int low, int high) {
        if(low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] temp = new int[high + 1];
        int nextIndex = low;
        int i = low;
        int j = mid + 1;

        while(i <= mid && j <= high) {
            if(array[i] <= array[j]) {
                temp[nextIndex] = array[i];
                i++;
            } else {
                temp[nextIndex] = array[j];
                j++;
            }
            nextIndex++;
        }

        if(i > mid) {
            for (int loop = j; loop <= high; loop++) {
                temp[nextIndex] = array[loop];
                nextIndex++;
            }
        } else {
            for (int loop = i; loop <= mid; loop++) {
                temp[nextIndex] = array[loop];
                nextIndex++;
            }
        }

        for (int loop = low; loop <= high; loop++) {
            array[loop] = temp[loop];
        }
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(v -> System.out.print(v + " "));
    }
}
