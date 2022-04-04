package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeapTest {

    private Comparator<String> compString = Comparator.comparing(String::toString);
    private String[] dataset = {"b","a","d","c","f","f","g","i","h","j","k","k","l","m"}; // Dataset where we will use a foreach to add elements in our object

    // We can't use Setup because we will change the comparator's object sometimes
    // Push tests
    @Test
    public void PushOneElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        heap.push(dataset[0]);
        assertTrue(heap.count()== 1);
    }

    @Test
    public void PushSeveralElements() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(String letter: dataset) {
            heap.push(letter);
        }
        assertTrue(heap.count() == dataset.length);
    }

    // Pop and Peek test
    @Test
    public void PopVoidElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            String element = heap.pop();
        });
        
    }

    @Test
    public void PeekVoidElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            String element = heap.peek();
        });
    }

    @Test
    public void PopOneElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        heap.push(dataset[0]);
        String element = heap.pop();
        assertTrue(element.compareTo(dataset[0]) == 0);
    }

    @Test
    public void PeekOneElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        heap.push(dataset[0]);
        String element = heap.peek();
        assertTrue(element.compareTo(dataset[0]) == 0);
    }

    // Pop the first elements after several push, the aim is to know if the sort works correctly.
    @Test
    public void PopElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(int i =0; i < 5; i++) {
            heap.push(dataset[i]);
        }
        String element = heap.pop();
        assertTrue(element.compareTo("a") == 0);
    }

    @Test
    public void PeekElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(int i =0; i < 5; i++) {
            heap.push(dataset[i]);
        }
        String element = heap.peek();
        assertTrue(element.compareTo("a") == 0);
    }

    @Test
    public void PopPushPopElement() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(int i =0; i < 5; i++) {
            heap.push(dataset[i]);
        }
        String element = heap.pop();
        heap.push(dataset[0]);
        element = heap.pop();
        assertTrue(element.compareTo("b") == 0);
    }

    // Test on the function count()
    @Test
    public void VoidCount() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        assertTrue(heap.count() == 0);
    }

    @Test
    public void PushPeekCount() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(String letter: dataset) {
            heap.push(letter);
        }
        heap.peek();
        assertTrue(heap.count() == dataset.length);
    }

    @Test
    public void PushPopCount() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(String letter: dataset) {
            heap.push(letter);
        }
        heap.pop();
        assertTrue(heap.count() == dataset.length-1);
    }

    @Test
    public void PushPeekPopCount() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(String letter: dataset) {
            heap.push(letter);
        }
        heap.peek();
        heap.pop();
        heap.pop();
        heap.peek();
        heap.pop();
        heap.pop();
        assertTrue(heap.count() == dataset.length-4);
    }

    @Test
    public void PushPeekPopPushCount() {
        BinaryHeap<String> heap = new BinaryHeap<String>(compString);
        for(String letter: dataset) {
            heap.push(letter);
        }
        heap.peek();
        heap.push(dataset[0]);
        heap.pop();
        heap.push(dataset[0]);
        heap.pop();
        heap.peek();
        heap.pop();
        heap.pop();
        assertTrue(heap.count() == dataset.length-2);
    }
    

}