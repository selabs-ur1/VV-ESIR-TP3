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

### 1. Input Space Partitioning

Pour le constructeur :
- Jour du mois entre 1 et 31
- Mois entre 1 et 12
- Année positive

Pour isValidDate() :
- Jour du mois entre 1 et 31
- Mois entre 1 et 12
- Année positive
- Gestion des années bissextiles

Ces deux méthodes partagent les caractéristiques de plage de jour et de mois.

Pour isLeapYear() :
- Année divisible par 4 mais pas par 100
- Année divisible par 400

Pour nextDate() :
- Incrémentation du jour
- Passage au mois suivant si jour dépasse 31
- Passage à l'année suivante si mois dépasse 12

Pour previousDate() :
- Décrémentation du jour
- Passage au mois précédent si jour passe en dessous de 1
- Passage à l'année précédente si mois passe en dessous de 1

Pour compareTo() :
- Comparaison d'années
- Comparaison de mois si années égales
- Comparaison de jours si années et mois égaux

#### isValidDate / constructeur

La méthode a 3 paramètres testables.

- Pour les jours, les valeurs normales vont de 1 à 31. Une valeur particulière à tester est le 29 février. Les valeurs limites sont donc 0, 32 et une valeur négative comme -1.
- Pour les mois, les valeurs normales vont de 1 à 12. Les limites sont 0, 13 et -1.
- Pour l'année, il faut tester la bissextilité mais pas de limite haute ou basse.

#### isLeapYear

Tester la bissextilité : divisible par 4 sauf centenaire non divisible par 400

- cas divisible par 4 mais pas par 400
- cas divisible par 4 et par 400
- cas non divisible par 4

#### nextDate et previousDate

Pour nextDate :
- Incrémentation du jour
- Passage au mois suivant si jour dépasse 31
- Passage à l'année suivante si mois dépasse 12

Pour previousDate :
- Décrémentation du jour
- Passage au mois précédent si jour passe en dessous de 1
- Passage à l'année précédente si mois passe en dessous de 1

#### compareTo

- Comparaison d'années
- Comparaison de mois si années égales
- Comparaison de jours si années et mois égaux

tester selon Comparable, `date.compareTo(other)` :
- retourne un entier positif si date est plus tard que other
- retourne un entier négatif si date est plus tôt que other
- retourne 0 si date et other sont la même date

et un NullPointerException si une date est nulle.

### 2. Statement coverage

Pour évaluer la couverture de déclaration des cas de test définis précédemment, on a analysé chaque méthode séparément.

Pour le constructeur et isValidDate(), les cas de test couvrent déjà tous les blocs possibles pour les plages de jour et de mois.

#### Pour isLeapYear()
On a ajouté les cas de test suivants pour les années bissextiles :
- Année 2000 (divisible par 400)
- Année 1900 (non divisible par 100 mais divisible par 4)

#### Pour nextDate()
On a ajouté des cas de test pour :
- Incrémenter le jour au-delà de 31 dans un mois de 30 jours
- Passer au mois et à l'année suivants

#### Pour previousDate()
Mêmes cas de test supplémentaires que nextDate() mais avec une décrémentation.

#### Pour compareTo()
On a ajouté des cas de test pour comparer :
- Des dates avec la même année mais mois/jour différents
- Des dates avec des années différentes

Ces modifications permettent d'atteindre une couverture de déclaration quasi-complète pour tous les blocs de code identifiés.

### 3. Base Choice Coverage

Pour évaluer la Base Choice Coverage des prédicats complexes utilisant plus de deux opérateurs booléens, on a analysé la méthode isValidDate().

Les cas de tests existants ne couvrent pas les années bissextiles, on ajoute ces cas :

```java
@Test
public void isValidDateFebruaryAndLeap() {
    assertTrue(Date.isValidDate(29, 2, 2020));
    assertFalse(Date.isValidDate(29, 2, 2023));
}
```

### 4. PIT

Avec les tests actuels, on a ces stats :

```
>> Line Coverage (for mutated classes only): 48/49 (98%)
>> Generated 58 mutations Killed 56 (97%)
>> Mutations with no coverage 2. Test strength 100%
>> Ran 95 tests (1.64 tests per mutation)
```

Les seuls mutants non tués sont pour equals, les deux premiers if ont ça : *replaced boolean return with false for Date::equals → NO_COVERAGE* et *replaced boolean return with true for Date::equals → NO_COVERAGE*.

Nous avons ajouté ces tests :

```java
@Test
public void equalsNullDifferent() {
    Date date1 = new Date(1, 1, 2022);
    assertFalse(date1.equals(null));
    assertFalse(date1.equals("Pas une date"));

    Date date3 = new Date(2, 1, 2022);
    assertFalse(date1.equals(date3));
    Date date4 = new Date(1, 2, 2022);
    assertFalse(date1.equals(date4));
    Date date5 = new Date(1, 1, 2023);
    assertFalse(date1.equals(date5));
}
```

Et il ne reste que 1 mutant en vie.
