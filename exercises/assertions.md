# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

### 1.
Le test `assertTrue(3 * 0,4 == 1,2)` échoue en raison des limitations de précision des nombres à virgule flottante dans les langages de programmation. Pour faire ce genre de vérification, il vaut mieux comparer le résultat au résultat souhaité, et considérer que c'est bon si la différence est inférieure à un seuil.

### 2. 
`assertEquals` compare les valeurs tandis que `assertSame` compare les adresses. C'est à dire que par exemple en Java, si on fait un `assertSame` sur des variables x et y, initialisées par `int x=1` et `int y=1`, le résultat sera `false`, alors que le `assertEquals` rendra `true`. Cependant, si on a deux variables x et y qui pointent vers la même adresse, on aura `true`.

### 3.
`fail` peut servir pour noter un test qui n'aurait pas encore été implémenté, à l'instar d'un TODO. Cela peut aussi servir pour signaler un résultat inattendu sans pour autant arrêter l'execution comme le ferait une exception (pas besoin de catch quoient).

### 4.
C'est plus clair à utiliser, on peut préciser le type d'exception et donc être plus précis, et également attendre plusieurs exceptions différentes.



