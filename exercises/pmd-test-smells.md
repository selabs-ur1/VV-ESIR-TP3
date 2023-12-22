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

We did the following :

```bash
pmd check -d "C:\Users\PC\Desktop\commons-collections-master" -R category/java/bestpractices.xml/JUnitAssertionsShouldIncludeMessage -r checkStyle.html
[main] INFO net.sourceforge.pmd.cli - Log level is at INFO
[main] WARN net.sourceforge.pmd.cli - This analysis could be faster, please consider using Incremental Analysis: https://docs.pmd-code.org/pmd-doc-7.0.0-rc4/pmd_userdocs_incremental_analysis.html
Processing files 100% [==============] 604/604 (0:00:33) Violations:0, Errors:0
Processing files 100% [==============] 604/604 (0:00:33) Violations:0, Errors:0
```

It tested if every assertion had a message in the commons-collections project.
No violations of this rule were found.

We decided to test another ruleset to ensure that pmd was working properly.

```bash
PS C:\Users\PC\Desktop\vv_tp3> pmd check -d "C:\Users\PC\Desktop\commons-collections-master" -R category/java/bestpractices.xml/JUnitUseExpected -r checkStyle.txt
[main] INFO net.sourceforge.pmd.cli - Log level is at INFO
[main] WARN net.sourceforge.pmd.cli - This analysis could be faster, please consider using Incremental Analysis: https://docs.pmd-code.org/pmd-doc-7.0.0-rc4/pmd_userdocs_incremental_analysis.html
Processing files 100% [==============] 604/604 (0:00:27) Violations:6, Errors:0
Processing files 100% [==============] 604/604 (0:00:27) Violations:6, Errors:0
```

This generated a file with the following content :

```txt
C:\Users\PC\Desktop\commons-collections-master\src\test\java\org\apache\commons\collections4\collection\AbstractCollectionTest.java:1284:	JUnitUseExpected:	In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
C:\Users\PC\Desktop\commons-collections-master\src\test\java\org\apache\commons\collections4\iterators\AbstractMapIteratorTest.java:139:	JUnitUseExpected:	In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
C:\Users\PC\Desktop\commons-collections-master\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:850:	JUnitUseExpected:	In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
C:\Users\PC\Desktop\commons-collections-master\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:861:	JUnitUseExpected:	In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
C:\Users\PC\Desktop\commons-collections-master\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:905:	JUnitUseExpected:	In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
C:\Users\PC\Desktop\commons-collections-master\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:925:	JUnitUseExpected:	In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
```

We can see a warning for each test that does not use the `@Test(expected)` annotation.
A simple fix would be to add the annotation to each test supposed to throw an exception.
However, when reading the code of the project, we can see that ConcurrentModificationException and NoSuchElementException are not thrown in this test at line 1284 of AbstractCollectionTest but rather catched in order to later test the effect that is has on another ConcurrentModificationException. 
The fix should still be implemented, but not for the outputed lines.
