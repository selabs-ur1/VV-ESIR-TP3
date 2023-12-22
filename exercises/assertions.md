# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. Cette assertion va échouer à cause des approximations. Les approximations vont donner comme résultat qui ne sera pas exactement 1.2 (mais 1.199.. ou 1.200..). Il faut donc modifier l'opérateur `==` en `<=` ou `>=` en fonction du cas dans lequel on est.

2. `assertEquals` vérifie que deux objets sont égaux (qu'ils comportent les mêmes informations) tandis que `assertSame` vérifie que deux objets sont identiques (qu'ils ont la même adresse mémoire).

```java
@Test
public void testIdentique(){
  assertEquals("1","1") //le test va réussir
  assertSame("1", "1") //le test va réussir
}
@Test
public void testDifférent(){
  assertEquals("1", new String("1")) //le test va réussir
  assertSame("1",new String("1")) //le test va échouer
}
```

3. On peut utiliser ça pour arrêter le code pour tester une condition (de type un entier supérieur à l'entier qui doit être maximal) ou encore pour fail si on arrive à un endroit du code où on ne devrait pas pouvoir accéder. [Using Fail Assertion in JUnit](https://www.baeldung.com/junit-fail)

4. En JUnit 5, il est d'une part plus simple de vérifier une exception grâce à `assertThrows()` par rapport à JUnit4. On n'a pas besoin de faire de try/catch et donc il sera plus simple d'analyser les exceptions qu'on attend, on aura uniquement des exceptions pertinentes. [Développement en JUnit5](https://www.jmdoudoux.fr/java/dej/chap-junit5.htm)
