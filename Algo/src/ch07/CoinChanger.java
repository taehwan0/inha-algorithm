package src.ch07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoinChanger {

    public static void main(String[] args) {

        int[] coinValues = {500, 100, 50, 10, 5, 1};
        int[] countCoin = new int[coinValues.length];

        CoinChanger coinChanger = new CoinChanger();
        int count = coinChanger.change(coinValues, countCoin);

        System.out.println("전체 동전 수: " + count);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < coinValues.length; i++) {

            if (countCoin[i] == 0) {
                continue;
            }

            stringBuilder
                    .append(coinValues[i])
                    .append("원 동전: ")
                    .append(countCoin[i])
                    .append("개\n");
        }

        System.out.println(stringBuilder);

        // Map<Integer, Integer> change = coinChanger.change(coinValues);
        //
        // stringBuilder.delete(0, stringBuilder.length());
        //
        // for (int coinValue : coinValues) {
        //
        //     Integer countOfCoin = change.get(coinValue);
        //     if (countOfCoin == 0)
        //         continue;
        //
        //     stringBuilder
        //             .append(coinValue)
        //             .append("원 동전: ")
        //             .append(countOfCoin)
        //             .append("개\n");
        // }
        //
        // System.out.println(stringBuilder);
    }

    public int change(int[] coinValues, int[] countCoin) {
        System.out.print("금액 입력: ");

        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();

        for (int i = 0; i < coinValues.length; i++) {
            countCoin[i] = price / coinValues[i];
            price = price % coinValues[i];
        }

        return Arrays.stream(countCoin).sum();
    }

    public Map<Integer, Integer> change(int[] coinValues) {
        System.out.print("금액 입력: ");

        Scanner scanner = new Scanner(System.in);
        int price = scanner.nextInt();

        Map<Integer, Integer> countCoin = new HashMap<>();

        for (int coinValue : coinValues) {
            countCoin.put(coinValue, price / coinValue);
            price = price % coinValue;
        }

        return countCoin;
    }
}
