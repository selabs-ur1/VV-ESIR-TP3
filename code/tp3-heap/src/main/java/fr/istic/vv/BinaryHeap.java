package fr.istic.vv;

import java.util.Comparator;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

	private Comparator<T> cmp;
	private T value;
	private BinaryHeap<T> leftSon;
	private BinaryHeap<T> rightSon;
	
    public BinaryHeap(Comparator<T> comparator) {
    	cmp = comparator;
    }
    
    private BinaryHeap(Comparator<T> comparator, T value) {
    	cmp = comparator;
    	this.value = value;
    }

    private  boolean hasLeftSon() {
    	if(leftSon==null) return false;
    	try {
    		leftSon.peek();
    	}
    	catch(Exception e) {
    		return false;
    	}
    	return true;
    }

    private  boolean hasRightSon() {
    	if(rightSon==null) return false;
    	try {
    		rightSon.peek();
    	}
    	catch(Exception e) {
    		return false;
    	}
    	return true;
    }
    
    public T pop() throws NoSuchElementException {
    	if(value == null) {
    		throw new NoSuchElementException();
    	}    	
    	T res = value;
    	
    	if(hasLeftSon() && !hasRightSon()){
    		value = leftSon.pop();
    	}
    	
    	else if(!hasLeftSon() && hasRightSon()){
    		value = rightSon.pop();
    	}
    	
    	else if(hasLeftSon() && hasRightSon()) {
        	if(cmp.compare(leftSon.peek(), rightSon.peek()) < 0) {
        		value = leftSon.pop();
        	}
        	else value = rightSon.pop();
    	}
    	
    	else {
    		value = null;
    	}
    	
    	return res;
    }

    public T peek() {
    	if (value==null) {
    		throw new NoSuchElementException();
    	}
    	return value;
    }

    public void push(T element) {
    	if(value==null) {
    		value=element;
    	}
    	else {
    		T toPush;
    		if (cmp.compare(element, value)<0) {	//element<value ; element prend la place de value et on push value dans l'un des fils.
        		toPush = value;
        		value = element;
    		}
    		else { //element>=value
    			toPush = element;
    		}
    		
    		if (!hasLeftSon()) {
    			leftSon = new BinaryHeap<T>(cmp,toPush);
    		}
    		else if(!hasRightSon()) {
    			rightSon = new BinaryHeap<T>(cmp,toPush);
    		}
    		else {
    			leftSon.push(toPush);
    		}
    		//On inverse les fils pour équilibrer le tas (cela conserve bien l'hypothèse selon laquelle la valeur des deux fils est inférieure à celle du parent)
    		BinaryHeap<T> tmp = leftSon;
    		leftSon = rightSon;
    		rightSon = tmp;
    		
    	}
    }

    public int count() { //Le nombre de valeurs du tas est le nombre de valeurs du fils gauche plus celui du fils droit plus 1.
    	if(value==null) return 0;
    	int res = 1;
    	if(hasLeftSon()) res += leftSon.count();
    	if(hasRightSon()) res += rightSon.count();
    	return res;
    }

}