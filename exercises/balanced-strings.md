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
Jugieau Barthelat

1.
blocks :

The blocks we use for testing are :

No ()[]{}, only other characters
Not the same number of closing/opened brackets
Same number but wrong order (closed before being opened)
Same number and right order with overlap (ex : ([)] )
Same number and right order, nested brackets
Same number and right order, no nested brackets


2.
We used Jacoco to find out our statement coverage
Some instructions and branches are not covered
By adding a test with an empty string, instructions are now 100% covered.


3.
There are 2 missing branches in the if statement, which correspond to not very important cases or impossible situations (due to nested if)


4.
run with this maven goal :
org.pitest:pitest-maven:mutationCoverage

So we got 21 mutations killed over 22 which makes a 95% score.

The mutator that survived made a modification on this line
return pile.isEmpty();
It is replaced by “return true”. And that’s correct, when we put true instead our test suitcases keep working. But it makes sense because when we exit the previous loop in this code, the stack is necessarily empty.


