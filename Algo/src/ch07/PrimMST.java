package src.ch07;

public class PrimMST {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] W = new int[][]
            {
                {0, 2, INF, INF, 4},
                {2, 0, 8, INF, 4},
                {INF, 8, 0, 7, 6},
                {INF, INF, 7, 0, 3},
                {4, 4, 6, 3, 0}
            };

        PrimMST prim = new PrimMST();
        prim.printPrimTree(W, 5);
    }

    public void printPrimTree(int[][] W, int countOfVertex) {
        int[] near = new int[countOfVertex];
        boolean[] blue = new boolean[countOfVertex];

        int nextRed = 0;

        for (int i = 1; i < countOfVertex; i++) {
            blue[i] = true;
            near[i] = 0;
        }

        for (int i = 1; i < countOfVertex; i++) {
            int minValue = INF;

            for (int b = 0; b < countOfVertex; b++) {
                if (blue[b] && (W[b][near[b]] < minValue)) {
                    minValue = W[b][near[b]];
                    nextRed = b;
                }
            }
            blue[nextRed] = false;

            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder
                .append((char) (near[nextRed] + 65))
                .append("-")
                .append((char) (nextRed + 65))
                .append("\t")
                .append(W[nextRed][near[nextRed]]);

            System.out.println(stringBuilder);

            for (int b = 0; b < countOfVertex; b++) {
                if (blue[b] && (W[b][nextRed] < W[b][near[b]])) {
                    near[b] = nextRed;
                }
            }
        }
    }
}
