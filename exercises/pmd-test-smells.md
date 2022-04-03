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

We will show some test smells about missing annotation.

Rule: JUnit4TestShouldUseAfterAnnotation

Package : \commons-collections-master\src\test\java\org\apache\commons\collections4\iterators\FilterIteratorTest.java 59
It should have an @After annotation.

```java
@Override
public void tearDown() throws Exception {
  iterator = null;
}
```
Rule : JUnit4TestShouldUseBeforeAnnotation

Package : commons-collections-master\src\test\java\org\apache\commons\collections4\iterators\BoundedIteratorTest.java 50

It should have an @Before
```java
@SuppressWarnings("unchecked")
@Override
public void setUp() throws Exception {
    super.setUp();
    testList = Arrays.asList((E[]) testArray);
}
```
Rule : JUnit4TestShouldUseTestAnnotation

Package : \commons-collections-master\src\test\java\org\apache\commons\collections4\keyvalue\AbstractMapEntryTest.java 121

It should have an @Test or @Ignore because the method is empty.
```java
public abstract void testConstructors();
```
