# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. L'assertion provoque une erreur à cause d'une imprécision des nombres flottants et l'arrondissement des valeurs. Pour résoudre ce problème, il vaut mieux utiliser `assertEquals` en ajoutant en paramètre un delta correspondant au degré de tolérance.

2. `AssertEquals` : les deux objets ont la même valeur.  
`AssertSame` : les deux objets sont les mêmes.  

Exemple de scénario où les deux assertions ne produisent pas la même sortie :  
AssertSame("1", new String("1)); -> Fail  
AssertEquals("1", new String("1)); -> Pass  

Exemple de scénario où les deux assertions produisent la même sortie :  
String a = new Strin("1");  
AssertSame(a, a); -> Pass  
AssertEquals("1", a); -> Pass  

3. Nous pouvons aussi utiliser fail pour vérifier une condition pendant l'exécution d'un test.
Par exemple, on peut vérifier si une variable n'a pas de valeurs interdites.
 `@Test  
   public void test(int b, int n){  
     if(n==0){  
       fail("Cannot divide by 0");  
     } else {  
       int c = b/n;  
   }`

4. AssertThrows est plus clair et plus concis que l'exception de base, ce qui permet une meilleure lisibilité du code. De plus, `AssertThrows` renvoie des informations supplémentaires sur l'erreur et se concentre sur un scénario précis du test. Cela peut par exemple remplacer une utilisation de `fail` pour vérifier qu'une exception a bien été lancée.

