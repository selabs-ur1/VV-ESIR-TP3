# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public static boolean isBalanced(String str) {
    Stack<Character> stack = new Stack<>();

    for (char ch : str.toCharArray()) {
        if (ch == '(' || ch == '[' || ch == '{') {
            stack.push(ch);
        } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
            stack.pop();
        } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
            stack.pop();
        } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
             stack.pop();
        } else {
             // Unmatched closing bracket or invalid character
            return false;
        }
    }

    // If the stack is empty, all opening brackets were matched
    return stack.isEmpty();
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

1. ### Input Space Partitioning :

>a. Empty String:
>* **Characteristics :** Empty input string.
>* **Partition :** ` "" `
>
>b. Balanced Strings:
>* **Characteristics :** Strings with correctly matched grouping symbols.
>* **Partition :** ` {} ; [] ; () ; {[]} ; [{()}] ; {{}}[[]]() ` 
>c. Unbalanced Strings:
>* **Characteristics :** Strings with incorrectly matched or missing grouping symbols.
>* **Partitions :** ` }{ ; ][ ; ([)] ; { ; {{]}} `

2. ### Statement Coverage:

>a. Test Cases for Empty String: `Expected: true`
>* isBalanced("")
>
>b. Test Cases for Balanced Strings: `Expected: true`
>* isBalanced("{}")
>* isBalanced("[]")
>* isBalanced("()")
>* isBalanced("{[]}")
>* isBalanced("[{()}]")
>* isBalanced("{{}}[[]]()")
>
>c. Test Cases for Unbalanced Strings: `Expected: false`
>* isBalanced("}{")
>* isBalanced("][")
>* isBalanced("([)]")
>* isBalanced("{")
>* isBalanced("{{]}}")



