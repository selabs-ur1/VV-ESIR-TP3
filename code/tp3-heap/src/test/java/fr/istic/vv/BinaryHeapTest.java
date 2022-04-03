package fr.istic.vv;

//import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class BinaryHeapTest {

	private BinaryHeap<Integer> heap;
	
	@BeforeEach
	public void init()
	{
		heap = new BinaryHeap<Integer>(new IntComparator());
	}

	@Test
	public void testCountVide()
	{
		heap.count();
		assertEquals(heap.count(), 0 );
	}
	
	@Test
	public void testCountNonVide()
	{
		heap.push(3);
		heap.push(4);
		assertEquals(heap.count(), 2 );
	}
	
	@Test
	public void testPushOne() throws NotSuchElementException
	{
		heap.push(1);
		assertEquals((int)heap.peek(), 1);
	}
	
	@Test
	public void testPushThree() throws NotSuchElementException
	{
		heap.push(1);
		heap.push(2);
		heap.push(3);
		assertEquals((int) heap.peek(), 1);
	}
	
	@Test
	public void testPushThreeNotSorted() throws NotSuchElementException
	{
		heap.push(3);
		heap.push(2);
		heap.push(4);
		assertEquals((int) heap.peek(), 2);
	}
	

	@Test
	public void testPushTNegativeValue() throws NotSuchElementException
	{
		heap.push(3);
		heap.push(8);
		heap.push(-4);
		assertEquals((int) heap.peek(), -4);
	}
	
	@Test
	public void testPushTwoSameValue() throws NotSuchElementException
	{
		heap.push(3);
		heap.push(2);
		heap.push(2);
		heap.push(3);
		assertEquals((int) heap.peek(), 2);
	}
	
	@Test
	public void testPushBigDifference() throws NotSuchElementException
	{
		heap.push(3000);
		heap.push(2);
		heap.push(2);
		heap.push(3);
		assertEquals((int) heap.peek(), 2);
	}
	
	
	@Test
	public void testPushThreeReversedOrder() throws NotSuchElementException
	{
		heap.push(8);
		heap.push(7);
		heap.push(6);
		heap.push(5);
		heap.push(4);
		assertEquals((int) heap.peek(), 4);
	}
	
	@Test
	public void testPeekInEmptyHeap() throws NotSuchElementException
	{
		try {
            heap.peek();
            fail("Exception not thrown");
        } catch (NotSuchElementException e) {
            assertEquals("NotSuchElementException", e.getMessage());
        }
	}
	
	@Test
	public void testPopThree() throws NotSuchElementException
	{
		heap.push(1);
		heap.push(2);
		heap.push(3);
		assertEquals((int) heap.pop(), 1);
	}
	
	@Test
	public void testPopThreeSize() throws NotSuchElementException
	{
		heap.push(1);
		heap.push(2);
		heap.push(3);
		heap.pop();
		assertEquals(2, heap.count());
	}
	
	@Test
	public void testPopInEmptyHeap() throws NotSuchElementException
	{
		try {
            heap.pop();
            fail("Exception not thrown");
        } catch (NotSuchElementException e) {
            assertEquals("NotSuchElementException", e.getMessage());
        }
	}

	
}