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

### 1)

Après avoir implémenté la méthode `isBalanced`, nous allons utiliser l'"input space partitionning" pour établir un ensemble d'entrée initial.

| caracteristiques                                          | P1    | P2    |
|-----------------------------------------------------------|-------|-------|
| C1 = String vide                                          | True  |       |
| C2 = Nb occurences de '{', '}', '[', ']', '(', ')' pair   | True  | False |
| C3 = Nb occurences de '{', '}', '[', ']', '(', ')' impair | False |       |
| C4 = Nb ouvrant == nb fermant                             | True  | False |

A partir de ce partitionnage, nous pouvons créer un ensemble d'entrée:

| C  | P1       | P2       |
|----|----------|----------|
| C1 | ""       |          | 
| C2 | "{[}]"   | "{[]"    | 
| C3 | "{[]"    |          | 
| C4 | "[{()}]" | "[{(]"   | 

Les blocs de partition que nous avons identifié sont donc les suivants:
- La chaîne de caractère vide, qui est toujours équilibrée
- Le cas où on a un nombre d'occurences de '{', '}', '[', ']', '(', ')' impair, qui est toujours faux
- Le cas où on on a un nombre de parties ouvrantes différent du nombre de parties fermantes, qui est aussi toujours faux
- Plusieurs paires différentes imbriquées ("[{()}]")
- Des ouvrants qui ne correspondent pas aux fermants ("[)", "[(}]")
- Plusieur paires qui ne sont pas imbriquées ("[](){}", "[](}{)")

### 2)
Avec les test initiaux, nous avons obtenu un coverage de 97%. Le cas que nous n'avions pas identifié est le cas où nous avons une parenthèse fermante sans parenthèse ouvrante. En ajoutant un nouveau cas de test ")", nous avons atteint un coverage de 100%.

### 3)
Nos cas de test actuels ne satisfont pas le "Base Choice Coverage". En effet, lorsque l'on trouve un élément fermant, on vérifie si la pile est vide puis si l'élément en haut de la pile correspond au même élément ouvrant. Il nous faut donc ajouter plusieurs cas de test. De plus, nous n'avons pas de test utilisant autre chose que des parenthèses/accolades/crochets :
- Les éléments fermants seuls: ")" (déjà présent dans les cas de test), "]", "}"
- Les éléments fermants qui ne correspondent pas aux éléments ouvrants: "(]", "[)", "[}"
- Les chaines quelconques: "abcd1234"
- Les chaînes quelconques mixées avec des parenthèses: "abcd(12[3{4}])"

Après avoir ajouté ces cas de test, nous obtenont un "Base Choice Coverage" de 100%.

### 4)
Nous allons maintenant utiliser PIT pour évaluer nos tests. A la premier exécution, nous avons obtenu un mutation score de 100%: tous les mutants sont tués par nos tests! Nous pouvons alors garder nos tests tel quels car ils sont tous utiles.
