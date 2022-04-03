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

```Java 
class Date implements Comparable<Date> {
	
	private static Integer[] nbJoursParMois = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public int day;
	public int month;
	public int year;

    public Date(int day, int month, int year) throws Exception { 
    	if(isValidDate(day, month, year)) {
    		this.day = day;
    		this.month = month;
    		this.year = year;
    	} else {
    		throw new Exception("La date n'est pas valide");
    	}
    }

    public static boolean isValidDate(int day, int month, int year) { 
    	if(month == 2  && isLeapYear(year) &&
    	   day > 0 && day < 30) {
    		return true;
    	}
    	
    	if(month > 0 && month < 13 &&
    		 day > 0 && day <= nbJoursParMois[month-1]) {
    		return true;
    	}
    	return false; 
    }

    public static boolean isLeapYear(int year) { 
    	return ((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0;
    }

    public Date nextDate() throws Exception {
    	if(isLeapYear(this.year) && this.month == 2 && this.day == 29) {
    		return new Date(1, 3, this.year);
    	}
    	
    	if(this.day == nbJoursParMois[month-1]) {
    		if(this.month == 12) {
    			return new Date(1, 1, this.year+1);
    		} else {
    			return new Date(1, month+1, this.year);
    		}
    	} else {
    		return new Date(this.day+1, this.month, this.year);
    	}
    }

    public Date previousDate() throws Exception {
    	if(isLeapYear(this.year) && this.month == 3 && this.day == 1) {
    		return new Date(29, 2, this.year);
    	}
    	
    	if(this.day == 1) {
    		if(this.month == 1) {
    			return new Date(31, 12, this.year-1);
    		} else {
    			return new Date(nbJoursParMois[month-2], month-1, this.year);
    		}
    	} else {
    		return new Date(this.day-1, this.month, this.year);
    	}
    }

    public int compareTo(Date other) { 
    	return (this.year - other.year) * 400 + (this.month - other.month) * 31 + (this.day - other.day); 
    }
}
```
1. Dans les tests suivants, nous avons utilisé des dates
- invalides avec un 29 février dans une année bissextile, invalides avec un jour inférieur à 1 ou supérieur à la date max du mois, invalides avec un mois inférieur à 1 ou supérieur à 12 et valides avec des jours, mois et années différentes pour le constructeur et la méthode isValidDate.
- bissextiles en remplissant différente conditions et non-bissextiles pour la méthode isLeapYear.
- de fin de mois de février dans une année bissextile, de fin de mois et de fin d'année, de fin de mois et de milieu de mois pour la méthode nextDate.
- de début de mois de mars dans une année bissextile, de début de mois de début d'année, de début de mois et de milieu de mois pour la méthode previousDate.
- identiques, avec un jour de décalage, avec le même jour et la même année mais un mois différent et des dates complètements différents pour la méthode compareTo. 


```Java
class DateTest {

	@Test
	void testInvalidDateLeapYear() {
		try{
			new Date(29, 2, 2001);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateMonthSupTwelve() {
		try{
			new Date(15, 18, 1999);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateMonthInfOne() {
		try{
			new Date(15, -4, 1999);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateDaySupMaxMonth() {
		try{
			new Date(35, 2, 2018);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testInvalidDateDayInfOne() {
		try{
			new Date(0, 2, 2018);
			fail("Expected exception was not thrown");
		} catch(Exception e) {}
	}
	
	@Test
	void testValidDate() {
		try{
			new Date(17, 5, 2000);
			new Date(8, 3, 2000);
			new Date(29, 2, 2000);
			new Date(25, 12, 2845);
		} catch(Exception e) {
			fail("Unexpected exception was thrown");
		}
	}
	
	@Test
	void testValidDateWithoutConstructor() {
		assertTrue(Date.isValidDate(1, 1, -1456));
		assertTrue(Date.isValidDate(31, 12, 7891213));
		assertTrue(Date.isValidDate(15, 8, 1));
		assertTrue(Date.isValidDate(31, 10, -4));
	}
	
	@Test
	void testInValidDateWithoutConstructor() {
		assertFalse(Date.isValidDate(-45, 11, -1456));
		assertFalse(Date.isValidDate(32, 1, 65));
		assertFalse(Date.isValidDate(15, 15, 15));
		assertFalse(Date.isValidDate(0, 0, 0));
	}
	
	@Test
	void testLeapYear() {
		assertTrue(Date.isLeapYear(2000));
		assertTrue(Date.isLeapYear(2020));
		assertTrue(Date.isLeapYear(2028));
	}
	
	@Test
	void testNotLeapYear() {
		assertFalse(Date.isLeapYear(2002));
		assertFalse(Date.isLeapYear(1900));
		assertFalse(Date.isLeapYear(2019));
	}
	
	@Test
	void testNextDate() throws Exception {
		Date date1 = new Date(29, 2, 2000);
		Date date2 = new Date(31, 12, 2048);
		Date date3 = new Date(30, 4, 2000);
		Date date4 = new Date(17, 5, 2545);
		
		date1 = date1.nextDate();
		date2 = date2.nextDate();
		date3 = date3.nextDate();
		date4 = date4.nextDate();
		
		assertTrue(date1.day == 1 && date1.month == 3 && date1.year == 2000);
		assertTrue(date2.day == 1 && date2.month == 1 && date2.year == 2049);
		assertTrue(date3.day == 1 && date3.month == 5 && date3.year == 2000);
		assertTrue(date4.day == 18 && date4.month == 5 && date4.year == 2545);
	}
	
	@Test
	void testPreviousDate() throws Exception {
		Date date1 = new Date(1, 3, 2020);
		Date date2 = new Date(1, 1, 1545);
		Date date3 = new Date(1, 4, 568);
		Date date4 = new Date(17, 5, 132);
		
		date1 = date1.previousDate();
		date2 = date2.previousDate();
		date3 = date3.previousDate();
		date4 = date4.previousDate();
		
		assertTrue(date1.day == 29 && date1.month == 2 && date1.year == 2020);
		assertTrue(date2.day == 31 && date2.month == 12 && date2.year == 1544);
		assertTrue(date3.day == 31 && date3.month == 3 && date3.year == 568);
		assertTrue(date4.day == 16 && date4.month == 5 && date4.year == 132);
	}
	
	@Test
	void testCompareTo() throws Exception {
		Date date1 = new Date(1, 3, 2020);
		Date date2 = new Date(1, 3, 2020);
		Date date3 = new Date(5, 4, 785);
		Date date4 = new Date(4, 4, 785);
		Date date5 = new Date(23, 8, 4581);
		Date date6 = new Date(10, 1, 7852);
		Date date7 = new Date(18, 12, 1666);
		Date date8 = new Date(18, 9, 1666);
		
		assertTrue(date1.compareTo(date2) == 0);
		assertTrue(date3.compareTo(date4) > 0);
		assertTrue(date5.compareTo(date6) < 0);
		assertTrue(date7.compareTo(date8) > 0);
	}
}
```

2. Dans notre classe Date, il a 26 lignes à tester. Nous en testons 23 sauf les lignes suivantes :
```Java
this.day = day;
this.month = month;
this.year = year;
```
Ce qui fait une couverture de 88,5%.
Pour améliorer cela nous pouvons ajouter ce test :
```Java 
@Test
void testConstructor() {
    try{
        Date date = new Date(17, 5, 2000);
        assertTrue(date.day == 17 && date.month == 5 && date.year == 2000);
    } catch(Exception e) {
        fail("Unexpected exception was thrown");
    }
}
```

3. Dans notre classe de test les différentes conditions qui utilisent plus de trois conditions sont les suivantes :
```Java 
if(month == 2  && isLeapYear(year) &&
    	   day > 0 && day < 30) {
if(month > 0 && month < 13 &&
    		 day > 0 && day <= nbJoursParMois[month-1]) {
if(isLeapYear(this.year) && this.month == 2 && this.day == 29) {
if(isLeapYear(this.year) && this.month == 3 && this.day == 1) {
```
Dans les deux premières conditions, il y des conditions qui ne peuvent pas valoir faux en même temps. C'est le cas des condiditions sur les jours sur les mois. Pour la première conditions, nous n'avons pas testé les cas où
- `month == 2`, `isLeapYear(year)` et `day > 0` vallent `True` et `day < 30` vaut False
- `month == 2`, `isLeapYear(year)` et `day < 30` vallent `True` et `day > 0` vaut False
Nous pouvons les ajouter :
```Java
assertFalse(Date.isValidDate(-5, 2, 2020));
assertFalse(Date.isValidDate(789, 2, 2024));
```
Pour les deux autres conditions nous avons testé que des cas où tout est vrai et où `isLeapYear(this.year)` est faux alors que les autres sont vrai.
Nous pouvons rajouter ces cas dans `testNextDate()` : 
```Java
Date date5 = new Date(29, 10, 2024);
Date date6 = new Date(13, 2, 2000);
date5 = date5.nextDate();
date6 = date6.nextDate();
assertTrue(date5.day == 30 && date5.month == 10 && date5.year == 2024);
assertTrue(date6.day == 14 && date6.month == 2 && date6.year == 2000);
```
4. Avec l'analyse PIT, nous observons que nous avons une couverture de ligne de 100% et une couverture de mutation de 92% avec 5 mutants survivants.
Deux mutants survivent suitent à un changement de conditions sur dans la ligne suivante :
```Java
if(month == 2  && isLeapYear(year) && day > 0 && day < 30) {
```
Nous avons ajusté les tests suivants pour les éliminer : 
```Java
assertFalse(Date.isValidDate(0, 2, 2000));
assertFalse(Date.isValidDate(30, 2, 2024));
```
De la même façon, pour supprimer les mutants survivant dans la ligne `if(month > 0 && month < 13 && day > 0 && day <= nbJoursParMois[month-1]) {` nous avons ajouter les tests suivants :
```Java
assertFalse(Date.isValidDate(14, 13, 204));
assertFalse(Date.isValidDate(27, 0, 1028));
```
Enfin la dernière mutation survivante était sur la ligne suivante après avoir remplacé une soustraction par une addition : 
```Java
return new Date(nbJoursParMois[month-2], month-1, this.year);
```
Nous avons donc ajouté le test suivant : 
```Java
Date date5 = new Date(1, 12, 1025);
date5 = date5.previousDate();
assertTrue(date5.day == 30 && date5.month == 11 && date5.year == 1025);
```
Nous avons maintenant une couverture des mutants de 100%.
