package src.ch04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    public static void main(String[] args) {

        Node[] node = new Node[7];

        for (int i = 0; i < node.length; i++) {
            node[i] = new Node(i);
        }

        node[1].addNeighbor(node[2]);
        node[1].addNeighbor(node[3]);
        node[1].addNeighbor(node[5]);

        node[3].addNeighbor(node[4]);
        node[3].addNeighbor(node[6]);

        Search search = new Search();
        search.bfs(node[1]);
    }
}

class Search {
    private final Queue queue;

    public Search() {
        this.queue = new LinkedList();
    }

    public void bfs(Node node) {
        queue.add(node);

        while(!queue.isEmpty()) {
            Node nextNode = (Node) queue.remove();
            if(!nextNode.isVisited()) {
                nextNode.setVisited(true);
                System.out.println("Node Info: " + nextNode.getInfo());
                pushAtQueue(nextNode);
            }
        }
    }

    private void pushAtQueue(Node node) {
        node.getNeighbors().
                stream().
                filter(n -> !n.isVisited()).
                forEach(this.queue::add);
    }
}
