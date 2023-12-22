# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. L'assertion échoue car nous comparons des flottants. Certains nombres ne peuvent pas être stocké parfaitement car leur représentation est infinie. Il faut donc éviter d'utiliser des comparaisons d'égalité avec les nombres décimaux et manipuler des inégalités à la place. Pour le assertEquals, il est possible de spécifier un delta pour lequel l'égalité des deux nombres sera validée. 

2. AssertEquals va vérifier que deux éléments sont *égaux* (utilise `equals`, si ce sont deux types primitifs, cela utilise l'opérateur d'égalité). AssertSame va en revanche vérifier si deux éléments ont la même *référence*. Dans le cas de types primitifs, assertEquals et assertSame vont renvoyer le même résultat. En effet si nous avons :
```java
int a = 2;
int b = 2;
```
a et b ont la même valeur (assertEquals passera) mais également la même référence car la déclaration d'un nouveau type primitif va juste récupérer la zone mémoire où la valeur est stockée.  

3. Le mot clé fail pourrait aussi servir comme code par défaut dans un cas de test dont on n'aurait pas encore développé le code ou alors pour un cas de test qui teste du code qui n'a pas encore été développé. Ainsi le cas de test renverrait toujours failed en attendant de développer le reste.

4. assertThrows permet une meilleure lisibilité, on voit directement que le test renvoie une exception. On peut également utiliser des fonctions lambda ce qui allège et rend plus modulaires les cas de tests. 

