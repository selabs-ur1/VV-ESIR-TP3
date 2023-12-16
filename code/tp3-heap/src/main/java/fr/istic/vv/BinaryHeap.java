package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

    private final ArrayList<T> heap;
    private final Comparator<T> comparator;

    public BinaryHeap(Comparator<T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public T pop() {
        if (this.heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        T minElement = this.heap.get(0);
        int lastIdx = this.count() - 1;
        T lastElement = this.heap.remove(lastIdx);

        if (lastIdx > 0) {
            heap.set(0, lastElement);

            int leftChildIdx;
            int rightChildIdx;
            int smallestChildIdx;
            int i = 0;
            int n = this.count();
            while (true) {
                leftChildIdx = 2 * i;
                rightChildIdx = 2 * i + 1;
                smallestChildIdx = i;

                if (leftChildIdx < n &&
                        comparator.compare(this.heap.get(leftChildIdx), this.heap.get(smallestChildIdx)) < 0) {
                    smallestChildIdx = leftChildIdx;
                }

                if (rightChildIdx < n &&
                        comparator.compare(this.heap.get(rightChildIdx), this.heap.get(smallestChildIdx)) < 0) {
                    smallestChildIdx = rightChildIdx;
                }

                if (smallestChildIdx != i) {
                    T temp = this.heap.get(i);
                    this.heap.set(i, heap.get(smallestChildIdx));
                    this.heap.set(smallestChildIdx, temp);
                    i = smallestChildIdx;
                } else {
                    break;
                }
            }
        }
        return minElement;
    }

    public T peek() {
        if (this.heap.isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return this.heap.get(0);
    }

    public void push(T element) {
        this.heap.add(element);
        int i = this.count() - 1;
        while (i > 0) {
            int parentIndex = (i - 1) / 2;
            if (comparator.compare(this.heap.get(i), this.heap.get(parentIndex)) < 0) {
                T temp = this.heap.get(i);
                this.heap.set(i, this.heap.get(parentIndex));
                this.heap.set(parentIndex, temp);
                i = parentIndex;
            } else {
                break;
            }
        }
    }

    public int count() {
        return this.heap.size();
    }

}