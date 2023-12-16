# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. L'assertion échoue suite à des erreurs de précision liées à la virgule flottante. Pour éviter ce problème, on peut, par exemple, remplacer la méthode `assertTrue` par la méthode `assertEquals` et son paramètre `delta`. Cela pourrait donner `assertEquals(3 * .4, 1.2, 0.00001)`.

2. La méthode `assertEquals` vérifie si deux objets sont égaux en termes de valeur ou de contenu alors que la méthode `assertSame` vérifie si deux objets référencent la même instance d'objet.

  Par exemple, 

  ```java
  String str1 = "Hello";
  String str2 = str1;
  assertSame(str1, str2); // Renvoie True
  assertEquals(str1, str2); // Renvoie True
  ```

  ```java
  String str1 = new String("Hello");
  String str2 = new String("Hello");
  assertSame(str1, str2);  // Renvoie False
  assertEquals(str1, str2);  // Renvoie True
  ```

3. On peut utiliser `fail` pour s'assurer de renvoyer un exception lorsque l'on se trouve dans un scénario qui ne devrait pas se produire.

  Par exemple,

  ```java
  try{
    methodeErronee();
    fail(); // FAIL si l'exception n'est pas catchée
  } catch (methodException e) {
    // OK on catch bien l'exception
  }
  ```

4. Tout d'abord, l'utilisation d'`assertThrows` rend la vérification de levée d'exception plus claire. Par ailleurs, la méthode `assertThrows` offre diverses surchages qui attendent en paramètres le type de l'exception qui doit être levée, une interface fonctionnelle de type Executable qui est le code à exécuter et éventuellement un message. Elle est également compatible avec l'utilisation de lambda.






