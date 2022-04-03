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
3. If you have in your code any predicate that uses more than two boolean operators check if the test cases written so far satisfy *Base Choice Coverage*. If needed add new test cases. Describe below how you evaluated the logic coverage and the new test cases you added.
4. Use PIT to evaluate the test suite you have so far. Describe below the mutation score and the live mutants. Add new test cases or refactor the existing ones to achieve a high mutation score.

Write below the actions you took on each step and the results you obtained.
Use the project in [tp3-balanced-strings](../code/tp3-balanced-strings) to complete this exercise.

## Answer

1. 
For this part of the exercise we took inspiration on the textbook to create a table with the characteristics and its blocks : 

| Characteristic  | Blocks |
| :--------------- |:---------------:|:-----:|
| value of str  | null       |  “” | “[a-z][A-Z][0-9]” | “[a-z][A-Z][0-9][()-[]-{}]” | “[a-z][A-Z][0-9])|}|]” |

Our only input is a String, we first made an approach with interface based modeling with the potential values null, empty or with text and then we thought about the functionality based modeling on the function. And we are concentrated on the grouping symbols. So a string can be without any grouping symbols and with balanced or unbalanced grouping symbols.

2. When we evaluated the statement coverage at first we got 86,2%. So decided to add more tests to cover better some parts of the code because the tests weren't going through one of the branches for the '{' and also for the '['. And the test strOpeningSymbols was red because it as returning true instead of false. So we first modified our function isBalanced to correct the fault about the opening symbols, we change the return in the end to verify if our stack is empty in the end or not. Then, we changed our tests to make them cover the entire code and to lead to a 100% coverage. 

3. We also verified the *Base Choice Coverage* but we didn't need to add any new case because the predicate with multiple booleans was tested in diferent tests already.

4. Finally we used PIT to evaluate the test suite. Our mutation score is equal to 100% because all of the mutants were killed in the end. So we didn't need to add more test cases.
