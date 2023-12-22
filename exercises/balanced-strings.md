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

1. Pour cette méthode, nous avons seulement un paramètre (`String str`), nous n'aurons donc pas de produit cartésien à réaliser sur les inputs. Nous avons plusieurs valeurs d'entrée qui sont pertinentes à utiliser : une chaîne vide, une chaîne de caractères alphanumériques, une chaîne composée d'un seul symbole ouvrant, une chaîne avec des symboles désequilibrés et enfin, une chaîne avec des symboles équilibrés.
2. Après avoir observé la couverture de test, nous pouvons observer qu'avec nos tests précédemment définis, il nous manque un test lorsque nous avons uniquement un caractère fermant. Après avoir rajouté ce test, le programme est couvert à 100%.
3. Nos différents tests satisfont bien le *Base Choice Coverage*, même en faisant varier une partition, ils passent quand même à 100%.  
4. Après avoir lancé un test de mutation avec PIT, nous avons 19 mutants tués sur 19 mutants créés, donc une *Mutation Strength* de 100%, nous avons également un *Test Strength* de 100%.
