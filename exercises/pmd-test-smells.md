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

- Nous utilisons la règle ``JUnitTestContainsTooManyAsserts``
- Nous utilisons le projet `commons-lang` d’apache

L'une des sorties que nous obtenons dans la console lorsque nous exécutons le script pmd est la suivante :
````
.\src\test\java\org\apache\commons\lang3\ArrayUtilsRemoveMultipleTest.java:34:  
JUnitTestContainsTooManyAsserts:        Unit tests should not contain more than 1 assert(s).

````

##### Le nom du test smell que pmd a détecté est appélé : ``The Free Ride`` aussi connus comme ``Piggybac``
Cela est du fait que la méthode contenait plusieurs oracles de Test :

````java

@Test
public void testRemoveAllBooleanArray() {
   boolean[] array;

   array = ArrayUtils.removeAll(new boolean[] { true }, 0);
   assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false }, 0);
   assertArrayEquals(new boolean[]{false}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false }, 1);
   assertArrayEquals(new boolean[]{true}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, true }, 1);
   assertArrayEquals(new boolean[]{true, true}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false }, 0, 1);
   assertArrayEquals(ArrayUtils.EMPTY_BOOLEAN_ARRAY, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, false }, 0, 1);
   assertArrayEquals(new boolean[]{false}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, false }, 0, 2);
   assertArrayEquals(new boolean[]{false}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, false }, 1, 2);
   assertArrayEquals(new boolean[]{true}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, true, false, true }, 0, 2, 4);
   assertArrayEquals(new boolean[]{false, false}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, true, false, true }, 1, 3);
   assertArrayEquals(new boolean[]{true, true, true}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, true, false, true }, 1, 3, 4);
   assertArrayEquals(new boolean[]{true, true}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, true, false, true, false, true }, 0, 2, 4, 6);
   assertArrayEquals(new boolean[]{false, false, false}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, true, false, true, false, true }, 1, 3, 5);
   assertArrayEquals(new boolean[]{true, true, true, true}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());

   array = ArrayUtils.removeAll(new boolean[] { true, false, true, false, true, false, true }, 0, 1, 2);
   assertArrayEquals(new boolean[]{false, true, false, true}, array);
   assertEquals(Boolean.TYPE, array.getClass().getComponentType());
}


````
#### Problème :
Dans cette perspective, au lieu de créer une nouvelle procédure de test pour évaluer une fonctionnalité distincte, les testeurs incorporent de nouvelles assertions afin de vérifier d'autres caractéristiques. Cette approche peut entraîner des tests surchargés et des excès d'affirmations.

#### Solution : 
Créer une methode de test pour chaque scenario 

````java

@Test
    public void testRemoveAll_EmptyArray_ReturnsEmptyArray() {
        boolean[] array = ArrayUtils.removeAll(new boolean[]{}, 0);
        assertArrayEquals(new boolean[]{}, array);
        assertEquals(Boolean.TYPE, array.getClass().getComponentType());
    }

    @Test
    public void testRemoveAll_RemoveFirstElement() {
        boolean[] array = ArrayUtils.removeAll(new boolean[]{true, false, true}, 0);
        assertArrayEquals(new boolean[]{false, true}, array);
        assertEquals(Boolean.TYPE, array.getClass().getComponentType());
    }

    @Test
    public void testRemoveAll_RemoveLastElement() {
        boolean[] array = ArrayUtils.removeAll(new boolean[]{true, false, true}, 2);
        assertArrayEquals(new boolean[]{true, false}, array);
        assertEquals(Boolean.TYPE, array.getClass().getComponentType());
    }

    @Test
    public void testRemoveAll_RemoveMiddleElement() {
        boolean[] array = ArrayUtils.removeAll(new boolean[]{true, false, true}, 1);
        assertArrayEquals(new boolean[]{true, true}, array);
        assertEquals(Boolean.TYPE, array.getClass().getComponentType());
    }

````