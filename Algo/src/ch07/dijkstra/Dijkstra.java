package src.ch07.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {

    private static ArrayList<Node>[] graph;

    public static void dijkstra(int n, int start) {
        boolean[] check = new boolean[n + 1];
        int[] dist = new int[n + 1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowVertex = pq.poll().getIndex();

            if (check[nowVertex]) {
                continue;
            }
            check[nowVertex] = true;

            for (Node next : graph[nowVertex]) {
                if (dist[next.getIndex()] > dist[nowVertex] + next.getCost()) {
                    dist[next.getIndex()] = dist[nowVertex] + next.getCost();

                    pq.offer(new Node(next.getIndex(), dist[next.getIndex()]));
                }
            }
        }

        //최소거리 출력
        for (int i : dist) {
            if (i == INF) {
                System.out.print(0 + " ");
            } else {
                System.out.print(i + " ");
            }
        }
    }

    public static void main(String[] args) throws IOException {

        //그래프 입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        //정점의 개수, 간선의 개수
        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[v].add(new Node(w, cost));
        }

        int start = Integer.parseInt(bf.readLine());

        //다익스트라 알고리즘 수행
        dijkstra(n, start);

    }
}
