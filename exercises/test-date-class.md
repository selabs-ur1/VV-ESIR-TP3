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


1. Use input space partitioning

In order to select a good test set, we used the input space partitioning method.
The reference we are using for this kind of problem is https://oscarlvp.github.io/vandv-classes/#_input_space_partitioning, and because the example used in this document is exactly the same as the one we are trying to solve, we will use the same characteristics and blocks.

|Characteristics    |   |Blocks |       |       |       |       |       |
|-------------------|:--|:------|:------|:------|:------|:------|:------|
|                   |   |b1     |b2     |b3     |b4     |b5     |b6     |
|q1                 | Value of year |  <0   |  0   |  valid leap year   |valid common year | NA | NA
|q2                 | Value of month |  <0   |  0   |  { 1, 3, 5, 7, 8, 10, 12}   |{ 4, 6, 9, 11 } | 2 | > 12
|q3                 | Value of day |  <0   |  0   |  >= 1 and <= max(month, year)   |> max(month, year) | NA | NA

The block B1 correspond to a negative value in the inputs. </br>
The block B2 correspond to a zero value in the inputs. </br>
The block B3 correspond to a valid leap year. </br>
The block B4 correspond to a valid common year. </br>
The block B5 correspond to February, which has 28 days in common years and 29 days in leap years. </br>
The block B6 correspond to a value greater than the maximum value of the month or year. </br>
 </br>

The Q1 characteristic correspond to the value of the year. </br>
The Q2 characteristic correspond to the value of the month. </br>
The Q3 characteristic correspond to the value of the day. </br>
 </br>

Each of these characteristics are relative to more than one method, because they are parameters of several methods and influence the result of those methods. </br>
 </br>

Then we created our tests for each characteristic by following the above table, for methods using that characteristic. </br>
 </br> 

2.
We reused the jacoco plugin from the previous exercise to evaluate the statement coverage.
For the designed tests, the coverage is only of 46%, because 114 of 214 instructions are missed. </br>
This was because we at first forgot to apply the partitionning to every function needing it and only did it for one of them. </br>
 </br>
 After correcting our partitionning, our coverage is now of 100% for the statements, without having to do any other test. </br>

 3.
 By checking the jacoco report, we can see that the coverage is of 100% for the branches (with 0 missed branches). </br>
It shows that we are pretty close to satisfying the Base Choice Coverage. However, we are missing some tests, for example for the isLeap year function wich has a predicate with 3 boolean operators. </br> 

 4.
 By using the command `mvn clean install` and `mvn org.pitest:pitest-maven:mutationCoverage`, we can see that our mutation score is of 91% with 41 of 45 mutations killed. </br>
We added boundary tests in the nextDate and previousDate functions in order to cover the missed mutations. </br>

For these functions, ```<``` were replaced by ```<=```, so it was needed to test specific values for the boundary tests. </br>