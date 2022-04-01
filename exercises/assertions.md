# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

### Assertions

1. We are trying to compare the values of two doubles, and we know that there are a number of comma values that are not representable for a computer, given the result of the test this is surely the case for the number 1,2. To be able to compare these two values, we need to introduce a tolerance to this approximation. By calculation this difference is : 2.220446049250313E-16

To resolve this bug the test should be writen like this :
```java
assertEquals(3 * 0.4, 1.2, 10E-16);
```
