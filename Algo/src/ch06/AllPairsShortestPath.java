package src.ch06;

public class AllPairsShortestPath {

	public static void main(String[] args) {
		int graph[][] =
				{
						{0, INF, 2, INF},
						{1, 0, INF, INF},
						{INF, 8, 0, 3},
						{6, 4, INF, 0}
				};

		AllPairsShortestPath pathFinder = new AllPairsShortestPath();
		pathFinder.findAllPairShortestPath(graph, graph.length);
	}

	private void findAllPairShortestPath(int[][] graph, int n) {
		int dist[][] = new int[4][4];

		// 행렬 D를 가중치 행렬로 초기화
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				dist[i][j] = graph[i][j];
			}
		}

		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					dist[i][j] = Math.min(
							// d[i][k] 는  i -> k 경유 까지의 거리
							// d[k][j] 는 경유지에서 목적지 까지의 거리
							// d k=0 일 때 i -> j 의 최소 거리를 모두 구하고
							// d k=1 일 때 i -> j 의 최소 거리를 모두 구하고
							// ... 반복하여 최소 거리를 구할 수 있다.
							dist[i][j],
							dist[i][k] + dist[k][j]
					);
				}
			}
		}
		printSolution(dist, n);
	}

	private void printSolution(int dist[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (dist[i][j] == INF) {
					System.out.print("INF ");
				} else {
					System.out.print(dist[i][j] + " ");
				}
			}
			System.out.println();
		}
	}

	final static int INF = 9999;
}
