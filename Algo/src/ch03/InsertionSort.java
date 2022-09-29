package src.ch03;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] array = {9, 5, 25, 70, 60, 30, 1, 8};
        System.out.println("정렬 전 배열 : " + Arrays.toString(array));
        insertionSort(array);
        System.out.println("정렬 후 배열 : " + Arrays.toString(array));
    }

    public static void insertionSort(int[] array) {
        // i == 정렬을 시작할 인덱스
        // j == 정렬된 배열의 마지막 인덱스
        for(int i = 1; i < array.length; i++) {
            int j = i - 1;
            int element = array[i];

            while(j >= 0 && array[j] >= element) {
                // 정렬된 인덱스가 더 크면 한칸 뒤로 저장하고 인덱스를 앞으로 이동
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = element;
        }
    }
}
