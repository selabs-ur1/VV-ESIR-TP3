package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Random;

class BinaryHeapTest{

	private BinaryHeap<Integer> heapInt;
	private BinaryHeap<String> heapString;
	private Random r = new Random();

	//Ces comparaisons sont mauvaises : un nombre très grand moins un nombre très petit (négatif) risque de résulter en un nombre négatif (limite de bits).
	//Une solution serait de comparer directement les entiers/longueur de string et de renvoyer 1,0 ou -1 en fonction du résultat de la comparaison.
	protected class CompInt implements Comparator<Integer>{
		@Override
		public int compare(Integer i1, Integer i2) {
			return i1-i2;
		}
		
	}
	
	protected class CompString implements Comparator<String>{
		@Override
		public int compare(String s1, String s2) {
			return s1.length()-s2.length();
		}
		
	}
	
	
	@Test
	void testBinaryHeap() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		heapString = new BinaryHeap<String>(new CompString());
	}
	
	//On vérifie que le push() fonctionne dans un cas simple, et que le peek() renvoie le résultat attendu.
	@Test
	void testPushAndPeek() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		heapString = new BinaryHeap<String>(new CompString());
		int randInt = r.nextInt(10000000);
		heapInt.push(randInt);
		
		byte[] array = new byte[7]; //la longueur du String sera de 7 caractères max.
		r.nextBytes(array);
		String randString = new String(array, Charset.forName("UTF-8"));
		heapString.push(randString);
		
		assertEquals(randInt,heapInt.peek());
		assertEquals(randString,heapString.peek());
	}

	//On vérifie que pop() renvoie bien ce qui a été push()ed.
	@Test
	void testPop() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		ArrayList<Integer> inputIntegers = new ArrayList<Integer>();
		for(int i=0; i<=r.nextInt(10); i++) {
			int randInt = r.nextInt(10000000);
			inputIntegers.add(randInt);
			heapInt.push(randInt);
		}
		System.out.println();
		int iSecurite = 10; //Pour s'assurer que l'on quitte la boucle while
		while(heapInt.count()>0 && iSecurite>0) {
			int nextInt = heapInt.peek();
			heapInt.pop();
			inputIntegers.remove(Integer.valueOf(nextInt));
			iSecurite--;
		}
		assertEquals(heapInt.count(),0);	//On vérifie que la pile est vide
		assertTrue(inputIntegers.isEmpty());
	}

	//On peek() un tas vide
	@Test
	void testPeekEmpty() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		assertThrows(NoSuchElementException.class, () -> heapInt.peek());
	}

	//On pop() une fois de trop
	@Test
	void testPopEmpty() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		int randNbPush = r.nextInt(10);
		for(int i=0; i<= randNbPush; i++) {
			heapInt.push(r.nextInt(10000000));
		}
		for(int i=0; i<= randNbPush; i++) {
			heapInt.pop();
		}
		assertThrows(NoSuchElementException.class, () -> heapInt.pop());
	}
	
	@Test
	void testIncreasingOrder() {
		Comparator<Integer> cmp = new CompInt();
		heapInt = new BinaryHeap<Integer>(cmp);
		int nbElem = r.nextInt(100);
		for(int i=0; i<nbElem; i++) {
			heapInt.push(r.nextInt(10000000));
		}
		//On s'assure que chaque élément renvoyer par pop() est plus petit que le suivant.
		int previous = heapInt.pop();
		for(int i=1; i<nbElem; i++) {
			int current = heapInt.pop();
			assertTrue(cmp.compare(previous, current)<0);
		}
		
	}

	@Test
	void testCountEmpty() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		assertEquals(heapInt.count(),0);
	}

	@Test
	void testCountNotEmpty() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		int nbElem = r.nextInt(10);
		for(int i=0; i<nbElem; i++) {
			heapInt.push(r.nextInt(10000000));
		}
		assertEquals(heapInt.count(), nbElem);
	}
	
	//Ce test a été implémenté en conséquence de la question 2.
	//Ce test a pour vocation de tester une ligne unique de push() non testée par les autres tests.
	@Test
	void testPushRightSon() {
		heapInt = new BinaryHeap<Integer>(new CompInt());
		heapInt.push(1);
		heapInt.push(3);
		heapInt.push(2);
		heapInt.pop();
		heapInt.push(4);
		assertEquals(heapInt.pop(), 2);
		assertEquals(heapInt.pop(), 3);
		assertEquals(heapInt.pop(), 4);
	}
	
	//Ce test a été implémenté en conséquence de la question 3.
	//On vérifie au final que le tas avait bien tous les éléments qu'il est supposé avoir gardé et qu'il les renvoie dans l'ordre.
	@Test
	void testPushPopRandom() {
		Comparator<Integer> cmp = new CompInt();
		heapInt = new BinaryHeap<Integer>(cmp);
		ArrayList<Integer> intList = new ArrayList<Integer>();
		
		int nbPush = 10000;
		//On push() d'abord pour s'assurer de ne pas pop() trop de fois.
		for(int i=0; i<nbPush; i++) {
			int nextInt = r.nextInt(100000);
			heapInt.push(nextInt);
			intList.add(nextInt);
		}
		
		for(int i=0; i<nbPush; i++) {
			boolean gonnaPush = r.nextBoolean();
			if(gonnaPush) {
				int nextInt = r.nextInt(100000);
				heapInt.push(nextInt);
				intList.add(nextInt);
			}
			else {
				Integer toRemove = heapInt.pop();
				intList.remove(toRemove);
			}
		}
		
		int iSec = 200010;
		Integer previous = heapInt.pop();
		intList.remove(heapInt.pop()); //previous est bien un Integer, et non pas un int ; le remove() fonctionnera donc bien sur les valeurs, et non pas sur l'index.
		while(heapInt.count()>0 && iSec>0) {
			iSec--;
			Integer current = heapInt.pop();
			intList.remove(heapInt.pop());
			assertTrue(cmp.compare(previous, current)<0);
			
		}
		assertEquals(heapInt.count(), 0);
	}
		
}