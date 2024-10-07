package fr.istic.vv;

import java.util.*;

class BinaryHeap<T> {

    private List<T> heap;
    private Comparator<T> comparator;

    /**
     * Constructor for the BinaryHeap class
     * 
     * @param comparator Comparator<T> used to define the order in the heap
     */
    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.heap = new ArrayList<>();  // to store the heap elements
    }

    /**
     * Removes and returns the minimum element from the heap (the root element)
     * 
     * Preconditions:
     * - The heap must not be empty; otherwise, a NoSuchElementException is thrown
     * 
     * @return T The minimum element from the heap.
     * @throws NoSuchElementException if the heap is empty.
     */
    public T pop() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }
        
        // Retrieve the minimum element, which is always at the root
        T min = heap.get(0);
        
        // Replace the root with the last element in the heap and remove the last element
        heap.set(0, heap.remove(heap.size() - 1));

        int index = 0;
        int leftChildIndex = 1;
        
        // Repeatedly compare the current element with its children and swap with the smallest child
        // until the heap property is restored (i.e., the current element is smaller than its children)
        while (leftChildIndex < heap.size()) {
            int rightChildIndex = leftChildIndex + 1;  
            int smallestChildIndex = leftChildIndex;   

            // If the right child exists and is smaller than the left child, update smallestChildIndex
            if (rightChildIndex < heap.size() && comparator.compare(heap.get(rightChildIndex), heap.get(leftChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            // If the current element is smaller than or equal to the smallest child, the heap is valid
            if (comparator.compare(heap.get(index), heap.get(smallestChildIndex)) <= 0) {
                break;
            }

            // Otherwise, swap the current element with the smallest child and move down the tree
            Collections.swap(heap, index, smallestChildIndex);
            index = smallestChildIndex;
            leftChildIndex = 2 * index + 1;
        }
                
        return min;
    }

    /**
     * Returns the minimum element (root element) from the heap without removing it
     * 
     * Preconditions:
     * - The heap must not be empty; otherwise, a NoSuchElementException is thrown
     * 
     * @return T The minimum element from the heap
     * @throws NoSuchElementException if the heap is empty
     */
    public T peek() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException();
        }
        return heap.get(0); 
    }

    /**
     * Inserts a new element into the heap and restores the heap property
     * 
     * Preconditions:
     * - The element to be inserted must not be null; otherwise, a NullPointerException is thrown
     * 
     * @param element The element to insert into the heap
     * @throws NullPointerException if the element is null
     */
    public void push(T element) {
        if (element == null) {
            throw new NullPointerException();
        }
        
        heap.add(element);  // Add the element to the end of the heap

        int index = heap.size() - 1;  // Index of the newly added element
        int parentIndex = (index - 1) / 2;  // Parent index of the new element

        // Restore the heap property.
        while (index > 0 && comparator.compare(heap.get(index), heap.get(parentIndex)) < 0) {
            // Swap the element with its parent if it's smaller than the parent
            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
            parentIndex = (index - 1) / 2;
        }
    }

    /**
     * Returns the number of elements currently in the heap
     * 
     * @return int The number of elements in the heap
     */
    public int count() {
        return heap.size();
    }

}
