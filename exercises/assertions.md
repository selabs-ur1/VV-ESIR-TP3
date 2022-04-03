# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. The assertion fails because of the approximation of float computing. In that case, we need to use an AssertEquals with a tolerance parameter. For example, it could be written like that : 
```java
AssertEquals(expected,actual,tolerance)
```
2. assertEquals: uses the equals() method, or if no equals() method was overridden, compares the reference between the 2 objects.

assertSame: compares the reference between the 2 objects.
```java
public class SomeClass {

private int i;

public SomeClass(int param){
	this.i = param;
}

}

SomeClass s1 = new SomeClass(2);
SomeClass s2 = new SomeClass(2);

assertEquals(s1,s2);
assertSame(s1,s2);
```
In this case, equals() is not overridden so both assertions will fail because both objects do not have the same reference. 

```java
public class SomeClass {

private int i;

public SomeClass(int param){
	this.i = param;
}
}
public class main {

	private int i;
	public main(int param) {
		this.i = param;
	}
	
	public int getI() {
		return i;
	}

	public void setI(int p) {
		this.i = p ;
	}
	
	@Override
    public boolean equals(Object o){

        // self check
        if(this == o){ return true; } else

        // null check
        if(o == null){ return false;} else

        // type check and cast
        if(getClass() != o.getClass()){ return false; } else {
            final main tmp = (main) o;
            // field comparison
            return Objects.equals(this.getI(), tmp.getI());
        }
    }
}


SomeClass s1 = new SomeClass(2);
SomeClass s2 = new SomeClass(2);

assertEquals(s1,s2);
assertSame(s1,s2);
```
