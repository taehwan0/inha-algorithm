package src.ch07.kruskal;

import java.util.Arrays;
import java.util.Scanner;

public class Kruskal {

    private int V; // 정점들의 수
    private int E; // 간선들의 수
    private Edge[] edge;

    public static void main(String[] args) {
        int V = 5;
        int E = 7;

        Kruskal graph = new Kruskal(V, E);

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < E; i ++) {
            graph.edge[i].setSrc(sc.nextInt());
            graph.edge[i].setDest(sc.nextInt());
            graph.edge[i].setWeight(sc.nextInt());
        }

        graph.kruskalMST();
    }

    public Kruskal(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];

        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }

    public int find(Subset[] subsets, int i) {
        if (subsets[i].getParent() != i) {
            subsets[i].setParent(find(subsets, subsets[i].getParent()));
        }

        return subsets[i].getParent();
    }

    public void union(Subset[] subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].getRank() < subsets[yroot].getRank()) {
            subsets[xroot].setParent(yroot);
        } else if (subsets[xroot].getRank() > subsets[yroot].getRank()) {
            subsets[yroot].setParent(xroot);
        } else {
            subsets[yroot].setParent(xroot);
            subsets[xroot].incrementRank();
        }
    }

    public void kruskalMST() {
        Edge[] result = new Edge[V];
        int e = 0;
        int i = 0;

        for (i = 0; i < V; ++i) {
            result[i] = new Edge();
        }

        Arrays.sort(edge);

        Subset[] subsets = new Subset[V];

        for (i = 0; i < V; ++i) {
            subsets[i] = new Subset();
        }

        for (int v = 0; v < V; ++v) {
            subsets[v].setParent(v);
            subsets[v].setRank(0);
        }

        i = 0;
        while (e < V - 1) {
            Edge nextEdge = new Edge();
            nextEdge = edge[i];
            i++;

            int x = find(subsets, nextEdge.getSrc());
            int y = find(subsets, nextEdge.getDest());

            if (x != y) {
                result[e++] = nextEdge;
                union(subsets, x, y);
            }
        }

        System.out.println("\n찾은 최소 비용 신장 트리\n");
        System.out.println("간선 가중치");

        for (i = 0; i < e; ++i) {
            System.out.println("(" + result[i].getSrc() + ", "
            + result[i].getDest() + ")\t " + result[i].getWeight());
        }
    }
}
