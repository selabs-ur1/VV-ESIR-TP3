# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

### 1. `assertTrue(3 * .4 == 1.2)` failure

That is because of the float approximation. In fact, when we are executing this calculation in a code, we obtain : ``1.2000000000000002``.

This type of check should be done differently. We can consider that two floats are equal if their difference is negligible. To compare two floats with a tolerance error, we can use ``assertEquals(double expected, double actual, double delta)`` from JUnit.

### 2. Difference between `assertEqual` and `assertSame`

- ``assertEqual`` : verify if two objects have the same value.
- ``assertSame`` : verify if two objects are the same according to their reference.

PUT EXAMPLE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

### 3. Other uses for `fail`

Modify a file without having the writing rights ? => maybe a try/catch is better

Too much memory used

PUT EXAMPLE !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!


### 4. `assertThrows` advantages compared to `@Test`

We can do things before and after each test case with @Before and @after respectively. That was not the case before and could be useful to (clarify ??) the code.  