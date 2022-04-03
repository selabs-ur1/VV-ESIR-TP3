# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

---
**Student**  
<table align="left">
<tr>
  <th> First Name </th>
  <th> Last Name </th>
  <th> @Mail adress </th>
</tr>
<tr>
  <td> Léo </td>
  <td> Thuillier </td>
  <td> leo.thuillier@etudiant.univ-rennes1.fr </td>
</tr>
<tr>
  <td> Thibaut </td>
  <td> Le Marre </td>
  <td> thibaut.le-marre@etudiant.univ-rennes1.fr </td>
</tr>
</table>
<br><br><br><br><br><br>

---


1. We are trying to compare the values of two doubles, and we know that there are a number of comma values that are not representable for a computer, given the result of the test this is surely the case for the number 1,2. 

To be able to compare these two values, we need to introduce a tolerance to this approximation. By calculation this difference is : 2.220446049250313E-16

To resolve this bug the test should be writen like this :
```java
assertEquals(3 * 0.4, 1.2, 10E-16);
```

---

2. Difference between assertSame() & assertEquals()

- assertSame() checks the object reference using the == operator.

- assertEquals()
  - If primitive values are passed and then the values are compared.
  - If objects are passed, then the equals() method is invoked. 

Scenarios :
```java
    BigDecimal d1 = new BigDecimal("1.0");
    BigDecimal d2 = new BigDecimal("1.0");
    BigDecimal d3 = d1;
```
- Same Results

```java
@Test
    public void SameResult() {
        assertSame(d1,d3);
        assertEquals(d1,d3);
    }
```

- Different Results

```java
@Test
    public void DiffResult() {
        assertEquals(d1,d2);
        assertNotSame(d1,d2);        
    }
```
---

3. fail() uses
We can call fail() when a result doesn't meet some desired condition:
```java
@Test
public void testingCondition() {
    int result = randomInteger();
    if(result > Integer.MAX_VALUE) {
        fail("Result cannot exceed integer max value");
    }
}
```

We can also fail a test when the code doesn't return/break when expected:
```java
@Test
public void returnBefore() {
    int value = randomInteger();
    for (int i = 0; i < 5; i++) {
        // returns when (value + i) is an even number
        if ((i + value) % 2 == 0) {
            return;
        }
    }
    fail("Should have returned before");
}
```

---

4. Exceptions for JUnit4 & JUnit5

- JUnit 4 uses @Test(expected = InterruptedException.class).
- JUnit 5 uses an assertion with the code in a closure lambda expression, which allows additional assertions to be made on the exception.
