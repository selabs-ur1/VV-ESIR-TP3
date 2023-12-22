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
4. Use PIT t
o evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Use the project in [tp3-date](../code/tp3-date) to complete this exercise.

## Answer

#### 1. 

1. **Méthode : `Date` (constructeur)**
   - Caractéristiques :
     - Jour valide, mois valide, année valide.
     - Jour invalide, mois invalide, année invalide.
   - Caractéristiques communes avec `isValidDate` et `nextDate` : Jour valide, mois valide, année valide.
   - Caractéristiques communes avec `isLeapYear` : Année valide.

2. **Méthode : `isValidDate`**
   - Caractéristiques :
     - Jour valide, mois valide, année valide.
     - Jour invalide, mois invalide, année invalide.

3. **Méthode : `isLeapYear`**
   - Caractéristiques :
     - Année bissextile.
     - Année non bissextile.

4. **Méthode : `nextDate`**
   - Caractéristiques :
     - Date avec jour valide, mois valide, année valide.
     - Date avec le dernier jour de l'année.
     - Date avec le dernier jour d'un mois.
     - Date avec le dernier jour de février (non bissextile).
     - Date avec le dernier jour de février (bissextile).

5. **Méthode : `previousDate`**
   - Caractéristiques :
     - Date avec jour valide, mois valide, année valide.
     - Date avec le premier jour de l'année.
     - Date avec le premier jour d'un mois.
     - Date avec le premier jour de mars (non bissextile).
     - Date avec le premier jour de mars (bissextile).

6. **Méthode : `compareTo`**
   - Caractéristiques :
     - Dates identiques.
     - Date 1 antérieure à Date 2.
     - Date 1 postérieure à Date 2.

#### 2.

- J'ai ajouté des cas de test pour chaque caractéristique identifiée, en veillant à couvrir chaque branche du code. J'ai vérifié que chaque ligne de code était exécutée au moins une fois.

#### 3. 

- Les prédicats dans le code n'utilisent pas plus de deux opérateurs booléens, donc la Base Choice Coverage est déjà satisfaite avec les tests existants. Aucun ajout de test n'était nécessaire dans ce cas.

