package src.ch06;

/**
 * Dynamic Programming Sample
 */
public class CutRod {

    public static void main(String[] args) {
        CutRod cutRod = new CutRod();
        int[] price = {2, 5, 9, 10};

        int maxPrice = cutRod.cutRodDP(price, price.length);
        System.out.println("최대 금액: " + maxPrice);

        int maxPrice2 = cutRod.cutRodDC(price, price.length);
        System.out.println("최대 금액: " + maxPrice2);
    }

    public int cutRodDP(int[] price, int size) {
        int[] maxSell = new int[size + 1];

        maxSell[0] = 0;

        for (int i = 1; i <= size; i++) {
            int maxValue = 0;

            for (int j = 1; j <= i ; j++) {
                maxValue = Math.max(maxValue, price[j - 1] + maxSell[i - j]);
            }
            maxSell[i] = maxValue;
        }

        return maxSell[size];
    }

    public int cutRodDC(int[] price, int size) {
        if(size == 0 ) return 0;

        int maxSell = 0;

        for (int i = 1; i <= size; i++) {
            maxSell = Math.max(maxSell, price[i - 1] + cutRodDC(price,size - i));
        }
        return maxSell;
    }
}
