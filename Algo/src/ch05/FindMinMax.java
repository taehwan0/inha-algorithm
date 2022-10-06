package src.ch05;

public class FindMinMax {

    public static void main(String[] args) {
        int[] array = {24, 75, 92, 83, 61, 48, 97, 50};
        int[] answer;
        FindMinMax findMinMax = new FindMinMax();

        answer = findMinMax.findMinMax(array, 0, array.length - 1);

        System.out.println("Min: " + answer[0]);
        System.out.println("Max: " + answer[1]);
    }

    public int[] findMinMax(int[] array, int head, int tail) {
        int mid;
        int[] result = new int[2];
        int[] left;
        int[] right;

        if(head == tail) {
            result[0] = array[head];
            result[1] = array[head];
        } else if(head == tail - 1) {
            if(array[head] < array[tail]) {
                result[0] = array[head];
                result[1] = array[tail];
            } else {
                result[0] = array[tail];
                result[1] = array[head];
            }
        } else {
            mid = (head + tail) / 2;
            left = findMinMax(array, head, mid);
            right = findMinMax(array, mid + 1, tail);

            result[0] = Math.min(left[0], right[0]);
            result[1] = Math.max(left[1], right[1]);
        }
        return result;
    }
}
