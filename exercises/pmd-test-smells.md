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
La règle `JUnitTestContainsTooManyAsserts` détecte le bad smell `Assertion roulette`, où plusieurs assertions sont insérées dans le test. Dans le cas d'un echec, il est difficile de savoir quelle assertion est à l'origine du problème.
La règle `UnnecessaryBooleanAssertion` correspond au pattern Useless Asserts. Cela détecte les assertions avec des booléens type `AssertTrue(true)`.
Les règles type `UseAssertTrueInsteadOfAssertEquals` ou `UseAssertSameInsteadOfAssertTrue` détecte quand le mauvais type d'assertion est utilisé. Par exemple au lieu de `assertTrue(a != null)`, il vaut mieux faire `assertNotNull(a)`.

Nous avons utilisé la règle `JUnit4SuitesShouldUseSuiteAnnotation` et nous avons obtenu un résultat dans le fichier GuavaTestlibTest ligne 56: 
```java 
public static Test suite() {...}
```
Avec JUnit3, créer une méthode de teste nommée suite() permettait d'indiquer une suite de tests. Cependant depuis JUnit4, il doit y avoir le décorateur : @RunWith(Suite.class) au dessus du test. 

