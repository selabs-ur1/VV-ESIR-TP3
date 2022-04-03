# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. This assertion fails because the result of 3 * 0.4 is an approximation and not exactly 1.2. This type of check should be done with assertEquals(3 * .4, 1.2, 0.00001) to take into consideration the approximation of double computing.

2. assertEquals verify that 2 objects are equals by using .equals and assertSame verify that 2 objects point to the same objects.
A scenario where assertSame and assertEquals will produce the same result is if we create 2 instance of a class with the same values where the equals method isn't implemented and we use these 2 assertions, both will fail. But if we implement the equals method, assertEquals will pass but not assertSame because they are 2 different object with the same value but they're still not the same object.

3. It can be used to mark a test that's not yet completed, it can also be used to test a condition for exemple :
@Test
public void testingCondition() {
    int result = randomInteger();
    if(result > Integer.MAX_VALUE) {
        fail("Result cannot exceed integer max value");
    }
    // more testing code
}
to test if an integer isn't superior to the max value of an integer.

4. This new way of checking expected exceptions allows to check exactly where in the code we expect this exception. 