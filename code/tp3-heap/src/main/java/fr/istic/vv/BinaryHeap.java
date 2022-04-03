package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

class BinaryHeap<T> {
	private Stack<T> file;
	private Comparator<T> comparatorBH;
	
    public BinaryHeap(Comparator<T> comparator) { comparatorBH = comparator; file = new Stack<>();}

    public T pop() throws NotSuchElementException {
    	if(count() == 0)
    		throw new NotSuchElementException();
    	return file.pop(); 
    }

    public T peek() throws NotSuchElementException { 
    	if(count() == 0)
    		throw new NotSuchElementException();
    	return file.peek(); 
    }

    public void push(T element) { int max = file.size()-1, min = 0; 

		if(count() == 0) {
			file.insertElementAt(element, min);
			return;
		}
		int mid = max/2;
    	while(max > min) { 
    		if( comparatorBH.compare(element, file.get(mid)) <= -1) {
    			min  = mid+1;
    		}else if(comparatorBH.compare(element, file.get(mid)) >= 1) {
    			max = mid-1;
    		}else {
    			file.insertElementAt(element, mid);
    			return;
    		}
    		mid = (max + min) / 2;
    	} 
    	if(comparatorBH.compare(element, file.get(min)) >= 1)
    		file.insertElementAt(element, min);
    	else {
    		file.insertElementAt(element, min+1);
    	}
    	
    }

    public int count() { return file.size(); }

}