package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;


class BinaryHeap<T> {

	private Comparator<T> comparateur;
	private ArrayList<T> tas;
	
    public BinaryHeap(Comparator<T> comparator) 
    {  
    	comparateur = comparator;
    	tas = new ArrayList<T>();
    }

    public T pop() throws NotSuchElementException
    { 

    	if ( count() <= 0)throw new NotSuchElementException();
		T result = tas.get(0);
		tas.remove(0);
		return result;

    }

    public T peek() throws NotSuchElementException
    {

		if ( count() == 0)throw new NotSuchElementException();
		return tas.get(0);

    }

    public void push(T element) 
    {
    	for ( int i = 0; i < count(); i++)
    	{
    		if( comparateur.compare(element, tas.get(i)) <= 0)
    		{
    			tas.add(i, element);
    			return;
    		}
    	}
    	tas.add(element);
    }

    public int count() 
    {
    	return tas.size(); 
    }

}