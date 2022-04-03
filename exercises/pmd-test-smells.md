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

- En classe, on a vu le JUnit4TestShouldUseTestAnnotation (on vérifie que chaque test est précédé par l'annotation `@Test`), le JUnitSpelling (utiliser les bonnes convention de nommage) et le JUnitTestContainsTooManyAsserts (si un test a beaucoup d'asserts, c'est peut-être qu'il teste plusieurs choses et devrait donc être divisé en plusieurs scénario-tests).
- On utilise JUnitTestContainsTooManyAsserts : pmd -d commons-collections-master -R category/java/bestpractices.xml/JUnitTestContainsTooManyAsserts
On constate que de nombreux tests ont plus d'une assertion. Une amélioration serait alors de séparer chaque test en autant de nouveau tests qu'il y a d'assert pour bien séparer leurs préoccupations. En voici un exemple :
```Java
    @Test
    public void testNewArrayList() {
        final ArrayList<E> list = makeObject();
        assertTrue("New list is empty", list.isEmpty());
        assertEquals("New list has size zero", 0, list.size());

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
}
```
devient :
```Java
    @Test
    public void testNewArrayListIsEmpty() {
        final ArrayList<E> list = makeObject();
        assertTrue("New list is empty", list.isEmpty());
    }
    
    @Test
    public void testNewArrayListHasSizeZero() {
        final ArrayList<E> list = makeObject();
        assertEquals("New list has size zero", 0, list.size());
    }
    
    @Test
    public void testNewArrayListCanNotGet() {
        final ArrayList<E> list = makeObject();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
}
```
