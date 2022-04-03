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

1. At first we know that the input domain is all Strings so we will partition with different Strings blocks.
We start by the interface-based approach. We write 3 test cases with an empty input, a null input and a normal String as input and with an assertTrue(). We run tests and we realize that the normal String test fails because there are no opening symbols in the normal String. So the stack was empty when we wanted to check the top item of the stack. That throws an EmptyStackException. We decided to add an if statement that checks if the stack is not empty. Furthermore, if the stack is empty and we detect a closing symbol, the method returns false and stops the process. 
Then we use the functionality-based approach to try all the if statement combinations. We write 6 test cases with inputs from different input partitions as a string only composed of closing symbols, a string with a closing symbol and the stack empty, a balanced and an unbalanced string and a poorly nested string.

2. Then we evaluate the test coverage with the coverage plugin of Eclipse and we reach a 100% coverage rate. So we have not added a test at this moment.

3. In our methods, we have one predicate with 2 boolean operator :
```java
if((char)(it.current()-2)==symbol.peek() || it.current()==’)’)
```
It means that if the second character preceding the current character in the ascii table is equal to the top symbol of the stack or the current character is a closing parenthesis, the predicate is true. So we need to test 3 cases because the case where both predicates are true is impossible.

![image](https://user-images.githubusercontent.com/72169834/161377999-14fa7a19-22a4-404b-80b3-063066608d21.png)
However we already have this tests so we don’t add some tests at this moment

4. We run a PIT mutation test and we reach a 100% score of mutation coverage with 12 mutations killed so it’s useless to add some cases
