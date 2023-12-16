# Implementing and testing a binary heap

A [_binary heap_](https://en.wikipedia.org/wiki/Binary_heap) is a data structure that contains comparable objects and it is able to efficiently return the lowest element.
This data structure relies on a binary tree to keep the insertion and deletion operations efficient. It is the base of the [_Heapsort_ algorithm](https://en.wikipedia.org/wiki/Heapsort).

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

1. With the help of _Input Space Partitioning_ design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy _Base Choice Coverage_. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer

1.

Pour la méthode `pop()`:

| Caractéristique | b1  | b2  |
| --------------- | --- | --- |
| Taille du tas   | 0   | >=1 |

Pour la méthode `peek()`:

| Caractéristique | b1  | b2  |
| --------------- | --- | --- |
| Taille du tas   | 0   | >=1 |

Pour la méthode `push()`:

| Caractéristique | b1           | b2       |
| --------------- | ------------ | -------- |
| Taille du tas   | 0            | >=1      |
| Elément         | Non doublons | Doublons |

Pour la méthode `count()`:

| Caractéristique | b1  | b2   |
| --------------- | --- | ---- |
| Taille du tas   | 0   | >= 1 |

La taille du tas est une caractéristique commune à toutes les méthodes.

2. Avec les tests initiaux, nous avons obtenu un coverage de 98%. Le cas manquant correspond à un arbre où la valeur du fils gauche est inférieure à la valeur du fils droit ce qui est le cas pour l'arbre suivant :

![Binary Heap](BinaryHeap.jpg)
