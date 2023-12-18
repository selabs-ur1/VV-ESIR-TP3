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

1. Parmi toutes les possibilités d'input, nous avons pu les répartir en partitions pour limiter le nombre de tests. Les partitions sont les suivantes :  

|   | IsBalanced          | IsNotBalanced |
| :---------------: |:---------------:| :-----:|
| String vide  |   Impossible       |  "" |
| Symbole ouvrant suivi d'un symbole fermant | "()"             |   "{)" |
| Suite de symboles ouvrants et fermants  | "{}()[]"          |    "{}(}[]" |
| Suite de symboles ouvrants et fermants  | "{}()[]"          |    "{}(}[]" |
| Suite de symboles ouvrants puis une suite de symboles fermants  | "({[]})"          |    "([[]})" |
| Uniquements des symboles ouvrants/fermants  | Impossible          |    "((" / "))" |
| Paires alternées  | Impossible          |    "({)}" |
| Paire de symboles entourant du texte  | "(vérificationvalidation)"          |    "(vérificationvalidation}" |
| Paire de symboles au milieu du texte  | "vérificati(onva)lidation"          |    "vérificati(onva}lidation" |


2. Nous avons ajouté au pom.xml le plugin jacoco pour pouvoir visualiser la couverture de test et nous avons réussi à obtenir une couverture de 100% de nos tests.  
  
3. Nos cas de tests arrivent bien à satisfaire les prédicats avec plusieurs opérateurs booléens. S'il y avait eu une erreur, nous aurions pu utiliser le MC/DC en générant pour chaque condition 2 cas de test, tels que la décision du prédicat change alors que toutes les autres conditions sont fixées.  
  
4. Après avoir utilisé PIT, nous obtenons un score de mutation de 93% (dû au fait que PIT ne peut pas faire de mutation sur le nom de la classe) et l'ensemble de nos mutants ont été tués car nos tests ont bien capturé l'ensemble des mutations.
