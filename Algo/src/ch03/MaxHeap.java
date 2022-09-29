package src.ch03;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap implements Heap {
    private List<Integer> heap;

    public MaxHeap() {
        this.heap = new ArrayList<>();
        heap.add(Integer.MAX_VALUE);
    }

    public int getMax() {
        return heap.get(1);
    }

    public void insert(int value) {
        heap.add(value);
        // 아래부터 힙의 삽입 연산

        int pos = heap.size() - 1;
        while(pos > 1 && heap.get(pos / 2) < heap.get(pos)) {
            swap(pos, pos / 2);

            pos = pos / 2;
        }
    }

    public int delete() {
        if(heap.size() <= 1) return 0;

        int deletedValue = heap.get(1);

        heap.set(1, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int pos = 1;
        while((pos * 2) < heap.size()) {
            int max = heap.get(pos * 2);
            int maxPos = pos * 2;

            if((pos * 2) + 1 < heap.size() && max < heap.get((pos * 2) + 1)) {
                max = heap.get((pos * 2) + 1);
                maxPos = (pos * 2) + 1;
            }

            if(heap.get(pos) > max) break;

            swap(pos, maxPos);

            pos = maxPos;
        }
        return deletedValue;
    }

    void swap(int indexA, int indexB) {
        int temp = heap.get(indexA);
        heap.set(indexA, heap.get(indexB));
        heap.set(indexB, temp);
    }
}
