# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. Cette assertion échoue car la valeur de "3* .4" n'est pas exactement de 1.2, mais plutôt quelque chose de l'ordre de "1.2000002". Cela est lié à un problème de représentation des flottants en Java ( et également d'autres langages). Pour palier à cela, il faut utiliser `assertEquals` au lieu de `assertTrue`.

2. ``assertEquals`` retourne vrai si les deux éléments ont la même valeur, alors que ``assertSame`` ne retourne vrai que s'il s'agit du même élément. Cela signifie qu'utiliser ``assertEquals`` avec deux éléments de même valeur renverrait vrai, mais `assertSame` renverrait faux.

Exemple :
```java
Integer i1 = new Integer(1);
Integer i2 = new Integer(1);
assertEquals(i1, i2); // => True
assertSame(i1, i2); // => False
assertSame(i1, i1); // => True
```

3. `fail` peut être utilisé pour vérifier qu'on ne passe jamais par une certaine portion du code. Par exemple, un cas par défaut dans un switch qui ne devrait jamais être utilisé, ou lorsque l'on catch une exception.

4. ``assertThrows`` permet de vérifier que l'erreur est bien lancée, ainsi que vérifier ses attributs. Cela permet de vérifier qu'elle est lancée avec les bons paramètres.