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

1. For the input space parittionning, with the help of the textbook provided with the course, we decided to use this as an input space for isValidDate and for the constructor:

|                         | b1          | b2                          | b3                        | b4          | b5          |
| ----------------------- | ----------- | -----------                 | -----------               | ----------- | ----------- |
| q1       Value of year  | <=0         |  leap year                  | common year               |             |             |
| q2       Value of month | <=0         |  {1,3,5,7,8, 10, 12}        |  { 4, 6, 9, 11}           |  2          |  >12        |
| q3       Value of day   | <=0         | >= 1 and <=max(month,year)  |  >max(month,year)         |             |             |

For the function isLeapYear, we decided to take inputs that are either leap year or non leap year depending if the date is divisible by 4, divisible by 100 and divisible by 400.

For the compareTo method, the input space that we chose was 4 different cases, one where "this" is posterior to "other",anterior,equal and then when other is null.
Since the methood compareTo has been tested we can now use it to test nextDate and previousDate.

For the method nextDate, we decided to take inputs that makes an impact on other parameters so:
|                         | b1                     | b2           | b3           |
| ----------------------- | -----------            | -----------  | ------------ |
| q1       Value of year  | leap year              | common year  |              |
| q2       Value of month | last month of the year | common month | February     |
| q3       Value of day   | last day of the month  | common day   |              |

Quite similarly to the method previousDate, we used this input for the method previousDate:
|                         | b1                      | b2           | 
| ----------------------- | -----------             | -----------  | 
| q1       Value of year  | leap year               | common year  | 
| q2       Value of month | first month of the year | common month |
| q3       Value of day   | first day of the month  | common day   | 

2. I used the jacoco maven plugin to run the test coverage and obtained 100%, I've put a screenshot of the coverage in the code folder.

3. Same as the previous question, jacoco checked the coverage of the branches in the "boolean lines" and did not find any not covered branches.

4. When I first used the pit plugin, I got a mutation scrore of 90%, but some of it was due to the fact that I had not tested my getters .Other that that I had three mutants that survived, I eliminated two of them by adding two new tests that tested isValidDate with an input day of 0 and an input month of 0. And I eliminated the last one by changing one condition in the method nextDate by replacing this.year+1>12 by this.year==12. The mutant had modified the > by >= but the behhavior was'nt changing.

