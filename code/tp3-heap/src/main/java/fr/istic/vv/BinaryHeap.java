package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * 
 * BinaryHeap using a binary tree where the minimum element is always the root
 *
 * @param <T>
 */
class BinaryHeap<T> {

	private LinkedList<T> binaryTree;
	private Comparator<T> compare;

	/**
	 * Constructor of a binary heap
	 * @param comparator : Comparator used to know where to insert
	 */
	public BinaryHeap(Comparator<T> comparator) {
		binaryTree = new LinkedList<T>();
		compare = comparator;
	}

	/**
	 * Return and remove the minimum element
	 * 
	 * @return the minimum element of type T
	 * @throws NoSuchElementException : The BinaryHeap is empty
	 */
	public T pop() throws NoSuchElementException {
		if (binaryTree.isEmpty()) {
			throw new NoSuchElementException("The BinaryHeap is empty");
		}
		return binaryTree.removeFirst();
	}

	/**
	 * Return the minimum element of the binary heap
	 * 
	 * @return the minimum T object
	 * @throws NotSuchElementException 
	 */
	public T peek() throws NoSuchElementException {
		if (binaryTree.isEmpty()) {
			throw new NoSuchElementException("The BinaryHeap is empty");
		}
		return binaryTree.getFirst();
	}

	/**
	 * Add the element at the right place in the binary tree
	 * @assert the binary tree is sorted
	 * @param element
	 */
	public void push(T element) {
		
		if (binaryTree.isEmpty()) {
			binaryTree.add(element);
		} else {
			ListIterator<T> it = binaryTree.listIterator();
			while (it.hasNext()) {
				T current = it.next();
				// if the element is inferior or equal
				if (compare.compare(element, current) < 0) {
					it.previous();
					it.add(element);
					return;
				}
			}
			// if the element is superior than all the others it added at the end
			binaryTree.addLast(element);
		}
		
	}

	/**
	 * Returns the number of elements in the binary tree.
	 * 
	 * @return
	 */
	public int count() {
		return binaryTree.size();
	}

}