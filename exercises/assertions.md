# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The assertion `assertTrue(3 * .4 == 1.2)` because we are checking here the value of floating values. Indeed, comparing floating with `==` is not precise enough : there will be a small difference. A way to fix that is to use `Float.compare(Float f1, Float f2)` instead of `f1 == f2`. If the result of it is 0, it means that the floats are equals.

2. `assertEquals` checks if two objects are equals while `assertSame`checks if two objects refer to the same object. A scenario where `assertEquals` and `assertSame` could be for example if we are creating two instances of a same class (v1 and v2). Of course, the class should have a `equals` function. We are initializing the two instances to the same values. If we are doing the assertion on them, the `assertEquals` will succeed because they have the same value meanwhile the `assertSame` will fail because they are not refering to the same object as they are two different instances of the class.

3. The first use of `fail` in Junit is to mark code that should not be executed because an exception was expected before. But another use of this type of test is to check if in certain conditions, the class is well throwing an assertion and is not still running. Example : 
``` java  

@Test
public void expectedException() {
    try {
        methodThrowsException();
        fail("Expected exception was not thrown");
    } catch (Exception e) {
        assertNotNull(e);
    }
}

```

Like that, if the `methodThrowsException` isn't thrwoing any Exception, then it encounter the fail statement making the test fail while if it is throwing an Exception, it will go to the catch section and the `assertNotNull(Exception)` will succeed so the test will succeed.

4. In Junit5, we are using `assertThrows` instead of `@Test` used in Junit 4 to check if an assertion is well thrown. The adventages of this new way to check expected assertions is to check different types of Exceptions that are thrown. Indeed, we may want to check the type of Exceptions that is thrown. With that, if there is no Exception, the test will fail, if there is an Exception but of the wrong type, the test will fail and the only way for the test to succeed is to throw the right Exception.
