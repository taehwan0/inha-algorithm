package src.ch06;

public class Knapsack {

    public static void main(String[] args) {
        Knapsack knapsack = new Knapsack();

        // int[] valueOfProductArray = {25, 15, 20, 30}; // 물건의 가치
        // int[] weightOfProductArray = {3, 1, 2, 4}; // 물건의 무게

        int[] valueOfProductArray = {10, 20, 25, 30}; // 물건의 가치
        int[] weightOfProductArray = {1, 2, 3, 4}; // 물건의 무게

        int maxWeight = 7; // 배낭 수용 가능 용량
        int productCount = valueOfProductArray.length; // 물건 총 개수

        int maxValue = knapsack.getMaxValue(maxWeight, weightOfProductArray, valueOfProductArray, productCount);

        System.out.println("최대 가치: " + maxValue);
    }

    public int getMaxValue(int maxWeight, int[] weightArray, int[] valueArray, int productCount) {
        int[][] resultTable = new int[productCount + 1][maxWeight + 1];

        for (int i = 0; i <= productCount; i++) {
            resultTable[i][0] = 0;
        }

        for (int j = 0; j <= maxWeight; j++) {
            resultTable[0][j] = 0;
        }

        for (int i = 1; i <= productCount; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                if (weightArray[i - 1] > j) {
                    resultTable[i][j] = resultTable[i - 1][j];
                } else {
                    // System.out.println(valueArray[i - 1] + ", " + resultTable[i - 1][j - weightArray[i - 1]]);
                    // System.out.println(resultTable[i - 1][j]);

                    resultTable[i][j] = Math.max(
                            valueArray[i - 1] + resultTable[i - 1][j - weightArray[i - 1]],
                            resultTable[i - 1][j]
                    );
                }
            }
            printResult(resultTable, productCount, maxWeight, i);
        }

        return getMaxValue(resultTable);
    }

    private int getMaxValue(int[][] table) {
        int maxValue = 0;
        for (int[] array : table) {
            for (int value: array) {
                maxValue = Math.max(maxValue, value);
            }
        }
        return maxValue;
    }

    public void printResult(int[][] table, int maxWeight, int productCount, int cnt) {
        System.out.println("물건: " + cnt);

        for (int weight = 0; weight <= maxWeight; weight++) {
            for (int count = 0; count <= productCount; count++) {
                System.out.printf("%3d ", table[weight][count]);
            }
            System.out.println();
        }
    }
}
