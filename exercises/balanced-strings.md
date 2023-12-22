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
1. **Partitionnement de l'espace d'entrée :**

   - **Caractères valides :**
     - Partition 1 : Chaînes avec uniquement des caractères valides `{}`, `[]`, `()`.
     - Partition 2 : Chaînes avec des caractères valides et d'autres caractères (lettres, chiffres, etc.).

   - **Position des symboles :**
     - Partition 3 : Chaînes avec des symboles équilibrés au début, au milieu et à la fin.
     - Partition 4 : Chaînes avec des symboles déséquilibrés au début, au milieu et à la fin.

   - **Symboles redondants et non appariés :**
     - Partition 5 : Chaînes avec des symboles de fermeture redondants.
     - Partition 6 : Chaînes avec des symboles de fermeture non appariés.

2. **Évaluation de la couverture de déclaration :**

   - **Cas de test initiaux :**
     - `testChaineVide` : Couvre une chaîne vide.
     - `testSymbolesEquilibres` et `testSymbolesDesequilibres` : Couvrent des chaînes avec des symboles équilibrés et déséquilibrés, respectivement.
     - `testAutresCaracteres` : Couvre des chaînes avec d'autres caractères.
     - `testSymboleFermetureRedondant` et `testSymboleFermetureNonApparie` : Couvrent les cas de symboles de fermeture redondants et non appariés.

   - **Ajouts :**
     - Ajout de cas de test pour couvrir différentes positions des symboles :
       - `testSymbolesEquilibresDebut` et `testSymbolesDesequilibresDebut` : Symboles équilibrés et déséquilibrés au début.
       - `testSymbolesEquilibresMilieu` et `testSymbolesDesequilibresMilieu` : Symboles équilibrés et déséquilibrés au milieu.
       - `testSymbolesEquilibresFin` et `testSymbolesDesequilibresFin` : Symboles équilibrés et déséquilibrés à la fin.

   - **Résultat :**
     - Amélioration de la couverture en considérant différentes positions des symboles dans la chaîne.

3. **Base Choice Coverage pour les prédicats :**

   - Le code semble avoir des conditions booléennes simples avec deux opérateurs, et il n'y a pas besoin de Base Choice Coverage.

   - Toutes les conditions sont de la forme `if (condition)`, où `condition` est une expression booléenne simple.

   - Aucun cas de test supplémentaire n'est nécessaire pour la Base Choice Coverage.

4. **Test PIT**
Sortie de Test:
================================================================================
- Mutators
================================================================================
> org.pitest.mutationtest.engine.gregor.mutators.BooleanTrueReturnValsMutator
>> Generated 4 Killed 3 (75%)
> KILLED 3 SURVIVED 1 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.BooleanFalseReturnValsMutator
>> Generated 1 Killed 1 (100%)
> KILLED 1 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
> org.pitest.mutationtest.engine.gregor.mutators.NegateConditionalsMutator
>> Generated 14 Killed 14 (100%)
> KILLED 14 SURVIVED 0 TIMED_OUT 0 NON_VIABLE 0 
> MEMORY_ERROR 0 NOT_STARTED 0 STARTED 0 RUN_ERROR 0 
> NO_COVERAGE 0 
--------------------------------------------------------------------------------
================================================================================
- Timings
================================================================================
> scan classpath : < 1 second
> coverage and dependency analysis : < 1 second
> build mutation tests : < 1 second
> run mutation analysis : 1 seconds
--------------------------------------------------------------------------------
> Total  : 2 seconds
--------------------------------------------------------------------------------
================================================================================
- Statistics
================================================================================
>> Generated 19 mutations Killed 18 (95%)
>> Ran 23 tests (1.21 tests per mutation)

On obtient un score de mutation de 95%