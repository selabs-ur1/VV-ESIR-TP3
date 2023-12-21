# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. ## **Assertion `assertTrue(3 * .4 == 1.2)` fails: Why?**

> The assertion assertTrue(3 * .4 == 1.2) fails because of floating-point precision errors. When floating-point numbers are represented in binary, some decimal numbers cannot be accurately represented. In this case, the result of 3 * .4 is not exactly 1.2 due to the limited precision of floating-point arithmetic. To perform this type of check, it is recommended to use the assertEquals method with a tolerance value to account for the precision errors. For example, assertEquals(1.2, 3 * .4, 0.0001).

2. ## **difference between `assertEquals` and `assertSame`:**

> The assertEquals method is used to compare the values of two objects or primitive types. It checks if the values are equal based on their content. On the other hand, the assertSame method is used to check if two objects refer to the same instance. It checks if the object references are the same.

> Scenarios where they produce the same result:
>* When comparing primitive types like int, char, etc.
>* When comparing objects that have overridden the equals method to compare their content.

> Scenarios where they do not produce the same result:
>* When comparing different instances of the same object. assertEquals will consider them equal if their content is the same, while assertSame will consider them different.
>* When comparing objects that have not overridden the equals method. assertEquals will compare the references, while assertSame will compare the content.

3. ## **other uses for `fail` :**

>The fail method in JUnit is not only used to mark code that should not be executed because an exception was expected before. It can also be used to mark code that should not be reached under normal circumstances, such as in unreachable branches or as a placeholder for incomplete code.
>
>Use case example:
``` Java
public void calculateTotalPrice(int quantity, double price) {
    if (quantity <= 0) {
        fail("Invalid quantity!");
    }
    
    if (price <= 0.0) {
        fail("Invalid price!");
    }
    
    double totalPrice = quantity * price;
    System.out.println("Total Price: " + totalPrice);
}
```

4. ## **The advantage of using the `assertThrows` :**

> The advantage of using the assertThrows method in JUnit 5 is that it provides a clear and explicit way to check for expected exceptions. With the @Test annotation in JUnit 4, the expected exception was declared using the expected attribute, which could lead to the test passing even if the exception was not thrown.
>
>  By using assertThrows, the test explicitly states that an exception is expected, and the test will fail if the exception is not thrown. It provides better clarity and avoids false positives where the test passes even when an exception is not thrown. Additionally, assertThrows allows for more flexibility in asserting the type of exception thrown and performing further assertions on the exception itself.
