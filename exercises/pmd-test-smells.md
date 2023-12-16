# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Nous avons utilisé la commande 
```bash
pmd -d commons-collections/src/test/ -R category/java/bestpractices.xml/JUnitTestContainsTooManyAsserts -f html > report.html
```
Le règle JUnitTestContainsTooManyAssert permet de détecter l'utilisation de plus d'une assertion dans un test, qui est considéré comme une mauvaise pratique (il s'agit de l'"Assertion roulette" vue dans le cours).

On retrouve ce test smell dans le fichier `commons-collections/src/test/java/org/apache/commons/collections4/AbstractArrayListTest.java` à la ligne 44.
```Java
@Test
public void testNewArrayList() {
    final ArrayList<E> list = makeObject();
    assertTrue(list.isEmpty(), "New list is empty");
    assertEquals(0, list.size(), "New list has size zero");

    assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
}
```
On divise le test pour n'avoir plus qu'une assertion par test.
```Java
@Test
public void testNewArrayListIsEmpty() {
  final ArrayList<E> list = makeObject();
  assertTrue(list.isEmpty(), "New list is empty");
}

@Test
public void testNewArrayListSizeZero() {
  final ArrayList<E> list = makeObject();
  assertEquals(0, list.size(), "New list has size zero");
}

@Test
public void testNewArrayListThrowOutOfBound() {
  final ArrayList<E> list = makeObject();
  assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
  }
```
Après cette modification, PMD ne trouve plus le test smell:  l'erreur à été corrigée.
