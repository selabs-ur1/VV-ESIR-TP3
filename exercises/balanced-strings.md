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

1. Le domaine d'entrée correspond à n'importe quelle chaîne de caractères. On partitionne alors le domaine d'entrée :
- Une chaîne de caractère avec aucun symbole de groupement
- Une chaîne de caractère avec un ou plusieurs groupements (soit [], soit (), soit {}) et composée d'autres caractères
- Une chaîne composée avec plusieurs groupements imbriqués et composée d'autres caractères
- Une chaîne de caractères composée uniquement d'un ou plusieurs groupements corrects
- Une chaîne de caractères composée uniquement un ou plusieurs groupements incorrects

2. On implémente les différents cas de test associé à un cas de test associé à une partition. On obtient alors une couverture de 100% de cas de test avec le plugin JaCoCo.

3. On écrit de nouveau cas de test afin de faire en sorte d'évaluer les prédicats lorsqu'ils sont vrais et faux. Pour trouver les cas de test, on se base sur l'implémentation de la fonction afin de déterminer les règles que les prédicats vérifient. 

4. En utilisant PIT avec Maven, on obtient un taux de mutation tué de 100%. Cela signifie que l'on détecte bien lorsque le comportement des tests changent et donc qu'ils sont "utiles".