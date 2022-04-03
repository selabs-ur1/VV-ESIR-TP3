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

The different test smells that we saw during the course and that are implemented by these PMD rules are :

Eager test using JUnitTestContainsTooManyAsserts

Assertion roulette using JUnitAssertionsShouldIncludeMessage and JUnitTestContainsTooManyAsserts

The Free Ride using JUnitTestContainsTooManyAsserts

We used the PMD rule JUnitTestContainsTooManyAsserts on the common-math project and we detected that a lot of tests have too many assertions. To improve these tests, we just need to break down the tests that have too many assertions into many different test.