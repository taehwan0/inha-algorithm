package src.ch04;

import java.util.ArrayList;
import java.util.List;

/**
 * 그래프 노드 클래스
 */
public class Node {

    private int info;
    private boolean visited;
    private List<Node> neighbors;

    public Node(int info) {
        this.info = info;
        this.visited = false;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node node) {
        this.neighbors.add(node);
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getNeighbors() {
        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }
}
