package fr.istic.vv;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    @Test
    void testPop() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());

        // Block: Empty heap
        assertThrows(NoSuchElementException.class, heap::pop);

        // Block: Heap with elements
        heap.push(5);
        heap.push(10);
        heap.push(15);

        assertEquals(3, heap.count());  // Additional test case

        int minElement = heap.pop();
        assertEquals(2, heap.count());  // Additional test case
        assertEquals(5, minElement);

        // Block: Verify heap property after pop
        assertEquals(10, heap.pop());
        assertEquals(1, heap.count());  // Additional test case
    }

    @Test
    void testPeek() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());

        // Block: Empty heap
        assertThrows(NoSuchElementException.class, heap::peek);

        // Block: Heap with elements
        heap.push(5);
        heap.push(10);
        heap.push(15);

        assertEquals(3, heap.count());  // Additional test case

        int minElement = heap.peek();
        assertEquals(3, heap.count());  // Additional test case
        assertEquals(5, minElement);

        // Block: Verify heap property after peek
        assertEquals(3, heap.count());  // Additional test case
    }

    @Test
    void testPush() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());

        // Block: Null element
        assertThrows(NullPointerException.class, () -> heap.push(null));

        // Block: First element in the heap
        heap.push(5);
        assertEquals(1, heap.count());  // Additional test case

        // Block: Not the first element in the heap
        heap.push(3);
        assertEquals(2, heap.count());  // Additional test case

        heap.push(7);
        assertEquals(3, heap.count());  // Additional test case

        assertEquals(3, heap.pop());  // Additional test case
    }

    @Test
    void testCount() {
        BinaryHeap<Integer> heap = new BinaryHeap<Integer>(Comparator.naturalOrder());

        // Block: Empty heap
        assertEquals(0, heap.count());

        // Block: Heap with elements
        heap.push(5);
        heap.push(10);
        heap.push(15);

        assertEquals(3, heap.count());
        heap.pop();
        assertEquals(2, heap.count());
        heap.pop();
        assertEquals(1, heap.count());
        heap.pop();
        assertEquals(0, heap.count());
    }
}
