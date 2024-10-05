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

PS C:\Users\celia\Documents\ESIR\Cycle ingé\ESIR2\S7\VV\TP\VV-ESIR-TP3\pmd-documentation> pmd check -d ..\..\VV-ESIR-TP2\code\commons-collections\ -R category/java/bestpractices.xml/JUnitUseExpected -f text
[WARN] Progressbar rendering conflicts with reporting to STDOUT. No progressbar will be shown. Try running with argument -r <file> to output the report to a file instead.
[WARN] This analysis could be faster, please consider using Incremental Analysis: https://docs.pmd-code.org/pmd-doc-7.6.0/pmd_userdocs_incremental_analysis.html
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\collection\AbstractCollectionTest.java:828:    JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\iterators\AbstractMapIteratorTest.java:141:    JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:1495: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:1505: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:1639: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:1891: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:1902: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2045: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2064: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2117: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2138: JUnitUseExpected:       In JUnit4, use the @Test(expected) annotation to denote tests that should throw exceptions



PS C:\Users\celia\Documents\ESIR\Cycle ingé\ESIR2\S7\VV\TP\VV-ESIR-TP3\pmd-documentation> pmd check -d ..\..\VV-ESIR-TP2\code\commons-collections\ -R category/java/errorprone.xml/DetachedTestCase -f text
[WARN] Progressbar rendering conflicts with reporting to STDOUT. No progressbar will be shown. Try running with argument -r <file> to output the report to a file instead.
[WARN] This analysis could be faster, please consider using Incremental Analysis: https://docs.pmd-code.org/pmd-doc-7.6.0/pmd_userdocs_incremental_analysis.html
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\IterableUtilsTest.java:71:     DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\IterableUtilsTest.java:78:     DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\bidimap\AbstractBidiMapTest.java:600:  DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\collection\AbstractCollectionTest.java:531:    DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\collection\AbstractCollectionTest.java:541:    DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\collection\AbstractCollectionTest.java:1363:   DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\functors\AbstractCompositePredicateTest.java:137:      DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\iterators\AbstractIteratorTest.java:182:       DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:943:  DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:952:  DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2525: DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2532: DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2544: DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2556: DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\map\AbstractMapTest.java:2571: DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\multimap\AbstractMultiValuedMapTest.java:671:  DetachedTestCase:       Probable detached JUnit test case.
..\..\VV-ESIR-TP2\code\commons-collections\src\test\java\org\apache\commons\collections4\multimap\AbstractMultiValuedMapTest.java:679:  DetachedTestCase:       Probable detached JUnit test case.



They test if you have the best practices