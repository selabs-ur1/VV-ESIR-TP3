package fr.istic.vv;

/*import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.Before;*/

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
public class BinaryHeapTest {
	private BinaryHeap<Integer> val;
	
	@BeforeEach
	public void initialize() {
		val = new BinaryHeap<Integer>(new IntComparator());
	}
	
	@Test
	public void empty() {
		assertEquals(0,val.count());
	}

	@Test
	public void push() {
		val.push(3);
		assertEquals(1,val.count());
	}
	
	@Test
	public void peek() throws NotSuchElementException {
		val.push(3);
		Integer t = 3;
		assertEquals(t ,val.peek());
	}
	
	@Test
	public void pop() throws NotSuchElementException {
		val.push(3);
		Integer t = 3;
		assertEquals(t,val.pop());
		assertEquals(0,val.count());
	}
	
	@Test
	//raise Exception pop empty
	public void popEmpty() {
		try {
	        val.pop();
	        fail("Exception not thrown");
	    } catch (NotSuchElementException e) {
	        assertEquals("Error, this action wasn't possible", e.getMessage());
	    }
	}
	
	@Test
	//raise Exception peek empty
	public void peekEmpty() {
		try {
	        val.peek();
	        fail("Exception not thrown");
	    } catch (NotSuchElementException e) {
	        assertEquals("Error, this action wasn't possible", e.getMessage());
	    }		
	}
	
	@Test
	//push five elements
	public void PushFive() {
		val.push(3);
		val.push(2);
		val.push(4);
		val.push(5);
		val.push(1);
		assertEquals(5,val.count());
	}
	@Test
	//push five elements and peek
	public void PeekFive() throws NotSuchElementException {
		val.push(3);
		val.push(2);
		val.push(4);
		val.push(5);
		val.push(1);
		Integer t = 1;
		assertEquals(t,val.peek());
	}
	
	@Test
	//push and pop five elements
	public void popFive() throws NotSuchElementException {
		val.push(3);
		val.push(2);
		val.push(4);
		val.push(5);
		val.push(1);
		Integer t = 1;
		assertEquals(t,val.pop());
		assertEquals(++t,val.pop());
		assertEquals(++t,val.pop());
		assertEquals(++t,val.pop());
		assertEquals(++t,val.pop());
	}
	
	@Test
	//push values and once twice the same and pop
	public void Eq2vals() throws NotSuchElementException {
		val.push(3);
		val.push(3);
		val.push(4);
		val.push(5);
		val.push(1);
		Integer t = 1;
		assertEquals(t,val.pop());
		t=3;
		assertEquals(t,val.pop());
		assertEquals(t,val.pop());
		assertEquals(++t,val.pop());
		assertEquals(++t,val.pop());
	}
	
	@Test
	//push only the same value and pop
	public void EqOnly() throws NotSuchElementException {
		val.push(3);
		val.push(3);
		val.push(3);
		val.push(3);
		val.push(3);
		Integer t = 3;
		assertEquals(t,val.pop());
		assertEquals(t,val.pop());
		assertEquals(t,val.pop());
		assertEquals(t,val.pop());
		assertEquals(t,val.pop());
	}
	
	@Test
	//Push and pop 20 elements
	public void pop20() throws NotSuchElementException {
	val.push(1);
	val.push(5);
	val.push(4);
	val.push(2);
	val.push(3);
	val.push(1);
	val.push(5);
	val.push(4);
	val.push(2);
	val.push(3);	
	val.push(1);
	val.push(5);
	val.push(4);
	val.push(2);
	val.push(3);	
	val.push(1);
	val.push(5);
	val.push(4);
	val.push(2);
	val.push(3);
	Integer t = 1;
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(++t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(++t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(++t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(++t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
	assertEquals(t,val.pop());
}
	
	
	
	
}