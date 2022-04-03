package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeap<T> {
    Comparator<T> comparator;
    private T[] heap;
    private ArrayList<T> heap2;
    private int counter;
    private int maxCounter;
    
    public BinaryHeap(Comparator<T> comparator) {    	
        counter = 0;
        maxCounter = 20;
        this.comparator = comparator;
        heap = (T[]) new Comparable[maxCounter];
        heap2 = (ArrayList<T>) new ArrayList<Comparable<T>>();
    }
    
    private int RightChild(int i) {
    	return 2*i +2; 
    }
    
    private int LeftChild(int i) {
    	return 2*i +1; 
    }
    
    private int parent(int i) {
    	return (i-1)/2;
    }
    
    private void change(int e1, int e2) {        
        T tmp = heap2.get(e2);
        heap2.set(e2, heap2.get(e1));
        heap2.set(e1, tmp);
    }
    
    public T pop() throws Exception {
    	if(count() <= 0) {
    		throw new NoSuchElementException("Heap is empty");
    	}
    	
    	if(counter == 1) {
    		counter = 0;
    		return heap2.get(0);
    	}
    	
    	T min = heap2.get(0);
    	heap2.set(0, heap2.get(--counter));
    	reOrganise(0);

    	return min;
    }
    
    private void reOrganise(int i) {
    	int left = LeftChild(i);
    	int right = RightChild(i);
    	int min = i;
    	
    	if(left < counter && comparator.compare(heap2.get(left), heap2.get(i)) < 0) {
    		min = left;
    	}
    	
    	if(right < counter && comparator.compare(heap2.get(right), heap2.get(min)) < 0) {
    		min = right;
    	}
    	
    	if(min != i) {
    		change(min, i);
    		reOrganise(min);
    	}
	}

	public T peek() {
		if (counter == 0) throw new NoSuchElementException("Empty heap");
		
		return heap2.get(0);
    }
    
    public void push(T element) {

    	heap2.add(counter, element);
    	
    	int i=counter++;
    	
    	while(i !=0 && comparator.compare(heap2.get(parent(i)), heap2.get(i)) > 0) {
    		change(parent(i), i);
    		i=parent(i);
    	}
    }
    
    public int count() {
    	return counter;
    }
}

class IntComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer a, Integer b) {
        return a.compareTo(b);
    }
}