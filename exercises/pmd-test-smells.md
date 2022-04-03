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

We tried pmd with the detachedTestCase test smell. It is smelling if the a part of the program is looking like to a test cas missing @test or @ignore.


Message PMD:
```The method appears to be a test case since it has public or default visibility, non-static access, no arguments, no return value, has no annotations, but is a member of a class that has one or more JUnit test cases. If it is a utility method, it should likely have private visibility. If it is an ignored test, it should be annotated with @Test and @Ignore.```
