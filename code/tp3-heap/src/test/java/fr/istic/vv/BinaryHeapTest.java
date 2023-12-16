package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

class BinaryHeapTest {

    @Test
    void testConstructor() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        assertNotNull(minHeap);
    }

    @Test
    void testPopEmptyHeap() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        assertThrows(NoSuchElementException.class, minHeap::pop);
    }

    @Test
    void testPopNonEmptyHeapRight() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        minHeap.push(3);
        minHeap.push(1);
        minHeap.push(4);
        assertEquals(1, minHeap.pop());
        assertEquals(3, minHeap.pop());
        assertEquals(4, minHeap.pop());
    }

    @Test
    void testPopNonEmptyHeapLeft() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        minHeap.push(5);
        minHeap.push(9);
        minHeap.push(3);
        minHeap.push(1);
        minHeap.push(7);
        assertEquals(1, minHeap.pop());
        assertEquals(3, minHeap.pop());
        assertEquals(5, minHeap.pop());
        assertEquals(7, minHeap.pop());
        assertEquals(9, minHeap.pop());
    }

    @Test
    void testPeekEmptyHeap() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        assertThrows(NoSuchElementException.class, minHeap::peek);
    }

    @Test
    void testPeekNonEmptyHeap() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        minHeap.push(3);
        minHeap.push(1);
        minHeap.push(4);
        assertEquals(1, minHeap.peek());
        assertEquals(1, minHeap.peek());
    }

    @Test
    void testPushEmptyHeap() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        minHeap.push(3);
        assertEquals(1, minHeap.count());
    }

    @Test
    void testPushNonEmptyHeap() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        minHeap.push(3);
        minHeap.push(1);
        minHeap.push(4);
        assertEquals(3, minHeap.count());
    }

    @Test
    void testPushNonEmptyHeapDouble() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        minHeap.push(3);
        minHeap.push(3);
        minHeap.push(3);
        assertEquals(3, minHeap.count());
    }

    @Test
    void testCountEmptyHeap() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        assertEquals(0, minHeap.count());
    }

    @Test
    void testCountMethod() {
        BinaryHeap<Integer> minHeap = new BinaryHeap<>(Integer::compareTo);
        minHeap.push(3);
        minHeap.push(1);
        minHeap.push(4);
        assertEquals(3, minHeap.count());
    }
}