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

Jugieau Barthelat

In class we talked about the general architecture of a test suite. Tests are divided in three parts : the @Before part which should be executed before each test, the @After part which should be executed after each test, even if this part is not that useful in Java because of the garbage collector. @Before annotations should be before the setUp() method and @After should be before the tearDown() method.

So rules which referred to that are:
,JUnit4TestShouldUseAfterAnnotation ,JUnit4TestShouldUseBeforeAnnotation , JUnit4TestShouldUseTestAnnotation
So we tried the before and after annotation rules on the math and CLI projects, and PMD found nothing wrong.
We did get some warnings with the AssertionsShouldIncludeMessage and TestContainsTooManyAsserts rules, although these are not the most necessary rules to follow.

