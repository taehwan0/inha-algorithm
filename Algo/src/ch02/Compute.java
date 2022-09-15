package src.ch02;

import java.util.Arrays;

public class Compute {

    public static void main(String[] args) {
        Compute compute = new Compute();

        int[] FREQ = {1, 0, 7, 5, 4, 3};
        int[] CUME;

        CUME = compute.calc(FREQ);
        System.out.println(Arrays.toString(CUME));

        CUME = compute.calc2(FREQ);
        System.out.println(Arrays.toString(CUME));
    }

    private int[] calc(int[] FREQ) {
        int n = FREQ.length;
        int[] CUME = new int[n];

        for (int i = 0; i < n; i++) {
            int sum = 0;

            for (int j = 0; j <= i; j++) {
                sum += FREQ[j];
            }
            CUME[i] = sum;
        }

        return CUME;
    }

    private int[] calc2(int[] FREQ) {
        int n = FREQ.length;
        int[] CUME = new int[n];

        CUME[0] = FREQ[0];
        for (int i = 1; i < n; i++) {
            CUME[i] = CUME[i - 1] + FREQ[i];
        }
        return CUME;
    }
}
