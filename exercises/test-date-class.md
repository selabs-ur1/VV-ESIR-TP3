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

1.IsValidDate
|   | b1 | b2 | b3 | b4 | b5 | b6 |
| :---------------: |:---------------:| :-----:| :-----:| :-----:| :-----:|:-----:|
| Jour  |   <0 |  0 | >= 1 and <= max(mois,année) | >max(mois,année)| | |
| Mois |<0 |  0  |   { 1, 3, 5, 7, 8, 10, 12}  | { 1, 3, 5, 7, 8, 10, 12} | 2 | > 12 |
| Année  | <0 |  0  |   année bissextile  | année commune |  |  |
  
IsLeapYear
|   | b1  | b2 | b3 |
| :---------------: |:---------------:| :-----:| :-----:|
| Années   |   Année bissextile       |  Année non bissextile |  <0 |
  
  NextDate
|   | b1          | b2 | b3 |
| :---------------: |:---------------:| :-----:| :-----:|
| Date |   31 Décembre      |  31 mois classique  | Date classique |
  
  PreviousDate
|   | b1          | b2 | b3 |
| :---------------: |:---------------:| :-----:| :-----:|
| Date |   1er Janvier      |  1er mois classique  | Date classique |
  
  CompareTo  
|  | b1 | b2 | b3  | b4 |
| :---------------: |:---------------:| :-----:| :-----:|  :-----:|
| Dates | 2 dates identiques | 2 dates dans le même mois | Même année mais mois différents | Années différentes |
  
  
2. Nous obtenons une courverture de test de 80%. Pour augmenter notre couverture de test, nous avons ajouté des tests pour les NullPointerException dans le cas où la date est null. Nous nous sommes rendu compte que nous n'avions pas testé le cas de changement de jour lors d'une année bissextile, nous avons donc rajouté les cas de test correspondants. Maintenant, notre couverture de test est de 100%.

3. Nous n'avons pas de cas où nous avons plus de 2 opérateurs booléens.  
  
4. Après avoir utililsé PIT, nous obtenons une couverture de mutation de 94% avec 4 mutants qui ont survécu. Ce score est dû à la mutation "changed conditional boundary" qui, par exemple, change les '<' en '<='.  
Exemple : if (year < 1) {return false;} , ici le mutant peut transformer l'opération en : year <= 1.
En ajoutant des cas de tests pour les utilisations de ces opérateurs nous obtenons un score de 100%.


