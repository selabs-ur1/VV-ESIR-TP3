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

On utilise l'analyse statique de pmd sur le projet Apache Commons Collections. On utilise la ruleset `JUnitUseExpected` qui demande l'utilisation de `@Test(expected)` en JUnit 4 au lieu d'appeler la fonction `fail`.

L'erreur est commise dans le fichier `AbstractMapIteratorTest.java` à la ligne 141. On remplace le code suivant :

```java
/**
* Test that the empty list iterator contract is correct.
*/
@Test
public void testEmptyMapIterator() {
    if (!supportsEmptyIterator()) {
        return;
    }

    final MapIterator<K, V> it = makeEmptyIterator();
    assertFalse(it.hasNext());

    // next() should throw a NoSuchElementException
    assertThrows(NoSuchElementException.class, () -> it.next());

    // getKey() should throw an IllegalStateException
    assertThrows(IllegalStateException.class, () -> it.getKey());

    // getValue() should throw an IllegalStateException
    assertThrows(IllegalStateException.class, () -> it.getValue());

    if (!supportsSetValue()) {
        // setValue() should throw an UnsupportedOperationException/IllegalStateException
        try {
            it.setValue(addSetValues()[0]);
            fail();
        } catch (final UnsupportedOperationException | IllegalStateException ex) {
            // ignore
        }
    } else {
        // setValue() should throw an IllegalStateException
        assertThrows(IllegalStateException.class, () -> it.setValue(addSetValues()[0]));
    }
}
```


```java
/**
* Test that the empty list iterator contract is correct.
*/
@Test
public void testEmptyMapIterator() {
    if (!supportsEmptyIterator()) {
        return;
    }

    final MapIterator<K, V> it = makeEmptyIterator();
    assertFalse(it.hasNext());

    // next() should throw a NoSuchElementException
    assertThrows(NoSuchElementException.class, () -> it.next());

    // getKey() should throw an IllegalStateException
    assertThrows(IllegalStateException.class, () -> it.getKey());

    // getValue() should throw an IllegalStateException
    assertThrows(IllegalStateException.class, () -> it.getValue());

    
    // setValue() should throw an IllegalStateException
    assertThrows(IllegalStateException.class, () -> it.setValue(addSetValues()[0]));
}
```
Ici, le code utilise JUnit 5 donc la bonne pratique est de tirer profit de la fonction `assertThrows` au lieu de remplacer par `@Test(expected=...).`