# Test the Date class

Implement a class `Date` with the interface shown below:

```java
class Date implements Comparable<Date> {

    public Date(int day, int month, int year) { ... }

    public static boolean isValidDate(int day, int month, int year) { ... }

    public static boolean isLeapYear(int year) { ... }

    public Date nextDate() { ... }

    public Date previousDate { ... }

    public int compareTo(Date other) { ... }

}
```

The constructor throws an exception if the three given integers do not form a valid date.

`isValidDate` returns `true` if the three integers form a valid year, otherwise `false`.

`isLeapYear` says if the given integer is a leap year.

`nextDate` returns a new `Date` instance representing the date of the following day.

`previousDate` returns a new `Date` instance representing the date of the previous day.

`compareTo` follows the `Comparable` convention:

* `date.compareTo(other)` returns a positive integer if `date` is posterior to `other`
* `date.compareTo(other)` returns a negative integer if `date` is anterior to `other`
* `date.compareTo(other)` returns `0` if `date` and `other` represent the same date.
* the method throws a `NullPointerException` if `other` is `null` 

Design and implement a test suite for this `Date` class.
You may use the test cases discussed in classes as a starting point. 
Also, feel free to add any extra method you may need to the `Date` class.


Use the following steps to design the test suite:

1. With the help of *Input Space Partitioning* design a set of initial test inputs for each method. Write below the characteristics and blocks you identified for each method. Specify which characteristics are common to more than one method.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written to far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

1. At first, we know that the input domain is all the combination of 3 ints so we will cut this with different blocks of int triplet. 
We started by the interface-based approach and we could write test cases with null inputs but eclipse IDE doesn't allow calling methods with null inputs. 
So we choose to put some zero into inputs. We test the date ( 0,0,0) with the method isValidDate() and it returns true instead of false. In fact we used a <0 instead of a <=0 in the first if statement. We decided to throw an exception if a wrong date is trying to be created. So we write a test case to verify if this exception is throwed. 
	We also write some tests with the functionality based technique. We test each method by changing only the day, the month or the year. We also test them with complex dates like 31th december or 29th february during a leap year. 
2. Then we evaluate the test coverage with the coverage plugin of Eclipse and we reach a 87% coverage rate. So we have checked which lines or branches were not reached. We add tests to create complex dates like 29th february, 30th and 31th during leap year and normal year. We have managed to reach 98,1% of coverage. 
3. We have many predicate with 2 booleans operator by there are already tested with the test cases added previously
4. We now run PIT on our project and we reach 90% of mutation coverage. It stills 10 mutants alive. At this time, we add test cases to kill the mutant from compareTo. In fact, we test with post and anterior year, month and day. But we still have some alive mutants with the isValidDate method. 
