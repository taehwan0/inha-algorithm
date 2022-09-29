package src.ch04;

import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {
        Node[] node = new Node[6];

        for (int i = 0; i < node.length; i++) {
            node[i] = new Node(i + 1);
        }

        node[0].addNeighbor(node[1]);
        node[0].addNeighbor(node[2]);
        node[0].addNeighbor(node[4]);

        node[1].addNeighbor(node[0]);
        node[1].addNeighbor(node[2]);

        node[2].addNeighbor(node[0]);
        node[2].addNeighbor(node[1]);
        node[2].addNeighbor(node[3]);
        node[2].addNeighbor(node[4]);
        node[2].addNeighbor(node[5]);

        node[3].addNeighbor(node[2]);
        node[3].addNeighbor(node[5]);

        node[4].addNeighbor(node[0]);
        node[4].addNeighbor(node[2]);

        node[5].addNeighbor(node[2]);
        node[5].addNeighbor(node[3]);

        System.out.println("재귀를 이용한 깊이 우선 탐색: ");

        dsf(node[0]);
    }

    public static void dsf(Node node) {
        System.out.println("Node Info: " + node.getInfo());
        node.setVisited(true);
//        List<Node> neighbors = node.getNeighbors();
//        for (Node neighbor : neighbors) {
//            if(!neighbor.isVisited()) dsf(neighbor);
//        }
        node.getNeighbors()
                .stream()
                .filter(v -> v != null && !v.isVisited())
                .forEach(DepthFirstSearch::dsf);
    }
}
