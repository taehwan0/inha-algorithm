package src.ch07.kruskal;

public class Subset {

    private int parent;
    private int rank;

    public void incrementRank() {
        rank++;
    }

    public int getParent() {
        return parent;
    }

    public int getRank() {
        return rank;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
