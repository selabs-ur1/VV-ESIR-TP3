package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

	private List<T> heap;// list representing the binarytree
	Comparator<T> comparator;

	public BinaryHeap(Comparator<T> comparator) {
		this.comparator = comparator;
		this.heap = new ArrayList<>();
	}

	public T pop() {
		if(heap.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		int currentIndex = 0;
		T min = heap.get(0);
		
		//we replace the root by the last element
		heap.set(0, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		// fixing the heap
		while (true) {
			int indexChildLeft = 2 * (currentIndex + 1)-1;
			int indexChildRight = 2 * (currentIndex + 1);
			T minChild = null;
			int indexMinChild = 0;

			//start by retrieving the smaller child if the node has childs
			if (indexChildRight<heap.size() && comparator.compare(heap.get(indexChildRight), heap.get(indexChildLeft)) <= 0) {
				minChild = heap.get(indexChildRight);
				indexMinChild = indexChildRight;
			} else if(indexChildLeft<heap.size()){
				minChild = heap.get(indexChildLeft);
				indexMinChild = indexChildLeft;
			}

			//if the node has a child and its smaller than itself then we echange both nodes and repeat the loop
			//else we break the loop
			if (minChild!=null && comparator.compare(heap.get(currentIndex), minChild) > 0) {
				T tmp = heap.get(currentIndex);
				heap.set(currentIndex, minChild);
				heap.set(indexMinChild, tmp);
				currentIndex = indexMinChild;
			}else {
				break;
			}
			
			
		}

		return min;
	}

	public T peek() {
		if(heap.isEmpty()) {
			throw new NoSuchElementException();
		}
		return heap.get(0);
	}

	public void push(T element) {
		int CurrentIndex = heap.size();
		heap.add(element);
		while (true) {
			int indexParent = (int) Math.floor((CurrentIndex - 1) / 2);
			if (comparator.compare(element, heap.get(indexParent)) < 0) {
				T tmp = heap.get(indexParent);
				heap.set(indexParent, element);
				heap.set(CurrentIndex, tmp);
				CurrentIndex = indexParent;
			} else {
				break;
			}
		}

	}

	public int count() {
		return heap.size();
	}

	/*public void printTree() {

		System.out.println(this.heap);

		for (int j = 0; j > -1; j++) {
			for (int i = 0; i < Math.pow(2, j); i++) {
				try {
					System.out.print(heap.get((int) Math.pow(2, j) + i - 1) + "|");
				} catch (Exception e) {
					return;
				}
			}
			System.out.println();
		}

	}*/

	
	public List<T> getHeap() {
		return heap;
	}
	public void setHeap(List<T> heap) {
		this.heap = heap;
	}


	
	
	
}