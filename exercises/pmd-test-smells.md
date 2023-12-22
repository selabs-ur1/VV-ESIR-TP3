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

Par rapport aux règles de PMD que nous avons à disposition ici, nous avons trouvé 3 test smells correspondants dans le cours. Le *Eager Test*, l'*Assertion Roulette* ains que le *Free Rider* sont tous les 3 des test smells qui contiennent trop d'assert dans un seul test. La règle PMD correspondante est donc *JUnitTestContainsTooManyAsserts*. 

En vérifiant la règle *JUnitTestContainsTooManyAsserts* sur les tests d'*Apache Commons Collections*, nous obtenons 1217 warnings. Certains de ces warnings sont facilement réparables et il suffit de séparer des asserts, mais d'autres ne pourront pas être séparés puisqu'ils vérifient une fonctionnalité ensemble.
La règle *JUnitTestsShouldIncludeAssert* sur les mêmes tests, nous obtenons 51 warnings. 
