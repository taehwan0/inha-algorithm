package src.ch05;

// BinarySearch
public class Selection {

    public static void main(String[] args) {
        int[] array = {48, 12, 70, 38, 75, 67, 96, 52, 81};
        int target = 5;

        Selection selection = new Selection();
        int result = selection.selectionSort(array, target);
        System.out.println(target + " 번 째 값은: " + result);

    }

    public int selectionSort(int[] array, int target) {
        return selectionSort(array, 0, array.length - 1, target);
    }

    private int selectionSort(int[] array, int first, int last, int target) {
        int partition = QuickSort.partition(array, first, last);
        // small 의 크기 계산
        int s = (partition - 1) - first + 1;
        if(target <= s) {
            return selectionSort(array, first, partition - 1, target);
        } else if(target == s + 1) {
            return array[partition];
        } else {
            return selectionSort(array, partition + 1, last, target - s - 1);
        }
    }
}
