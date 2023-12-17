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
# 1.

# isValidDate()
Dans le cours on définis le partitionning des dates tel que:
![img](/exercises/date_partion_isvalid.png)

On peut donc définir 6 cas de test :

|Day|Month|Year|
|:--|:--|:--|
| 1|1|-1|
| -1|-1|0|
| 0 |4 |2020|
| -2|0 |2019|
| 29 |2 |2019|
| 0 |13 |2018|



# isLeapYear()

cette fois on défini le tableau:

|caractéristique|b1|b2|
|:--|:--|:--|
| c1 : years%4 = 0|vrai|faux|
| c2 : years%100 = 0|vrai|faux|
| c3 : years%400 = 0 |vrai |faux|

ce qui donne les cas: 

|caractéristique|b1|b2|
|:--|:--|:--|
| c1 : years%4 = 0|4|5|
| c2 : years%100 = 0|100|104|
| c3 : years%400 = 0 |400 ||

# compareTo()

|caractéristique|b1|b2|b3|b4|
|:--|:--|:--|:--|:--|
| c1 |< 0| = 0 | > 0|error|

on peut tester sur : 

|caractéristique|b1|b2|b3|b4|
|:--|:--|:--|:--|:--|
| c1 |date(1,1,1) | date(12,5,2012)  | date(31,12,2020) | date(1,1,1) |
|  |other(31,12,2020)| other(12,5,2012) | other(1,1,1) |null|

# nextDate() et previousDate()

pour nextDate()

|caractéristique|b1|b2|
|:--|:--|:--|
| c1 = dernier jour du mois | vrai | faux |
| c1 = dernier jour de l'année | vrai |  |

soit : 

|caractéristique|b1|b2|
|:--|:--|:--|
| c1 = dernier jour du mois | 31/7/2002 | 25/4/1945 |
| c1 = dernier jour de l'année | 31/12/2012 |  |

Et pour previousDate()

|caractéristique|b1|b2|
|:--|:--|:--|
| c1 = premier jour du mois | vrai | faux |
| c1 = premier jour de l'année | vrai |  |

soit 

|caractéristique|b1|b2|
|:--|:--|:--|
| c1 = premier jour du mois | 1/6/45 | 13/8/1225 |
| c1 = premier jour de l'année | 1/1/3001 |  |


Les caractéristiques `day`, `month` et `year` sont commun au méthodes `isValidDate()`, `nextDate()`, `previousDate()` et `compareTo()`.
Dans le cas de `year` il est aussi utilisé par `isLeapYear()`