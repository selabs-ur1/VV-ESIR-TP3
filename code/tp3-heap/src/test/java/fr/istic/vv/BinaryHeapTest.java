package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;

import org.junit.jupiter.api.BeforeEach;

class BinaryHeapTest extends Object {
	
	private BinaryHeap<Integer> binaryHeap;

	@BeforeEach
	protected void setUp() throws Exception {
		Comparator<Integer> comparator = null;
		binaryHeap = new BinaryHeap<Integer>(comparator);
		}
	@Test
	public void testAjout() {
		for(int i=1;i<=20;i++) {
			binaryHeap.push(i);
		}
		assertTrue(binaryHeap.peek()==1);
	}
	@Test
	public void Testsuppression() {
		for(int i=1;i<=10;i++) {
			binaryHeap.pop();
		}
		assertTrue(binaryHeap.peek()==11);
	}
	@Test
	public void TestSuppressionTotale() {
		for(int i=1;i<=10;i++) {
			binaryHeap.pop();
		}
		assertTrue(binaryHeap.count()==0);
	}
}