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
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-heap](../code/tp3-heap) to complete this exercise.

## Answer
1. Dans les tests, on a pris comme inputs :
- des inputs vides (ou pas d'inputs) (`testBinaryHeap()`, `testPeekEmpty()` et `testCountEmpty()`) ;
- des entrées de tailles quelconques (toutes les autres méthodes).
2. Le coverage est de 98% (selon PIT). La seule ligne non couverte par les tests est : ``rightSon = new BinaryHeap<T>(cmp,toPush);`` dans ``push()`` dans le cas où il y a déjà un fils gauche mais pas de fils droit. Cela est dû au fait que la méthode créer en priorité un fils gauche, puis on inverse le fils droit et le fils gauche ; si on ne fait que remplir le tas, on ne créera jamais un fils droit. Il faut donc créer un nouveau test qui créera un tas, le remplira, puis le videra de telle manière à ce qu'un fils droit se vide tout en gardant son frère de gauche rempli, puis ajoute à nouveau une valeur dans le tas. Ce test sera nommé `testPushRightSon()`. Ainsi on obtient une couverture de 100%.
3. Les conditions faisant appel à plusieurs prédicats sont de la forme ``hasLeftSon() && hasRightSon`` (à une négation près devant chaque prédicat) qui semblent, à priori, être testés dans les cas où ils sont positifs et négatifs, de part l'aléatoire des tests. On pourrait définitivement s'assurer que tous les cas sont testés en créant minutieusement un test qui les fait tous, mais dû au comportement du tas (qui inverse droite et gauche à chaque ``push()``), il serait laborieux d'inventer un tel test. On a donc plutôt opté pour un test qui fait aléatoirement un grand nombre de ``push()`` et de ``pop()`` dans l'espoir de passer par tous les cas. (On remarque que cette méthode présente un gros inconvénient : le test prend du temps. Créer un input idéal pour tester les différents scénarii des prédicats auraient été plus long à mettre en place, mais aurait eu la bonne propriété d'être bien moins gourmand.)
4. Le score de mutation est de 94%. 2 mutants ont survécus ; ils ont modifié ``<`` dans une condition par ``<=``, ce qui a, dans ces cas précis, un comportement quasi-équivalent : si le fils gauche et le fils droit ont la même valeur, on peut prendre n'importe lequel des deux lors d'un ``pop()`` et on peut ajouter à n'importe lequel lors d'un ``push()``.
