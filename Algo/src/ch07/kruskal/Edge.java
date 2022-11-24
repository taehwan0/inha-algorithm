package src.ch07.kruskal;

public class Edge implements Comparable<Edge> {

    private int src;
    private int dest;
    private int weight;

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }

    public int getSrc() {
        return src;
    }

    public void setSrc(int src) {
        this.src = src;
    }

    public int getDest() {
        return dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
