# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The assertion fails because of floating-point precision. In that case, the value of `3 * .4` should be `1.2`, but the result might look like `1.200000000...` or `1.99999999...`.
This type of check should e done with assertEquals method by specifying the Delta we are looking for.

2. `assertEquals` method will compare two object by using the `equals` method. `assertSame` method check if two objects refer to the same memory location.
If we use both method to check primitive value, they will both check for value equality: 
```java
int a = 5;
int b = 5;
assertEquals(a,b);
assertSame(a,b);
```
When comparing objects, results won't be the same: 
```java
String a = new String("Hello World");
String b = new String("Hello World");

assertEquals(a,b) // It pass, because the equals method will check values
assertSame(a,b) // It fail, memory locations aren't the same
```

3. `fail` could be used to mark unreachable code like in the exemple below :
```java
if (a>0){
...
}
else if (a==0){
...
}
else{
fail
}
```

4. AssertThrows allow to catch the exception value and operate on it