package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;

class BinaryHeap<T> extends Object{
    private T[] binaryHeap;
	private int count;
    private Comparator<T> comparator;
    @SuppressWarnings("unchecked")
	public BinaryHeap (Comparator<T> comparator)
    { 
    	this.count=0;
    	this.comparator=comparator;
    	binaryHeap=(T[]) new Object[1000];
    }

    public T pop() 
    {
		T element;
		element=binaryHeap[0];
		T dernierElement;
		dernierElement=binaryHeap[count-1];
		binaryHeap[0]=binaryHeap[count-1];
		int nouvelIndice=0;
		if(comparator.compare(binaryHeap[1], binaryHeap[0])<0) {
			binaryHeap[0]=binaryHeap[1];
			binaryHeap[1]=binaryHeap[count-1];
			nouvelIndice=1;
		}
		else if(comparator.compare(binaryHeap[2], binaryHeap[0])<0) {
			binaryHeap[0]=binaryHeap[2];
			binaryHeap[1]=binaryHeap[count-1];
			nouvelIndice=2;
		}
		while(nouvelIndice<count-1) {
			if(comparator.compare(binaryHeap[(2*nouvelIndice)+1], binaryHeap[nouvelIndice])<0) {
				binaryHeap[nouvelIndice]=binaryHeap[(2*nouvelIndice)+1];
				binaryHeap[(2*nouvelIndice)+1]=dernierElement;
				nouvelIndice=(2*nouvelIndice)+1;
			}
			else if(comparator.compare(binaryHeap[(2*nouvelIndice)+2], binaryHeap[nouvelIndice])<0) {
				binaryHeap[nouvelIndice]=binaryHeap[(2*nouvelIndice)+2];
				binaryHeap[(2*nouvelIndice)+2]=dernierElement;
				nouvelIndice=(2*nouvelIndice)+1;
			}
		}
		
		count--;
    	return element;
    }

    public T peek() 
    { 
    	return binaryHeap[0];
    }

    public void push(T element) 
    	{ 
    		binaryHeap[count]=element;
    		int i=count;
    		while(i>0) 
    		{
    			if(comparator.compare(binaryHeap[i],binaryHeap[((i-1)/2)])<0) 
    			{
    				binaryHeap[i]=binaryHeap[((i-1)/2)];
    				binaryHeap[((i-1)/2)]=element;
    			}
    			i=(i-1)/2;
    			
    		}
    		count++;
    	}

    public int count() 
    {
    	return count;
    }

}