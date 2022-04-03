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
Jugieau Barthelat

1.
The methods isValidDate, isLeapYear and the constructor should all be tested by our other methods.
We do implement 2 basic Tests for isValidDate, a date that should work and one that should not.

nextDate :
A generic date : 1, 1, 2000
The end of a 30 days long month : 30, 4/6/9/11, 2000
The end of a 31 days long month that isn’t december : 31, 1/3/5/7/8/10, 2000
The end of December : 31, 12, 2000
The end of February on a leap year (tested with a multiple of 400 and a generic multiple of 4) : 29, 2, 2000/2016
The usual end of February (tested with a generic year and a multiple of 100 and 4) : 28, 2, 1900/2001

previousDate :
A generic date : 2, 1, 2000
Previous month is 30 days long : 1, 5/7/10/12, 2000
Previous month is 31 days long and not december : 1, 2/4/6/8/9/11, 2000
Previous month is December : 1, 1, 2000
Previous month is February on a leap year (tested with a multiple of 400 and a generic multiple of 4) : 1, 3, 2000/2016
Previous month is February on a usual year (tested with a generic year and a multiple of 100 and 4) : 1, 3, 1900/2001

compareTo : 
2 equal dates
year1<year2
year1==year2 but month1<month2
year1==year2 && month1==month2 but day1<day2
year1>year2
year1==year2 but month1>month2
year1==year2 && month1==month2 but day1>day2


2. and 3.

We have an instruction coverage of 95% and branch coverage of 88%.
We missed one instruction and branch in compareTo about the other==null condition.
We add a compareTest with a null Date → 100% coverage

The constructor and isValidDate method are missing a lot more. We never tried to create an incorrect date, never verified a date with a wrong month and branches are missing for the validMonth and validDay conditions.

We replaced the isValidDate tests with Constructor Tests (which uses isValidDate)
We added a Constructor test with a wrong month.

There are now only 2 missing branches : month >13 and day < -1 which can be quickly implemented.
The coverage is now 100%.

4.
There are 3 survivors, all are a Conditional Boundary change.
One is on “ if (d+1 > finMois) “ in nextDate
Two are in isValidDate :
boolean validMonth = month > 0 && month < 13;
boolean validDay = day > 0 && day < nbMaxOfDays(day,month,year) + 1 ;

isValidDate is one of the base methods that everything builds on, so modifying a line here would let the incorrect date be created.
The validMonth line for example may allow a month of 13 to pass, however the extreme values are special cases which are treated differently, the 13th month would fall into the else category and be treated as having 31 days for nextDate for example. The only time I ever test a month value too high is with the constructor, which directly relies on isValidDate. As such the error slips by.
The validDay line is in a similar situation.

Perhaps the survivor in nextDate can be explained by the fact that I only ever use either the last day of the month or the first one, d+1 is therefore always greater (or much smaller) than the end of the month.




