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

1. Use input space partitioning

In order to select a good test set, we used the input space partitioning method.
We devided the input space in 3 characteristics and 3 blocks, as follows:

|Characteristics    |   |Blocks |       |       |
|-------------------|:--|:------|:------|:------|
|                   |   |b1     |b2     |b3      |
|q1                 | Additional text content |  non   |  symetric   |  asymmetric   |
|q2                 | Number of closures per opening |  0   |  1   |  <1   |
|q3                 | Order of closures/order of openings |  NA   |  equivalent   |  different   |

The block B1 correspond to an absence in the inputs. </br>
The block B2 correspond in the simplest correct input cases. </br>
The block B3 correspond to a difference between the actual input and the expected input. </br>
 </br>
The Q1 characteristic correspond to the presence of text other than parentheses, brackets and braces in the input. </br>
The Q2 characteristic correspond to the number of closures per opening. </br>
The Q3 characteristic correspond to the order of closures being the same as the order of openings. </br>
 </br>
Then we created our tests by following the above table.

2.

In order to evaluate the statement coverage we added jacoco to the pom.xml file.
Then we did a mvn clean install and mvn jacoco:report.


In order to evaluate the statement coverage we added jacoco to the pom.xml file.
Then we did a mvn install and mvn jacoco:report.

We saw in the report that the statement coverage was 100%, so we didn't need to add any new test cases for the coverage.

3.
If we look in the jacoco report, the coverage is of 92% for the branches (with 2 missed branches).
We added two new cases in the test class in order to cover the missed branches.
We have now covered every value for the variable c, which is the only one in statements with more than 2 boolean operators.

We now have a 100% coverage for the branches (all other branches were already covered by the previous tests because we only have one variable at the origin of the branches).

4.

By using the command 
```mvn org.pitest:pitest-maven:mutationCoverage```, we obtained a mutation score of 100% and 15/15 mutations killed.

However, the line of the class declaration wasn't covered by the tests, so we added a test case to cover it. </br>
Because the class only had static methods, we didn't try to instantiate it, so the class prototype wasn't covered by the tests. </br>
We just added a test case instantiating the class and now the line coverage is also of 100% for the mutations.


