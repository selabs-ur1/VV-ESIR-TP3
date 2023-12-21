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

1.

| Characteristics|  Blocks |          |                              |                    |   |    |     |
|:---------------:|:------:|:--------:|:----------------------------:|:------------------:|:-:|:--:|:---:|
| Value of year  | <0      | 0        | valid yeap year              | valid common year  |   |    |     |
| value of month | <0      | 0        | { 1, 3, 5, 7, 8, 10, 12}     | { 4, 6, 9, 11 }    | 2 | >12|     |
| value of day   | <0      | 0        | >= 1 and <= max(month, year) | > max(month, year) |   |    |     |
| Date           | null    | valide   |                              |                    |   |    |     |


les blocks de chaque methode :

isValideDate : tous les blocks\
isLeapYear : annee bissextile et annee normal\
is31Day : ligne value of month\
nextDate/previousDate : tous les mois et jours valide\
Compareto :  ligne Date et toutes dates valide

2. Dans cette partie, j'ai écris des tests afin de couvrir les differents blocks de chaque fonction. Apres avoir fais un test de couverture, j'obtiens un score de 93%. Il n'y a donc pas besoin d'ajouter de tests.

3. Dans mon code, je n'ai que deux predicats utilisant plus de 2 booleans et qui ont deja ete couvert par les tests.

4. Apres avoir utilise PIT, j'obtiens un score de mutation de 80%. L'une des plus grosse source de mutant est le faite que les mois alternes entre 30 et 31 sauf pour juillet, aout et fevrier. De ce faite, dans la plupart du temps la condition pour verifier si le mois d'avant possede 31 jours donne le meme resultat lorsque l'on regarde le mois d'apres. Pour le tuer, il suffit rajouter un test en utilisant un mois comme Juillet par exemple. Grace a cela, on obtient maintenant un score de mutation de 84%.