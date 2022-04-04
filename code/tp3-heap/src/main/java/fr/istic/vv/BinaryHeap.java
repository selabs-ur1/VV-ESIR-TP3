package fr.istic.vv;

import java.util.Comparator;
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.NoSuchElementException;

class BinaryHeap<T> {

    private Comparator<T> comparator;
    private ArrayList<T> table = new ArrayList<T>(); // Create an ArrayList object

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
      }

    public T pop() { 
        if (count() <= 0) {
            throw new NoSuchElementException("Exception message");
        }
        T element_to_send = table.get(0); //Get the first element
        table.remove(0); //Remove the first element
        return element_to_send;
    }

    public T peek() { 
        if (count() <= 0) {
            throw new NoSuchElementException("Exception message");
        }
        T element_to_send = table.get(0); //Get the first element
        return element_to_send;
    }

    public void push(T element) { 
        table.add(element); //Add the element at the end
        sortTable(); //Sort the table to have a correct position
     }

    public int count() { return table.size(); }

    private void sortTable() {
        Collections.sort(table, comparator); //Sort the table in function of the Comparator
    }

}