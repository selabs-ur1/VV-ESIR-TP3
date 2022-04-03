# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer
Jugieau Barthelat

1.
When calculating 3* .4, there is a small degree of uncertainty. 3* .4 is computed as 1.00…002 and as such it is considered different from 1.2. The correct way to do this check is by using assertEquals(3*.4, 1.2, precision). In our case, precision can be equal to 0.0000001 for example.
	
2.
assertEquals return True if the address of the two parameters are the same while assertSame return True if the content of the two parameters are the same.

Same results Scenario:
String a=”sameContent”;
String b=a;

assertEquals(a,b) = True = assertSame(a,b)
Because a and b point to the same memory area, and the content of a is the same as b.

Different results Scenario:
String a=”sameContent”;
String b=”sameContent”;

assertEquals(a,b) = False != True = assertSame(a,b)
Because a and b point to different addresses even if their contents are the same.

3.
Fail can be used to test a precondition. For example, sometimes a value ends up being greater or lower than what it is allowed to be, by using fail to test those conditions, the test won't go any further and we will know an impossible situation has happened.

To test a new part of the code to see if it works, we can make it fail after. If the test fails due to that line, the code before works, and a potential error does not interfere with the rest of the tests.


4.
assertThrows(executable) returns an exception if one happens when executing the parameter. Moreover, a parameter can be used to define the type of exception we want : if there is no exception or one of the wrong type, the assertion fails. This can be used to verify that a situation fails when it should, for example, if a number is too big.


