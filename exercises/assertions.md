# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer


1. Assertions on doubles or floats shouldn't use the == operator to compare values. Instead they should compare the difference of the two numbers to a delta that is close to 0 (ex: 0.001).

2. assertEquals() verifies that two values of whatever we ask it to compare with the equals() method and assertSame() uses the == operator and checks that both the objects that we passsed refer to the same object.

Scenarios:
same result:
```
x = 1
y = x
assertEquals(x, y) // test passes
assertSame(x, y) // test passes
```


different result:
```
x = 1
y = 1
assertEquals(x, y) // test passes
assertSame(x, y) // test fails
```


3. Other uses for 'fail': fail can be coupled with a timmeout part of a test and fail it if the time is exceeded, it's a workaround the timeout defined before the tests.
ex: 
```
if ( !latch.await(5, TimeUnit.SECONDS) ) {
    fail("No response after 5s");
}
```

4. The assertThrows() function is more concice and clean than adding the thrown exception in a `@Test` as well as allowing us to test multiple exceptions within the same test so the number of lines needed is reduced. It provides support from lambda functions making it even more concice if necessary.

