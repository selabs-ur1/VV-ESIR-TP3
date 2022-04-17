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

DetachedTestCase

JUnit4TestShouldUseAfterAnnotation

JUnit4TestShouldUseBeforeAnnotation

JUnit4TestShouldUseTestAnnotation

JUnitTestContainsTooManyAsserts

JUnitTestsShouldIncludeAssert

UseAssertSameInsteadOfAssertTrue

That's what we see in classes.

Let's use "JUnitTestContainsTooManyAsserts" and on Apache Commons Collection:
[...]
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2145:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2178:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2193:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2210:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2249:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2258:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2282:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/CollectionUtilsTest.java:2293:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/ComparatorUtilsTest.java:34:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/ComparatorUtilsTest.java:47:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/ComparatorUtilsTest.java:57:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/ComparatorUtilsTest.java:75:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/ComparatorUtilsTest.java:93:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/ComparatorUtilsTest.java:101:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/EnumerationUtilsTest.java:42:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/EnumerationUtilsTest.java:60:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/EnumerationUtilsTest.java:79:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/EnumerationUtilsTest.java:110:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:47:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:58:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:69:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:77:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:94:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:104:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:114:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:124:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:202:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FactoryUtilsTest.java:222:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FluentIterableTest.java:110:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FluentIterableTest.java:129:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
/private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FluentIterableTest.java:143:	JUnitTestContainsTooManyAsserts:	Unit tests should not contain more than 1 assert(s).
[...]

We can improve this issue by make test Method as much there is assertions.
There is /private/student/n/un/blebrun/VV/TP2/commons-collections/src/test/java/org/apache/commons/collections4/FluentIterableTest.java:143.

@Test
    public void appendIterable() {
        final List<Integer> listB = Arrays.asList(10, 20, 30);
        final FluentIterable<Integer> it = FluentIterable.of(iterableA).append(listB);
        assertEquals(IterableUtils.size(iterableA) + listB.size(), IterableUtils.size(it));
        assertTrue(IterableUtils.contains(it, 1));
        assertTrue(IterableUtils.contains(it, 10));
        assertTrue(IterableUtils.contains(it, 20));
        assertTrue(IterableUtils.contains(it, 30));
        assertFalse(IterableUtils.contains(it, 40));
    }
    
Improve this code :
@Test
public void appendIterable() {
    final List<Integer> listB = Arrays.asList(10, 20, 30);
    final FluentIterable<Integer> it = FluentIterable.of(iterableA).append(listB);
    assertEquals(IterableUtils.size(iterableA) + listB.size(), IterableUtils.size(it));
}
@Test
public void appendIterable() {
    final List<Integer> listB = Arrays.asList(10, 20, 30);
    final FluentIterable<Integer> it = FluentIterable.of(iterableA).append(listB);
    assertTrue(IterableUtils.contains(it, 1));
}
@Test
public void appendIterable() {
    final List<Integer> listB = Arrays.asList(10, 20, 30);
    final FluentIterable<Integer> it = FluentIterable.of(iterableA).append(listB);
    assertTrue(IterableUtils.contains(it, 10));
}
@Test
public void appendIterable() {
    final List<Integer> listB = Arrays.asList(10, 20, 30);
    final FluentIterable<Integer> it = FluentIterable.of(iterableA).append(listB);
    assertTrue(IterableUtils.contains(it, 20));
}
@Test
public void appendIterable() {
    final List<Integer> listB = Arrays.asList(10, 20, 30);
    final FluentIterable<Integer> it = FluentIterable.of(iterableA).append(listB);
    assertTrue(IterableUtils.contains(it, 30));
}
@Test
public void appendIterable() {
    final List<Integer> listB = Arrays.asList(10, 20, 30);
    final FluentIterable<Integer> it = FluentIterable.of(iterableA).append(listB);
    assertFalse(IterableUtils.contains(it, 40));
}