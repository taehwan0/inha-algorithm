package src.ch03;

import java.util.ArrayList;
import java.util.List;

public class MinHeap implements Heap{

    private List<Integer> heap;

    public MinHeap() {
        this.heap = new ArrayList<>();
        this.heap.add(0);
    }

    public int getMin() {
        return heap.get(1);
    }

    public void insert(int value) {
        heap.add(value);

        int pos = heap.size() - 1;

        while(pos > 1 && heap.get(pos / 2) > heap.get(pos)) {
            swap(pos, pos / 2);

            pos = pos / 2;
        }
    }

    public int delete() {
        if(heap.size() <= 1) return 0;

        int deleteValue = heap.get(1);
        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int pos = 1;
        while (pos * 2 < heap.size()) {
            int minPos = pos * 2;
            int min = heap.get(pos * 2);

            if((pos * 2 + 1) < heap.size() && heap.get(pos * 2 + 1) < min) {
                minPos = pos * 2 + 1;
                min = heap.get(minPos);
            }

            if(min > heap.get(pos)) break;

            swap(pos, minPos);

            pos = minPos;
        }
        return deleteValue;
    }

    void swap(int indexA, int indexB) {
        int temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }
}
