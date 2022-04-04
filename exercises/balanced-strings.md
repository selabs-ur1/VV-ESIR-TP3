# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

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

1. The first two chatacteristics we can see in for this method is wether the input is null or not null, this provides us with two partitions already. Next up i think we can partition the string input into inputs that contain grouping symbols `{}[]()` and strings that don't (since it wouldn't be much use extensively testing those).
Some of the inputs are : 
`
"", 
"()", 
"()[]{}", 
"([{([{}])", 
"([{})]}", 
`

2. In this step we created the Test Suite that would divide the tests into parts to more clearly cover parts of the input domain.

3. To satisfy the Base Choice Coverage we will add some tests into the suite that will specifically test for the string is empty case and the case where the string does not contain grouping symbols.
