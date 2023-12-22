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

## Règles PMD

### DetachedTestCase

Une méthode ne doit pas être un test détaché, c'est-à-dire une méthode qui n'est pas annotée avec `@Test` tout en
n'étant pas privée.

### JUnit4SuitesShouldUseSuiteAnnotation

Si JUinit 4 est utilisé, les suites de tests doivent être indiquées par l'annotation `@RunWith(Suite.class)` et non plus
par la méthode `suite()` (qui est utilisée dans JUnit 3).

### JUnit4TestShouldUseAfterAnnotation

Si JUnit 4 est utilisé, les méthodes de nettoyage doivent être indiquées par l'annotation `@After` et non plus par la
méthode `tearDown()` (qui est utilisée dans JUnit 3) et qui est maintenant ignorée.

### JUnit4TestShouldUseBeforeAnnotation

Si JUnit 4 est utilisé, les méthodes de préparation doivent être indiquées par l'annotation `@Before` et non plus par la
méthode `setUp()` (qui est utilisée dans JUnit 3) et qui est maintenant ignorée.

### JUnit4TestShouldUseTestAnnotation

Si JUnit 4 est utilisé, les méthodes de test doivent être indiquées par l'annotation `@Test` et non plus en utilisant le
préfixe `test` (qui est utilisé dans JUnit 3).

### JUnitAssertionsShouldIncludeMessage

Les assertions JUnit doivent inclure un message explicite, c'est-à-dire utiliser la version à trois arguments
de `assertEquals()` (qui permet de spécifier un message) et non la version à deux arguments.

### JUnitSpelling

Les méthodes de test doivent être nommées exactement `setUp()` et `tearDown()` et non une variante mal capitalisée (
comme `setup()` ou `TearDown()`).

### JUnitStaticSuite

La méthode `suite()` d'une classe de test doit être publique et statique.

### JUnitTestContainsTooManyAsserts

Les tests unitaires ne doivent pas contenir trop d'assertions. Beaucoup d'assertions sont indicatives d'un test
complexe,

### JUnitTestsShouldIncludeAssert

Les tests unitaires doivent inclure au moins une assertion.

### JUnitUseExpected

Les tests unitaires doivent utiliser l'annotation `@Test(expected=Exception.class)` lorsque l'on veut tester qu'une
exception est levée.

### UnnecessaryBooleanAssertion

Évaluer une assertion avec un booléen est inutile, car l'assertion sera toujours vraie ou fausse.
Si un test doit s'arrêter après avoir trouvé une erreur, utiliser la méthode `fail()`.

### UseAssertEqualsInsteadOfAssertTrue

Les assertions JUnit qui vérifient l'égalité de deux objets doivent utiliser la méthode `assertEquals()` et non
`assertTrue()`.

### UseAssertNullInsteadOfAssertTrue

Les assertions JUnit qui vérifient que l'objet est nul doivent utiliser la méthode `assertNull()` et non `assertTrue()`.

### UseAssertSameInsteadOfAssertTrue

Les assertions JUnit qui vérifient l'égalité de deux références doivent utiliser la méthode `assertSame()` et non
`assertTrue()`.

### UseAssertTrueInsteadOfAssertEquals

Les assertions JUnit qui vérifient la nature d'un booléen doivent utiliser la méthode `assertTrue()` ou `assertFalse()`
et non `assertEquals()`.

## Projet Apache Commons Math

On utilise la règle `JUnitUseExpected` pour détecter les tests qui ne vérifient pas qu'une exception est levée en
utilisant l'annotation `@Test(expected=Exception.class)`.

Par exemple, dans le fichier commons-math-legacy-core/src/test/java/org/apache/commons/math4/legacy/core/jdkmath/AccurateMathTest.java à
la ligne 1541, on trouve le test suivant :

```java
public class AccurateMathTest {
  @Test
  public void testIncrementExactInt() {
    int[] specialValues = new int[]{
        Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2,
        Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2,
        -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        -1 - (Integer.MIN_VALUE / 2), 0 - (Integer.MIN_VALUE / 2), 1 - (Integer.MIN_VALUE / 2),
        -1 + (Integer.MAX_VALUE / 2), 0 + (Integer.MAX_VALUE / 2), 1 + (Integer.MAX_VALUE / 2),
    };
    for (int a : specialValues) {
      BigInteger bdA = BigInteger.valueOf(a);
      BigInteger bdSum = bdA.add(BigInteger.ONE);
      if (bdSum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0 ||
          bdSum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
        try {
          AccurateMath.incrementExact(a);
          Assert.fail("an exception should have been thrown");
        } catch (ArithmeticException mae) {
          // expected
        }
      } else {
        assertEquals(bdSum, BigInteger.valueOf(AccurateMath.incrementExact(a)));
      }
    }
  }
}
```

On peut voir l'utilisation d'une clause `try`/`catch` pour vérifier qu'une exception est levée.
Si celle-ci n'est pas levée, on utilise la méthode `Assert.fail()` pour arrêter le test.
On peut voir qu'on s'attend à ce que l'exception `ArithmeticException` soit levée.

On peut donc remplacer le test par :

```java
public class AccurateMathTest {
  @Test(expected = ArithmeticException.class)
  public void testIncrementExactInt() {
    int[] specialValues = new int[]{
        Integer.MIN_VALUE, Integer.MIN_VALUE + 1, Integer.MIN_VALUE + 2,
        Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2,
        -10, -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        -1 - (Integer.MIN_VALUE / 2), 0 - (Integer.MIN_VALUE / 2), 1 - (Integer.MIN_VALUE / 2),
        -1 + (Integer.MAX_VALUE / 2), 0 + (Integer.MAX_VALUE / 2), 1 + (Integer.MAX_VALUE / 2),
    };
    for (int a : specialValues) {
      BigInteger bdA = BigInteger.valueOf(a);
      BigInteger bdSum = bdA.add(BigInteger.ONE);
      if (bdSum.compareTo(BigInteger.valueOf(Integer.MIN_VALUE)) < 0 ||
          bdSum.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0) {
        AccurateMath.incrementExact(a);
      } else {
        assertEquals(bdSum, BigInteger.valueOf(AccurateMath.incrementExact(a)));
      }
    }
  }
}
```
