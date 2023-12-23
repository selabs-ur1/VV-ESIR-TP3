# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

**1.**
   L'assertion `assertTrue(3 * 0.4 == 1.2)` échoue en raison de problèmes de précision des floatants. Les floatants ne peuvent pas être représentés exactement. Ici, `3 * 0.4` pourrait ne pas être exactement égal à `1.2` en raison de ces limitations.

   Pour vérifier l'égalité avec des floatants, il est préférable d'utiliser une valeur delta, permettant une petite tolérance dans la comparaison. Par exemple :
   ```java
   assertTrue(Math.abs(3 * 0.4 - 1.2) < 0.0001);
   ```

**2.**
- assertEquals vérifie si deux objets sont égaux en termes de contenu ou valeur. Il utilise la méthode equals pour la comparaison.

```java
assertEquals("Hello", new String("Hello"));
```

- assertSame vérifie si deux références pointent exactement vers la même instance d'objet.

```java
String str1 = "Hello";
String str2 = str1;
assertSame(str1, str2);
```

**3.** On pourrait utiliser fail pour :
- Montrer qu'une implémentation est incomplète :
```java
public void maMethode() {
 	// Pour rappeler aux développeurs de compléter l'implémentation
 	fail("Méthode non entièrement implémentée.");
}
```
- Passe par un chemin dans lequel on ne devrait pas :
```java
public void maMethode() {
 	if (conditionCenseEtreFausse) {
     	fail("Condition inattendue rencontrée.");
 	}
 	// reste du code...
}
```

**4.** L'utilisation de assertThrows offre:
- Meilleure lisibilité :
assertThrows offre une manière plus claire et plus lisible d'exprimer l'intention de s'attendre à une exception, améliorant la lisibilité du code.

- Vérification granulaire du type d'exception :
assertThrows vous permet de spécifier le type d'exception attendu, offrant une plus grande précision dans la vérification de la correction de la gestion des exceptions.

- Détails de l'exception :
assertThrows fournit un accès à l'exception levée, permettant des assertions supplémentaires sur les détails de l'exception.
