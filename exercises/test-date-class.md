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

1. *Input Space Partitioning*

Here is the insput space partitionning we have done for the method isValidDate().


|Characteristics|Blocks|
|---------------|---------|
|               |   `B1` -  `B2`  -  `B3`  -  `B4`  -  `B5`  -  `B6` |
|`q1`. Value of year |<0 - 0 - valid leap year - valid common year - none - none |
|`q2`. Value of month|<0 - 0 - {1, 3, 5, 7, 8, 10, 12} - {4, 6, 9, 11} - 2 - >12 |
|`q3`. Value of day  |<0 - 0 - >=1 and <=max(month,year) - >max(month,year) - none - none |


The following set of inputs `tries` to achieve ECC coverage. 

|Input|Blocks|
|---------------|---------|
| { day: 1, month: 1, year: -1} | Q1B1 - Q2B3 - Q3B3|
| { day: -1, month: -1, year: 0} | Q1B2 - Q2B1 - Q3B1|
| { day: 0, month: 4, year: 2020} | Q1B3 - Q2B4 - Q3B2|
| { day: -2, month: 0, year: 2019}  | Q1B4 - Q2B2 - Q3B1|
| { day: 29, month: 2, year: 2019} | Q1B3 - Q2B5 - Q3B4|
| { day: 0, month: 13, year: 2018} | Q1B4 - Q2B6 - Q3B2|

2. Statement Coverage.

At first we had a pretty low coverage because our code id done in a way that id some characteristic is detected wrong it'll return false before mesuring the others.

To make out test coverage better we added some tests trying to go to the statements wich have not be used yes by the test suite.And as wanted we descovered a bug in our implementation and added a test to make sure it'll not appear again.

3.We have separated in the code each boolean statement so we always evaluate them one by one.

4. >TODO
