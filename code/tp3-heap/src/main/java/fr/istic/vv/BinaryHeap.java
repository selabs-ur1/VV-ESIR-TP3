package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

    private final Comparator<T> comparator;
    private final ArrayList<T> heap;

    public BinaryHeap(Comparator<T> comparator) {
        if (comparator == null) {
            throw new IllegalArgumentException("Comparator cannot be null");
        }
        this.comparator = comparator;
        this.heap = new ArrayList<>();
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        T minElement = heap.get(0);
        T lastElement = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }

        return minElement;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return heap.get(0);
    }

    public void push(T element) {
        if (element == null) {
            throw new NullPointerException("Element cannot be null");
        }
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }

    public int count() {
        return heap.size();
    }

    private boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (comparator.compare(heap.get(index), heap.get(parentIndex)) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int smallest = index;

        if (leftChild < heap.size() && comparator.compare(heap.get(leftChild), heap.get(smallest)) < 0) {
            smallest = leftChild;
        }

        if (rightChild < heap.size() && comparator.compare(heap.get(rightChild), heap.get(smallest)) < 0) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
