package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class BinaryHeapTest {

    BinaryHeap<Integer> heap;

    @BeforeEach
    void setUp() {
        // Initialize the heap with a comparator for integers
        heap = new BinaryHeap<Integer>(Comparator.naturalOrder());
    }

    /* Push tests */

    @DisplayName("Block 1: Push a non-null element")
    @Test
    void pushNonNullElement() {
        heap.push(5);
        assertEquals(1, heap.count()); 
        assertEquals(5, heap.peek());  
    }

    @DisplayName("Block 2: Push a null element (should throw NullPointerException)")
    @Test
    void pushNullElement() {
        assertThrows(NullPointerException.class, () -> heap.push(null));
    }

    /* Pop tests */

    @DisplayName("Block 1: Pop from a non-empty heap")
    @Test
    void popNonEmptyHeap() {
        heap.push(10);
        heap.push(5);
        heap.push(7);
        assertEquals(3, heap.count());  

        int min = heap.pop();  
        assertEquals(5, min);  
        assertEquals(2, heap.count()); 
    }

    @DisplayName("Block X: Pop from a non-empty heap with all the same")
    @Test
    void popNonEmptyHeap2() {
        heap.push(7);
        heap.push(7);
        heap.push(7);
        heap.push(7);
        heap.push(7);
        heap.push(7);
        assertEquals(6, heap.count());

        int min = heap.pop();
        assertEquals(7, min);
        assertEquals(5, heap.count());
    }

    @DisplayName("Block 2: Pop from an empty heap (should throw NoSuchElementException)")
    @Test
    void popEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> heap.pop());
    }

    /* Peek tests */

    @DisplayName("Block 1: Peek from a non-empty heap")
    @Test
    void peekNonEmptyHeap() {
        heap.push(10);
        heap.push(3);
        heap.push(7);
        assertEquals(3, heap.peek()); 
    }

    @DisplayName("Block 2: Peek from an empty heap (should throw NoSuchElementException)")
    @Test
    void peekEmptyHeap() {
        assertThrows(NoSuchElementException.class, () -> heap.peek());
    }

    /* Count tests */

    @DisplayName("Block 1: Count after pushing elements")
    @Test
    void countAfterPushing() {
        heap.push(10);
        heap.push(5);
        heap.push(3);
        assertEquals(3, heap.count()); 
    }

    @DisplayName("Block 2: Count after popping elements")
    @Test
    void countAfterPopping() {
        heap.push(10);
        heap.push(5);
        heap.pop(); 
        assertEquals(1, heap.count()); 
    }

    @DisplayName("Block 3: Count for an empty heap")
    @Test
    void countEmptyHeap() {
        assertEquals(0, heap.count()); 
    }
}
