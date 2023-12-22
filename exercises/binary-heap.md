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
### 1. Partitionnement de l'espace d'entrée pour chaque méthode :

#### `BinaryHeap` Constructor (`BinaryHeap(Comparator<T> comparator)`):

- **Caractéristiques :**
  - **Valid Comparator :** Un comparateur valide.
  - **Null Comparator :** Un comparateur nul.

#### `pop` Method (`T pop()`):

- **Caractéristiques :**
  - **Empty Heap :** Le tas est vide.
  - **Heap with One Element :** Le tas a un élément.
  - **Heap with Multiple Elements :** Le tas a plusieurs éléments.

#### `peek` Method (`T peek()`):

- **Caractéristiques :**
  - **Empty Heap :** Le tas est vide.
  - **Heap with One Element :** Le tas a un élément.
  - **Heap with Multiple Elements :** Le tas a plusieurs éléments.

#### `push` Method (`void push(T element)`):

- **Caractéristiques :**
  - **Null Element :** Ajout d'un élément nul.
  - **First Element in the Heap :** Premier élément dans le tas.
  - **Not the First Element in the Heap :** Ajout d'un élément qui n'est pas le premier.

#### `count` Method (`int count()`):

- **Caractéristiques :**
  - **Empty Heap :** Le tas est vide.
  - **Heap with One Element :** Le tas a un élément.
  - **Heap with Multiple Elements :** Le tas a plusieurs éléments.

#### **Caractéristiques Communes :**
  - **Valid Input/State :** Des états/tas valides sont nécessaires pour chaque méthode.

### 2. Évaluation de la couverture de déclaration :

- **`testBinaryHeapConstructor` :** Les cas de test couvrent les blocs identifiés, notamment la création d'un tas avec un comparateur valide et la gestion d'un comparateur nul.

- **`testPop` :** Les cas de test couvrent les blocs identifiés, y compris le retrait d'un élément d'un tas vide, le retrait d'un seul élément et le retrait d'un élément parmi plusieurs.

- **`testPeek` :** Les cas de test couvrent les blocs identifiés, incluant la vérification de l'élément minimum sans le retirer pour un tas vide, un tas avec un élément et un tas avec plusieurs éléments.

- **`testPush` :** Les cas de test couvrent les blocs identifiés, y compris l'ajout d'un élément nul, l'ajout du premier élément et l'ajout d'un élément qui n'est pas le premier.

- **`testCount` :** Les cas de test couvrent les blocs identifiés, tels que le comptage dans un tas vide, un tas avec un élément et un tas avec plusieurs éléments.

### 3. Évaluation de la couverture des prédicats et Base Choice Coverage :

- **Il n'y a pas de prédicats complexes nécessitant Base Choice Coverage.**

### 4. Test Avec PIT

Sortie Initiale:
================================================================================
- Mutators
================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
>> Generated 6 Killed 1 (17%)
> KILLED 1 SURVIVED 4 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator
>> Generated 5 Killed 2 (40%)
> KILLED 2 SURVIVED 3 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NullReturnValsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.MathMutator
>> Generated 8 Killed 8 (100%)
> KILLED 8 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.BooleanFalseReturnValsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 12 Killed 8 (67%)
> KILLED 8 SURVIVED 3 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.PrimitiveReturnsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
================================================================================
- Timings
================================================================================
> scan classpath : < 1 second
> coverage and dependency analysis : 1 seconds
> build mutation tests : < 1 second
> run mutation analysis : 1 seconds
--------------------------------------------------------------------------------
> Total  : 3 seconds
--------------------------------------------------------------------------------
================================================================================
- Statistics
================================================================================
>> Generated 36 mutations Killed 24 (67%)
>> Ran 56 tests (1.56 tests per mutation)

Évaluation du score de mutation et des mutants actifs :

    Score de Mutation : 67%
    Mutants actifs : 36 mutants générés, 24 tués (67%)

Analyse des mutants :

    BooleanTrueReturnValsMutator : 100% des mutants tués.

    ConditionalsBoundaryMutator : 17% des mutants tués

    VoidMethodCallMutator : 40% des mutants tués.

    NullReturnValsMutator : 100% des mutants tués.

    MathMutator : 100% des mutants tués.

    BooleanFalseReturnValsMutator : 100% des mutants tués.

    NegateConditionalsMutator : 67% des mutants tués.

    PrimitiveReturnsMutator : 100% des mutants tués.


Modifications Apportées:
Résumé des modifications apportées aux tests existants de la classe `BinaryHeapTest` pour améliorer le score de mutation :

1. **testPop() :**
   - Ajout d'une validation du nombre d'éléments après chaque opération (`assertEquals`).
   - Vérification de la propriété du tas après l'opération `pop`.

2. **testPeek() :**
   - Ajout d'une validation du nombre d'éléments après chaque opération (`assertEquals`).

3. **testPush() :**
   - Ajout d'une validation du nombre d'éléments après chaque opération (`assertEquals`).
   - Ajout d'une vérification supplémentaire après l'opération `push`.

4. **testCount() :**
   - Ajout d'une validation du nombre d'éléments après chaque opération (`assertEquals`).
   - Ajout de plusieurs opérations `pop` pour tester les différents scénarios.

Nouveau Score de Mutation 81%

Sortie:
================================================================================
- Mutators
================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.ConditionalsBoundaryMutator
>> Generated 6 Killed 2 (33%)
> KILLED 2 SURVIVED 3 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.VoidMethodCallMutator
>> Generated 5 Killed 4 (80%)
> KILLED 4 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NullReturnValsMutator
>> Generated 2 Killed 2 (100%)
> KILLED 2 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.MathMutator
>> Generated 8 Killed 7 (88%)
> KILLED 7 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.BooleanFalseReturnValsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 12 Killed 11 (92%)
> KILLED 11 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 1 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.PrimitiveReturnsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
================================================================================
- Timings
================================================================================
> scan classpath : < 1 second
> coverage and dependency analysis : < 1 second
> build mutation tests : < 1 second
> run mutation analysis : 1 seconds
--------------------------------------------------------------------------------
> Total  : 2 seconds
--------------------------------------------------------------------------------
================================================================================
- Statistics
================================================================================
>> Generated 36 mutations Killed 29 (81%)
>> Ran 57 tests (1.58 tests per mutation)



