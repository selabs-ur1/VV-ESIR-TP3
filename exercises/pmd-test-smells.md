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

The first test smell identified is Piggybacking with the test JUnitTestContainsTooManyAsserts.md.

We detected a test smell in Commons Collections, in the AbstractArrayListTest.java. The test is the following:
```
@Test
public void testNewArrayList() {
    final ArrayList<E> list = makeObject();
    assertTrue("New list is empty", list.isEmpty());
    assertEquals("New list has size zero", 0, list.size());
    
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
}
```

The problem here is that the isEmpty() method is the exact same thing as list.size() == 0, so the first two assertions are checking the same thing.
We can remove one or the other and the test will function as it did already.
