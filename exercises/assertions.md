# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. We can think that the float are the same, but that's only the string version. In fact, the float aren't the same. So to avoid this problem, we must use the function `assertEquals(message, double actual, double expected, double delta)` where `delta` is the difference that we accept between the `actual` and `expected` values.

2. assertEquals() Asserts that two objects are equal. assertSame() Asserts that two objects refer to the same object

3. We can fail a test when it is incomplete or not yet implemented:
```java
@Test
public void incompleteTest() {
    fail("Not yet implemented");
}
```

4. When we use the annotation `@Test`, we can't figure out which instruction throws the IllegalArgumentException. And `Assertions.assertThrows` also returns the exception object to execute further asserts, e.g. to assert the message.
