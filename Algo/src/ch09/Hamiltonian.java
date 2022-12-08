package src.ch09;

public class Hamiltonian {

    private int[] path;
    private int n;

    public Hamiltonian(int edgeCount, int routeCount) {
        this.n = edgeCount;
        path = new int[routeCount];
    }

    public static void main(String[] args) {
        Hamiltonian hamiltonian = new Hamiltonian(4, 5);

        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 0, 0, 1},
            {1, 1, 1, 0},
        };

        hamiltonian.setStart(1);
        hamiltonian.findHamiltonian(graph, 0);
    }

    public void findHamiltonian(int[][] G, int i) {
        if (valid(G, i)) {
            if (i == n - 1) {        // 찾은 해밀토니안 회로 path[0..n-1]을 출력한다
                System.out.print("찾은 해밀토니안 회로: ");
                for (int j = 0; j < n; j++) {
                    System.out.print(path[j] + " -> ");
                }
                System.out.println(path[0]);            // 시작점으로
            } else {
                // i 번째로 방문할 정점으로 시작 정점을 제외한 모든 정점을 시도해 본다
                for (int j = 2; j <= n; j++) {
                    path[i + 1] = j;
                    findHamiltonian(G, i + 1);
                }
            }
        }
    }

    private void hamiltonianPathFind(int[][] graph, int i) {
        if (valid(graph, i)) {
            if (i == n - 1) {
                System.out.println("해밀토니안 회로: ");
                for (int p : path) {
                    System.out.print(p + " -> ");
                }
                System.out.println(path[0]);
            }
        } else {
            for (int j = 2; j <= n; j++) {
                path[i + 1] = j;
                hamiltonianPathFind(graph, i + 1);
            }
        }
    }

    private boolean valid(int[][] graph, int i) {
        if ((i == n - 1) && (graph[path[n - 1] - 1][path[0] - 1] == 0)) {
            return false;
        } else if (i > 0 && graph[path[i - 1] - 1][path[i] - 1] == 0) {
            return false;
        } else {
            int j = 1;
            while (j < i) {
                if (path[i] == path[j]) {
                    return false;
                }
                j++;
            }
        }
        return true;
    }

    public void setStart(int start) {
        path[0] = start;
    }
}
