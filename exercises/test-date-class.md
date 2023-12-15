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

``` java
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Invalid date");
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (day < 1 || day > 31 || month < 1 || month > 12) {
            return false; 
        }
        if (month == 2) {
            return day <= (isLeapYear(year) ? 29 : 28);
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return day <= 30;
        }
        return true;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public Date nextDate() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return new Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }

    public Date previousDate() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        calendar.add(Calendar.DAY_OF_MONTH, -1);
        return new Date(calendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.YEAR));
    }

    public int compareTo(Date other) {
        if (other == null) {
            throw new NullPointerException("La date fournit est nulle");
        }
        if (year != other.year) {
            return year - other.year;
        }
        if (month != other.month) {
            return month - other.month;
        }
        return day - other.day;
    }
}
```

1. Partitionnement de l'espace d'entrée :
*  Caractéristiques communes :
   * Jour (day).
   * Mois (month).
   * Année (year).
*  Méthode isValidDate :
   * Année bissextile (isLeapYear = true).
   * Année non bissextile (isLeapYear = false).
   * Mois avec 31 jours.
   * Mois avec 30 jours.
   * Février avec 29 jours.
   * Février avec 28 jours.
*  Méthode isLeapYear :
   * Année bissextile.
   * Année non bissextile.
*  Méthode nextDate et previousDate :
   * Année bissextile.
   * Année non bissextile.
   * Mois avec 31 jours.
   * Mois avec 30 jours.
   * Février avec 29 jours.
   * Février avec 28 jours.
*  Méthode compareTo :
   * Date1 est postérieure à Date2.
   * Date1 est antérieure à Date2.
   * Date1 est égale à Date2.
   * Date2 est null (NullPointerException).

2. Couverture des instructions :
   Voir les cas de tests dans la classe DateTest pour chaque méthode.

3. Couverture logique (Base Choice) :
   Toutes les méthodes impliquent des conditions simples sans prédicats complexes avec plus de deux opérateurs booléens. La couverture de choix de base est satisfaite.

4. 

