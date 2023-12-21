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

> Testing Happy Path only:
>* UnnecessaryBooleanAssertion.md
>
> Eager test ; Piggyback:
>* JUnitTestContainsTooManyAsserts
>
> Conditional test logic:
>* UseAssertEqualsInsteadOfAssertTrue.md
>* UseAssertNullInsteadOfAssertTrue.md
>* UseAssertSameInsteadOfAssertTrue.md
>* UseAssertTrueInsteadOfAssertEquals.md

> I executed UnnecessaryBooleanAsertion.md and JUnitTestContainsTooManyAsserts on the *Apache Commons Collections* project and in both cases there is no test smells detected. Below, you will find the output of the execution of these two rules on *Apache Commons Collections*:
>
> <img width="1579" alt="image" src="https://github.com/ZieAmara/VV-ESIR-TP3/assets/90223980/b901bae0-8cb7-4a06-a9ff-d6d2e22f9b2a">

