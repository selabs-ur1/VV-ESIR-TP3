# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. L'assert échoue dû aux approximations faites lors du calcul 3 * 0.4 qui n'est pas exactement égale à 1.2 mais à 1.2000000000000002. Lorsqu'on manipule des flottants, on doit prendre en compte les approximations. Pour cela, il existe un paramètre delta dans la fonction `assertEquals` pour les flottants.

2. La différence entre `assertEquals` et `assertSame` est que la fonction `assertEquals` utilise la fonction `equals` pour comparer les 2 objets fournis en paramètre tandis que la fonction `assertSame` utilise l'opérateur `==`. Ce qui signifie que l'opérateur `==`compare l'adresse mémoire tandis que la fonction `equals` compare par défaut l'adresse mémoire pour les objets et si la fonction est redéfinie, en fonction du choix du programmeur.

3. On peut l'utiliser de façon inverse afin de détecter qu'une exception est levée alors que le test doit se dérouler sans renvoyer d'exception. On peut aussi l'utiliser lorsqu'un test n'a pas été implémenté dont on définit la spécification. Par exemple :
```java
@Test
public void testIncomplet() {
    fail("Pas encore implemente");
}
```

4. L'avantage d'utiliser une fonction au lieu de `@Test` est que cela permet de placer le moment où l'assertion doit avoir lieu. L'utilité est de venir tester une fonction en particulier au cas où il y aurait plusieurs sources d'exceptions. De plus, la fonction améliore la lisibilité car un programmeur extérieur permet de mieux identifier l'oracle. 