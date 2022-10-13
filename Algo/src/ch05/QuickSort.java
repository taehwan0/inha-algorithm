package src.ch05;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = {15, 22, 13, 27, 12, 10, 20, 25, 32};
        System.out.print("정렬 전 배열: ");
        printArray(array);

        quickSort(array, 0, array.length - 1);

        System.out.print("\n정렬 후 배열: ");
        printArray(array);

    }

    private static void quickSort(int[] array, int low, int high) {
        if(low < high) {
            int pivot = partition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int i, j, temp;
        i = low + 1;
        j = high;

        while (i <= j) {
            if(array[i] <= array[low]) i++;
            else if(array[j] > array[low]) j--;
            else {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        temp = array[low];
        array[low] = array[j];
        array[j] = temp;

        return j;
    }

    private static void printArray(int[] array) {
        Arrays.stream(array).forEach(v -> System.out.print(v + " "));
    }
}
