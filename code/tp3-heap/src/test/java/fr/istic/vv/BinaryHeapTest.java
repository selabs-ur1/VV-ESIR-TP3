package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

class BinaryHeapTest {

	BinaryHeap<Integer> tree;
	ComparatorSuperior comp;

	@BeforeEach
	public void setUp() {
		comp = new ComparatorSuperior();
		tree = new BinaryHeap<Integer>(comp);
	}
	
	/*********************************************
	 ** Tests **
	 *********************************************/

	/////////////////////
	// Push //
	/////////////////////
	@Test
	public void pushInEmptyTest() {
		tree.push(12);

		assertEquals(1, tree.count());
	}

	@Test
	public void pushTwoInOrderTest() {
		tree.push(12);
		tree.push(134);

		assertEquals(2, tree.count());
	}

	@Test
	public void pushTwoSameTest() {
		tree.push(12);
		tree.push(12);

		assertEquals(2, tree.count());
	}

	@Test
	public void pushThreeWithTwoSameTest() {
		tree.push(12);
		tree.push(212);
		tree.push(12);

		assertEquals(3, tree.count());
	}

	@Test
	public void pushFourInOrderTest() {
		tree.push(1);
		tree.push(12);
		tree.push(123);
		tree.push(1234);

		assertEquals(4, tree.count());
	}

	@Test
	public void pushTwoInDisorderTest() {
		tree.push(134);
		tree.push(12);

		assertEquals(2, tree.count());
	}

	@Test
	public void pushFourInDisorderTest() {
		tree.push(1234);
		tree.push(123);
		tree.push(12);
		tree.push(1);

		assertEquals(4, tree.count());
	}

	/////////////////////
	// Push //
	/////////////////////

	@Test
	public void peekTest(){
		tree.push(1422);
		tree.push(1);

		assertEquals(1, tree.peek());
	}

	@Test
	public void peekEmpty() {

		assertThrows(NoSuchElementException.class, () ->{
			tree.peek();
		});
	}

	/////////////////////
	// 		Pop 	   //
	/////////////////////

	@Test
	public void popEmpty(){
		assertThrows(NoSuchElementException.class, () ->{
			tree.pop();
		});
	}

	@Test
	public void popTest() {
		tree.push(1);
		tree.pop();

		assertEquals(0, tree.count());
	}

	@Test
	public void popReturnMin() {
		tree.push(1422);
		tree.push(1);

		assertEquals(1, tree.pop());
	}
}