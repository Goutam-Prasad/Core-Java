package datastructure;

import java.util.ArrayList;
import java.util.List;

class MinHeap {
    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }

    public int getMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");
        return heap.get(0);
    }

    public int extractMin() {
        if (heap.isEmpty()) throw new IllegalStateException("Heap is empty");

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return min;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) < heap.get(parent)) {
                swap(i, parent);
                i = parent;
            } else break;
        }
    }

    private void heapifyDown(int i) {
        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }
}
public class MinHeapImplementation {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap();

        // Insert elements into the heap
        minHeap.insert(10);
        minHeap.insert(4);
        minHeap.insert(15);
        minHeap.insert(20);
        minHeap.insert(0);
        minHeap.insert(8);

        // Display the minimum element
        System.out.println("Minimum element: " + minHeap.getMin());

        // Extract the minimum elements one by one
        while (!minHeap.isEmpty()) {
            System.out.println("Extracted Min: " + minHeap.extractMin());
        }

        // Try calling getMin on an empty heap (will throw an exception)
        // System.out.println(minHeap.getMin()); // Uncomment to test exception
    }
}
