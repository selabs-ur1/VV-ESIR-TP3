# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The assertion fails because of the floating point precision. The result of the multiplication is not exactly 1.2. To solve this problem we can set an accepted margin of error.

For this example:
```java
assertTrue(Math.abs(3 * .4 - 1.2) < 0.0001);
```
Or we can use the `assertEquals` method with a margin of error:
```java
assertEquals(1.2, 3 * .4, 0.0001);
```

2. `assertEquals` compares the values of two objects, while `assertSame` compares the references of two objects. They produce the same result when comparing primitive types, but not when comparing objects.

3. Fail can also be used to mark a test that hasn't been implemented yet. It's like a TODO for tests wich raises an error when the test is executed.

4. The new way of checking expected exceptions is more readable and it's easier to use.
We don't have to catch exceptions manually anymore in order to check if the test is passing or not.

------------------------------
------------------------------
Authors:
- Baptiste AMICE
- Ulysse-Néo LARTIGAUD
