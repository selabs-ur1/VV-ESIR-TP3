# Implementing and testing a binary heap

A [*binary heap*](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [*Heapsort* algorithm](https://en.wikipedia.org/wiki/Heapsort).

Implement a `BinaryHeap` class with the following interface:

```java
class BinaryHeap<T> {

    public BinaryHeap(Comparator<T> comparator) { ... }

    public T pop() { ... }

    public T peek() { ... }

    public void push(T element) { ... }

    public int count() { ... }

}
```

A `BinaryHeap` instance is created using a `Comparator` object that represents the ordering criterion between the objects in the heap.
`pop` returns and removes the minimum object in the heap. If the heap is empty it throws a `NotSuchElementException`.
`peek` similar to `pop`, returns the minimum object but it does not remove it from the `BinaryHeap`.
`push` adds an element to the `BinaryHeap`.
`count` returns the number of elements in the `BinaryHeap`.

Design and implement a test suite for this `BinaryHeap` class.
Feel free to add any extra method you may need.

Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer
1. The inputs are common to all methods apart from push which takes an element.
 I decided to start by testing the push method so that I could use it for the next tests.
 For this method I considered 4 inputs, the height of the tree, the value of the root, tha value of the first childLeft and the value of the first childRight.
 I chose all of these inputs depending on the value of the input "element"
 
|                            | b1                      | b2           | b3           | b4           | 
| -----------------------    | -----------             | -----------  | ------------ |  ---------   |
| q1       Tree's height     | 0                       | 1            | 2            |              |
| q2       root value        | <element                | >element     | =element     |              |
| q3       childLeft value   | <element                | >element     | =element     |              |
| q4       childRightvalue   | <element                | >element     | =element     | null         |

For the pop() method I chose the same input as the push method but i modified the blocks:
|                            | b1                      | b2           | b3           | b4           |  
| -----------------------    | -----------             | -----------  | ------------ |  ---------   |
| q1       Tree's height     | 0                       | 1            | 2            |              |
| q2       root value        | 0                       | 1            |              |              |
| q3       childLeft value   | 0                       | 1            |              |              |
| q4       childRightvalue   | 0                       | 1            |   null       |              |

As for the peek() method I tested with an empty heap and a heap with one element since the ordering was already tested with pop.

And to finish, for the count method I tested with 5 different sizes of tree,{0,1,2,3,4,5} .

2. Same as with the previous question, I used Jacoco to check the coverage.
The first results I got were 100% on every method except pop(), I have but the screenshot in the code folder of the exercice.

The issue was that I had not tested some code inside a condition, more precisely when the childRigth was the smaller child. The issue that caused this is that I wasn't testing pop on trees with 3 of heigh so the rigthChild just did not exist. I resolved this issue by adding a test with the appropriate tree.:
```java
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

```

3. After solving this issue, the code was reachable but one branche was still missed in the condition.
```java
if (indexChildRight<heap.size() && comparator.compare(heap.get(indexChildRight), heap.get(indexChildLeft)) <= 0) {
```
But the branch that was missed just could not be reached because if the index of the right child was out of bounds, then the comparator could not get a value out of it.

4. With the pit report, I got two surviving mutant and both were on conditions similar to the one above.

The first surviving mutant was on this condition, and it survived because changing the boundary condition in here does not change the behavior of the code
```java
if (indexChildRight<heap.size() && comparator.compare(heap.get(indexChildRight), heap.get(indexChildLeft)) <= 0) {
```
The second surviving mutant was on this condition, and it survived because of the same reason as for the other one. The mutant changed the boundary, but this part of the condition was not reached so it did not change the behavior of the code.
```java
if (minChild!=null && comparator.compare(heap.get(currentIndex), minChild) > 0) {
```
