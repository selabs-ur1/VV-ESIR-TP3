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

1. Input space partitioning
The input domain of a system under test is the set of all possible values that the input parameters
can take.

```java
public static boolean isBalanced(String str)
    {
        if(str == null){
            return false;
        }
        
        Stack<Character> st = new Stack<Character>();

        for(char chr : str.toCharArray())
        {
            switch(chr) {

                case '{':
                case '(':
                case '[':
                    st.push(chr);
                    break;

                case ']':
                    if(st.isEmpty() || st.pop() != '[') 
                        return false;
                    break;
                case ')':
                    if(st.isEmpty() || st.pop() != '(')
                        return false;
                    break;
                case '}':
                    if(st.isEmpty() || st.pop() != '{')
                        return false;
                    break;
            }
        }
        return st.isEmpty();
    }
```

The input domain is the set of all possible string made of the Alphabet `[ { ( ) } ]`
integer elements, including empty string. Possible test inputs may include: { `string: ""`}, { `string: "[({][}})"`} or { `string: "{)[()[{}]"` }.

Interface based modeling considers each parameter separately and takes information only from
their specific domain. It is a simple alternative that makes it easier to identify the characteristics.

|Characteristics|Blocks|
|---------------|---------|
|               |   `B1` -  `B2`  |
|`q1`. String is null |True - False|
|`q2`. String is empty|True - False|
|`q3`. String is Even |True - False|
|`q4`. the substrings before is balanced |True - False|
|`q5`. the substring after is balanced |True - False|
|`q6`. the substring between is balanced |True - False|

The following set of inputs `tries` to achieve ECC coverage. 

|Input|Blocks|Oracle|
|---------------|---------|-------|
| {string : null } | Q1B1 - Q2B? - Q3B? - Q4B? -Q5B? - Q6B?|False|
| {string : ""   } | Q1B2 - Q2B1 - Q3B1 - Q4B1 - Q5B1 - Q6B1|`True`|
| {string : "[] ( [] ) {}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B1 - Q5B1 - Q6B1|`True`|
| {string : "[] ( [] ) `(`}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B1 - Q5B1 - Q6B2|False|
| {string : "[] ( `(`] ) {}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B1 - Q5B2 - Q6B1|False|
| {string : "[] ( `(`] ) `(`}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B1 - Q5B2 - Q6B2|False|
| {string : "`(`] ( [] ) {}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B2 - Q5B1 - Q6B1|False|
| {string : "`(`] ( [] ) `(`}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B2 - Q5B1 - Q6B2|False|
| {string : "`(`] ( `(`] ) {}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B2 - Q5B2 - Q6B1|False|
| {string : "`(`] ( `(`] ) `(`}"   } | Q1B2 - Q2B2 - Q3B1 - Q4B2 - Q5B2 - Q6B2|False|

2. Statement Coverage

In this step we simulated the execution of our method according to the different tests we are going to run on it and reported which lines are executed and which are not. We noticed that at no point in our test set did we have a read check of `)` with an element at the top of the `(` stack. 

We therefore have a Statement coverage value of `22/23`.

To do this we add this test:

> |Input|Blocks|Oracle|
> |---------------|---------|-------|
> | {string : "[] ( `[`) ) {}" } | Q1B2 - Q2B2 - Q3B2 - Q4B1 - Q5B2 - Q6B1 | False

3. *Base Choice Coverage*
In our code we don't have any predicate that uses more than two boolean operators but by looking at our tests we never have a case where there are no items on the stack and we match either : `] ) }`. So the statement `st.isEmpty()` will always respond false and the second boolean after the `||` operator will always be executed. We should have more tests to make sure this boolean could be `True` and not execute the rest of the evaluation after the `||` and still work properly.

To do this we add this test:

> |Input|Blocks|Oracle|
> |---------------|---------|-------|
> | {string : "[] [ `)` ] {}" } | Q1B2 - Q2B2 - Q3B2 - Q4B1 - Q5B2 - Q6B1 | False
> | {string : "[] ( `]` ) {}" } | Q1B2 - Q2B2 - Q3B2 - Q4B1 - Q5B2 - Q6B1 | False
> | {string : "[] ( `}` ) {}" } | Q1B2 - Q2B2 - Q3B2 - Q4B1 - Q5B2 - Q6B1 | False

4. PIT Tests:

> TODO




