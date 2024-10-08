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

You can find the associated code in the code repository.

Please note that for this exercise, we will not detail the answer as we processed the same method on the previous exercises.

### 1. Input Space Partionning to design an Initial set of inputs

Here are the categories of inputs according to each method:

| | Push | Pop | Peek | Count |
|-|-|-|-|-|
|Block 1| Non-null elements | Non-empty heap | Non-empty heap | After pushing one or more elements
|Block 2| Null elements | Empty heap | Empty heap | After popping one or more elements
|Block 3| | | | Empty heap

### 2. Statement Coverage

By implementing those tests and analyze them with PITest, we obtain this score.

![img_1.png](img_1.png)

Not so great.

Then we thought about emptying all the heap.

To try, we will create two tests, each with a heap:
- with ordered numbers
- created with ordered numbers in reverse

![img.png](img.png)

Way better, doesn't it?

When we look at the four others mutants left, we see they are related to "a conditional boundary changed"
```
line 53 : comparator.compare(heap.get(rightChildIndex), heap.get(leftChildIndex)) < 0

line 58 :  comparator.compare(heap.get(index), heap.get(smallestChildIndex)) <= 0

line 107 : index > 0
line 107 : comparator.compare(heap.get(index), heap.get(parentIndex)) < 0
```

For each of these case, it is impossible to detect any conditional boundary change because this will not impact the result.
The only thing that it will do is swap two equal values or go few iterations further.
This will maybe impact the complexity, but never the result.