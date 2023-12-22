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

Nous avons identifier quelques test smells que nous avons vu en cours qui sont implémentés par ces règles.

Test logic in production code
- Le code de production ne doit pas contenir de logique destinée aux tests. Cette logique doit être placée dans les tests.
- `JUnit4TestShouldUseBeforeAnnotation` et `JUnit4TestShouldUseAfterAnnotation` peuvent être utilisées pour vérifier ce test smell, ces règles vérifient qu'on utilise @Before et @After avant et après les tests.

Eager test
- Les tests ne doivent pas contenir trop d'assertions.
- `JUnitTestContainsTooManyAsserts` vérifie cela.

Assertion roulette
- C'est lorsqu'il est difficle de savoir quelle assertion a fail
- `JUnitAssertionsShouldIncludeMessage` vérifie que les assertions contiennet un message, cela permet de savoir ce qu'on a testé et où.



En utilisant la règle `JUnitTestContainsTooManyAsserts` sur le projet Apache Commons Lang, on constate 2712 violations, on en conclut facilement que la règle n'est pas appliquée dans l'élaboration des tests pour ce projet.