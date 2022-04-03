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

### Input Space Partitionning

The common characteristic is the heap size.

#### Pop
| Characteristics |           | Blocks |           |                   |
|-----------------|-----------|--------|-----------|-------------------|
|                 |           | b1     | b2        | b3                |
| q1              | heap size | empty  | 1 element | multiple elements |


#### Peek
| Characteristics |           | Blocks |           |
|-----------------|-----------|--------|-----------|
|                 |           | b1     | b2        |
| q1              | heap size | empty  | multiple element |


#### Push 
| Characteristics |           | Blocks |           |
|-----------------|-----------|--------|-----------|
|                 |           | b1     | b2        |
| q1              | heap size | empty  | multiple elements |


#### Count
| Characteristics |           | Blocks |                    |
|-----------------|-----------|--------|--------------------|
|                 |           | b1     | b2                 |
| q1              | heap size | empty  | multiple elements  |


### Statement coverage

statement coverage : 97,4 %
Covered instructions : 457
Missed instructions : 12

The missed instruction are :
```java
Assertions.assertThrows(NoSuchElementException.class, () -> heap.pop());
```
in test case wich seems to be normal.

### PIT

|             | Line Coverage | Mutation Coverage |
|-------------|---------------|-------------------|
| PIT Summary | 100% (45/45)  | 86% (32/37)       |

Alive mutants are all : ```changed conditional boudary```
After analysis it happens when two elements are equals, it does not cause any bug, it simply exange the place two node of the same  value.

Before mutation :
```java
if(left < counter && comparator.compare(heap2.get(left), heap2.get(i)) < 0)
```

After mutation :
```java
if(left < counter && comparator.compare(heap2.get(left), heap2.get(i)) <= 0)
```

Both are correct.
