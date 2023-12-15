# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1.  L'assertion suivante échoue assertTrue(3 * .4 == 1.2). Cela se produit parce que les nombres à virgule flottante peuvent entraîner des erreurs d'arrondi. Pour effectuer ce type de vérification, il est préférable d'utiliser des méthodes de comparaison avec une tolérance, comme assertEquals avec une précision spécifiée.

2.  assertEquals compare les valeurs des objets, tandis que assertSame vérifie s'ils font référence au même objet en mémoire. Ils produiront le même résultat lorsque les objets sont égaux et ont la même référence dans le cas d'objets immuables tels que les chaînes. Cependant, pour les objets mutables, comme les listes, ils peuvent différer, car assertEquals vérifie l'égalité des valeurs, tandis que assertSame vérifie l'identité des objets.

3.   En dehors des cas d'exceptions attendues, fail peut être utilisé pour marquer temporairement des parties de code qui ne doivent pas être exécutées, par exemple, lors du développement ou du débogage. Cela peut aider à s'assurer qu'aucun code non terminé ou incorrect n'est accidentellement exécuté. Ci-dessous un exemple de code :
```Java
public void someMethod() {
    // TODO: Implement this method
    fail("Not implemented yet");
    // Rest of the method code that should not be executed until implementation is complete
}
```

4.   L'emploi de assertThrows dans JUnit 5 simplifie la syntaxe et rend la vérification des exceptions attendues plus claire et expressive. Cela améliore la lisibilité du code et facilite la compréhension des tests. De plus, assertThrows prend en charge les expressions lambda, offrant ainsi une flexibilité accrue pour la validation des exceptions. En revanche, dans JUnit 4, l'annotation @Test nécessitait des clauses throws dans la signature des méthodes de test, ce qui pouvait rendre le code moins élégant et plus verbeux en comparaison.


