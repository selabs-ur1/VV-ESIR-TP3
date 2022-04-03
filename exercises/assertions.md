# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. This assertion fails because it tries to find 2 equal float numbers, but there can be a really small difference when multiplicating 0.4 by 3, resulting in a number different from 1.2. To make a good assertion on this type of check, it is better to use `assertEquals(actual, expected, delta)` where delta is a float value describing the precision needed to accept the test or not. It can mitigate these types of differences between a multiplied float and the expected value of it.

2. `assertEquals` uses the method `equals()`, which means if primitive values are passed, it will compare them, but if objects are passed, it will check if both objects are the same object. `assertSame` checks if both objects are in fact the same object by using `==` on references. 
Scenarios`
```
String s1 = new String("yes");
String s2 = new String("yes");
assertEquals(s1,s2); // this test passes
assertSame(s1,s2);   // this test fails

assertEquals("yes","yes"); // this test passes
assertSame("yes","yes");   // this test passes
```

3. `fail` can be used when you test a method which can return within a loop. Placing the `fail` after the loop can prevent the test from being validated even though it didn't return at the right time.

```
Random ran = new Random();
int x = ran.nextInt(6);
for(int i = 0; i < 5; i++) {
    if(x+i % 2 == 0) return;
}
fail("Should have returned in the loop");
```

4. The advantage of `assertThrows` is that it can be used for specific parts of a test method, in contrary to the Junit 4 way.

