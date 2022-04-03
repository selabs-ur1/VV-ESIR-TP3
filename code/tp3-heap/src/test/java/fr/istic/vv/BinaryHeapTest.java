package fr.istic.vv;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class BinaryHeapTest {

	public BinaryHeap<Integer> myBinHeap;

	public List<Integer> MyTreeInputList;
	public List<Integer> MyTreeTestList;
	
	@BeforeEach
	protected void setUp() throws Exception{
		myBinHeap = new BinaryHeap<Integer>((x, y) -> x.compareTo(y));
		MyTreeInputList= new ArrayList<Integer>();
		MyTreeTestList= new ArrayList<Integer>();
	}
	
	//Testing push
	@Test
	public void testPushEmptyTree() {
		myBinHeap.push(0);
		assertEquals(0, myBinHeap.getHeap().get(0));
	}
	
	@Test
	public void testPush1HeightRootInferior() {
		MyTreeInputList.add(0);
		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(1);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(1);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush1HeightRootEqual() {
		MyTreeInputList.add(0);
		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(0);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(0);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush1HeightRootSuperior() {
		MyTreeInputList.add(0);
		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(-1);
		
		MyTreeTestList.add(-1);
		MyTreeTestList.add(0);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush2HeightRootInferiorLeftInferiorRightInferior() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);
		MyTreeInputList.add(2);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(3);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(1);
		MyTreeTestList.add(2);
		MyTreeTestList.add(3);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	@Test
	public void testPush2HeightRootInferiorLeftSuperiorRightInferior() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(4);
		MyTreeInputList.add(2);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(3);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(3);
		MyTreeTestList.add(2);
		MyTreeTestList.add(4);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush2HeightRootInferiorLeftInferiorRightSuperior() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);
		MyTreeInputList.add(4);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(3);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(1);
		MyTreeTestList.add(4);
		MyTreeTestList.add(3);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	@Test
	public void testPush2HeightRootInferiorLeftSuperiorRightSuperior() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(3);
		MyTreeInputList.add(4);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(2);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(2);
		MyTreeTestList.add(4);
		MyTreeTestList.add(3);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	@Test
	public void testPush2HeightRootInferiorLeftEqualRightEqual() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(3);
		MyTreeInputList.add(3);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(3);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(3);
		MyTreeTestList.add(3);
		MyTreeTestList.add(3);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush2HeightRootEqualLeftSuperiorRightSuperior() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);
		MyTreeInputList.add(2);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(0);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(0);
		MyTreeTestList.add(2);
		MyTreeTestList.add(1);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush2HeightRootSuperiorLeftSuperiorRightSuperior() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);
		MyTreeInputList.add(2);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(-1);
		
		MyTreeTestList.add(-1);
		MyTreeTestList.add(0);
		MyTreeTestList.add(2);
		MyTreeTestList.add(1);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush2HeightRootSuperiorLeftSuperiorRightNull() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(-1);
		
		MyTreeTestList.add(-1);
		MyTreeTestList.add(1);
		MyTreeTestList.add(0);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	@Test
	public void testPush2HeightRootInferiorLeftInferiorRightNull() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);

		myBinHeap.setHeap(MyTreeInputList);
		myBinHeap.push(2);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(1);
		MyTreeTestList.add(2);
		assertEquals(MyTreeTestList, myBinHeap.getHeap());
	}
	
	
	//testing pop
	
	@Test
	public void testPopEmptyHeap() {
		assertThrows(NoSuchElementException.class, ()->myBinHeap.pop());
	}
	
	@Test
	public void testPop1Height0() {
		MyTreeInputList.add(0);
		
		myBinHeap.setHeap(MyTreeInputList);
		
		
		assertEquals(myBinHeap.pop(), 0);
		assertTrue(myBinHeap.getHeap().isEmpty());
	}
	
	@Test
	public void testPop2Height00() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(0);

		myBinHeap.setHeap(MyTreeInputList);
		
		MyTreeTestList.add(0);
		
		assertEquals(myBinHeap.pop(), 0);
		assertEquals(myBinHeap.getHeap(),MyTreeTestList);
	}
	
	@Test
	public void testPop2Height01() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);

		myBinHeap.setHeap(MyTreeInputList);
		
		MyTreeTestList.add(1);
		
		assertEquals(myBinHeap.pop(), 0);
		assertEquals(myBinHeap.getHeap(),MyTreeTestList);
	}
	
	@Test
	public void testPop2Height000() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(0);
		MyTreeInputList.add(0);

		myBinHeap.setHeap(MyTreeInputList);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(0);
		
		assertEquals(myBinHeap.pop(), 0);
		assertEquals(myBinHeap.getHeap(),MyTreeTestList);
	}
	
	@Test
	public void testPop2Height001() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);

		myBinHeap.setHeap(MyTreeInputList);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(1);
		
		assertEquals(myBinHeap.pop(), 0);
		assertEquals(myBinHeap.getHeap(),MyTreeTestList);
	}
	
	@Test
	public void testPop2Height010() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);
		MyTreeInputList.add(0);

		myBinHeap.setHeap(MyTreeInputList);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(1);
		
		assertEquals(myBinHeap.pop(), 0);
		assertEquals(myBinHeap.getHeap(),MyTreeTestList);
	}
	
	@Test
	public void testPop2Height011() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);
		MyTreeInputList.add(1);

		myBinHeap.setHeap(MyTreeInputList);
		
		MyTreeTestList.add(1);
		MyTreeTestList.add(1);
		
		assertEquals(myBinHeap.pop(), 0);
		assertEquals(myBinHeap.getHeap(),MyTreeTestList);
	}
	
	
	//Testing peek()
	@Test
	public void testPeekEmptyHeap() {
		
		assertThrows(NoSuchElementException.class, ()->myBinHeap.peek());

	}
	@Test
	public void testPeek1Element() {
		MyTreeInputList.add(0);
		myBinHeap.setHeap(MyTreeInputList);
		assertEquals(myBinHeap.peek(), 0);
	}
	
	//testing count()
	@Test
	public void testCount0() {
		
		assertEquals(myBinHeap.count(), 0);
	}
	@Test
	public void testCount1() {
		myBinHeap.push(0);
		assertEquals(myBinHeap.count(), 1);
	}
	@Test
	public void testCount2() {
		myBinHeap.push(0);
		myBinHeap.push(0);
		assertEquals(myBinHeap.count(), 2);
	}
	@Test
	public void testCount3() {
		myBinHeap.push(0);
		myBinHeap.push(0);
		myBinHeap.push(0);
		assertEquals(myBinHeap.count(), 3);
	}
	@Test
	public void testCount4() {
		myBinHeap.push(0);
		myBinHeap.push(0);
		myBinHeap.push(0);
		myBinHeap.push(0);
		assertEquals(myBinHeap.count(), 4);
	}
	@Test
	public void testCount5() {
		myBinHeap.push(0);
		myBinHeap.push(0);
		myBinHeap.push(0);
		myBinHeap.push(0);
		myBinHeap.push(0);
		assertEquals(myBinHeap.count(), 5);
	}
	
	//test added after the jacoco coverage report
	@Test
	public void testPop3Height0101() {
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);
		MyTreeInputList.add(0);
		MyTreeInputList.add(1);

		myBinHeap.setHeap(MyTreeInputList);
		
		MyTreeTestList.add(0);
		MyTreeTestList.add(1);
		MyTreeTestList.add(1);
		
		assertEquals(myBinHeap.pop(), 0);
		assertEquals(myBinHeap.getHeap(),MyTreeTestList);
	}


}