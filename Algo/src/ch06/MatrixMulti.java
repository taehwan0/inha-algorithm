package src.ch06;

public class MatrixMulti {

	public static void main(String[] args) {
		MatrixMulti matrixMulti = new MatrixMulti();
		int[] arr = {10, 20, 50, 1, 100};
		int size = arr.length;

		int result = matrixMulti.matrixDP(arr, size);
		System.out.println("최종 곱셈 횟수: " + result);
	}

	private int matrixDP(int[] arr, int size) {
		int[][] matrix = new int[size][size];

		for (int i = 1; i < size; i++) {
			matrix[i][i] = 0;
		}

		// len == 곱셈 행렬의 수
		for (int len = 1; len < size; len++) {
			for (int i = 1; i < size - len; i++) {
				int j = i + len;
				// 최소값을 찾기 위해 초기값으로 최대값을 입력함
				matrix[i][j] = Integer.MAX_VALUE;

				for (int k = i; k < j; k++) {
					int q = matrix[i][k] + matrix[k + 1][j] + arr[i - 1] * arr[k] * arr[j];
					matrix[i][j] = Math.min(matrix[i][j], q);
				}
			}
		}
		return matrix[1][size-1];
	}
}
