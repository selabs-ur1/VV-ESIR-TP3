# Balanced strings

A string containing grouping symbols `{}[]()` is said to be balanced if every open symbol `{[(` has a matching closed symbol `)]}` and the substrings before, after and between each pair of symbols is also balanced. The empty string is considered as balanced.

For example: `{[][]}({})` is balanced, while `][`, `([)]`, `{`, `{(}{}` are not.

Implement the following method:

```java
public class Balance {

    public static boolean isBalanced(String str)throws IllegalArgumentException {
        ArrayList<Character> tmp = new ArrayList<Character>();
        if(str==null) {
            throw new IllegalArgumentException("String cannot be null");
        }

        Iterator<Character> it = str.chars().mapToObj(c -> (char) c).iterator();

        while (it.hasNext()) {
            switch (it.next()) {

                case '{':
                    tmp.add('{');
                    break;

                case '[':
                    tmp.add('[');
                    break;

                case '(':
                    tmp.add('(');
                    break;

                case '}':

                    if (!tmp.isEmpty() && tmp.get(tmp.size()-1).equals('{')) {
                        tmp.remove(tmp.size()-1);

                    } else {
                        return false;
                    }
                    break;

                case ']':

                    if (!tmp.isEmpty() && tmp.get(tmp.size()-1).equals('[')) {
                        tmp.remove(tmp.size()-1);

                    } else {
                        return false;
                    }
                    break;

                case ')':

                    if (!tmp.isEmpty() &&tmp.get(tmp.size()-1).equals('(')) {
                        tmp.remove(tmp.size()-1);

                    } else {
                        return false;
                    }
                    break;

            }
        }
        return tmp.isEmpty();
    }

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

| Characteristics    | Block 1 | Block 2                  | Block 3                  | Block 4                  | Block 5           |
|--------------------|---------|--------------------------|--------------------------|--------------------------|-------------------|
| str (Input String) | ""      | String with { (balanced) | String with [ (balanced) | String with ( (balanced) | String unbalanced |

2. The test cases don't contain null case. We should add a test case with a null string.
3. Our domain is the set of Strings of length 0 to infinity. The blocks are defined by the conditions (if, case, while...). In this method, there are 10 blocks.
The first partition is when we don't enter in `while` at all. It corresponds to an empty string.
The three next partitions concern the following symbols `{`, `[`, `(`. They are the opening symbols of a group. The next six concern what happens when we reach closing symbols.
If the string is balanced so far, we keep going, otherwise, we break.

Test cases:

 - null
 - ""
 - "{"
 - "("
 - "["
 - "]"
 - "}"
 - ")"
 - "{}[]"
 - "{()}"

4. 20 mutations has been fenerated and 17 where killed. It correspond to a coverage of 85%. By adding a test case with 
random characters (not only {([])}), the coverage increased up to 100%.