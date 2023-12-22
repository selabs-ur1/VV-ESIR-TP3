# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    ...
}
```

`isBalanced` returns `true` if `str` is balanced according to the rules explained above. Otherwise, it returns `false`.

Use the coverage criteria studied in classes as follows:

1. Use input space partitioning to design an initial set of inputs. Explain below the characteristics and partition blocks you identified.
2. Evaluate the statement coverage of the test cases designed in the previous step. If needed, add new test cases to increase the coverage. Describe below what you did in this step.
3. If you have in your code any predicate that uses more than two boolean operators, check if the test cases written so far satisfy *Base Choice Coverage*. If needed, add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1. On peut repérer deux partitions qui correspondent aux deux sorties possibles :

- `true` si la chaîne est bien équilibrée (ex: `()`)
- `false` si la chaîne n'est pas équilibrée (ex: `)(`)

2. Avec ces deux tests, on obtient une couverture de 69% des lignes.

On ajoute un nouveau test qui utilise toutes les parenthèses :

```java
class StringUtilsTest {
  @Test
  void testBalanced2() {
    assertTrue(StringUtils.isBalanced("({[]})"));
  }
}
```

On obtient alors une couverture de 100% des lignes.

3. Nous n'avons pas de condition avec plus de deux opérateurs booléens.




4. On obtient un score de 88% avec les tests précédents.
   On a un mutant vivant qui correspond à : "replaced boolean return with true" (37).
   Ce mutant vivant nous indique que nos tests ne couvrent pas le cas où le stack n'est pas vide à la fin de l'exécution de
   la méthode.
   On rajoute donc un test où le stack n'est pas vide :

```java
class StringUtilsTest {
  @Test
  void testLength1() {
    assertFalse(StringUtils.isBalanced("("));
  }
}
```
