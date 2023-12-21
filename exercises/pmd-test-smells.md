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

Les règles implémentes deux tests de bad smell, le premier est la trop gross quantité d'asserts dans un test. Le deuxième permet de détecter les assertions inutile comme assertTrue(true).

Après avoir utilisé la règles pour détecter la surcharge d'assert dans un test, on observe que beaucoup de tests ne respecte pas cette règle.

Ainsi le test suivant contient trois insert. En cas de faillure du test, il sera donc difficile de savoir pourquoi.

    @Test
    public void testNewArrayList() {
        final ArrayList<E> list = makeObject();
        assertTrue(list.isEmpty(), "New list is empty");
        assertEquals(0, list.size(), "New list has size zero");

        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
    
    code améliorer : 
    
    @Test
    public void testNewArrayListEmpty() {
        final ArrayList<E> list = makeObject();
        assertTrue(list.isEmpty(), "New list is empty");
    }
    
    @Test
    public void testNewArrayListEmptySize() {
        final ArrayList<E> list = makeObject();
        assertEquals(0, list.size(), "New list has size zero");
;
    }
    
    @Test
    public void testNewArrayListAccesEmpty() {
        final ArrayList<E> list = makeObject();
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
    }
