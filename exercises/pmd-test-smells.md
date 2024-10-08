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

src/test/java/org/apache/commons/collections4/collection/AbstractCollectionTest.java:541:	DetachedTestCase:	Probable detached JUnit test case.

Il n'y a pas de précision concernant le type de test (@Test and @Ignore)

Code: 

public void resetFull() {
    this.setCollection(makeFullCollection());
    this.setConfirmed(makeConfirmedFullCollection());
}

Ameliorations:

@BeforeEach
public void resetFull() {
    this.setCollection(makeFullCollection());
    this.setConfirmed(makeConfirmedFullCollection());
}

