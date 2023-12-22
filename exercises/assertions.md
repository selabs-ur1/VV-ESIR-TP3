# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer
1. 
   La raison pour laquelle cette assertion échoue est due aux erreurs d'arrondi des nombres à virgule flottante en informatique. En raison de la représentation binaire des nombres à virgule flottante, l'expression `3 * 0.4` produit un résultat qui n'est pas exactement égal à 1.2, mais plutôt une valeur très proche. Pour effectuer correctement ce type de vérification, il est recommandé d'utiliser une méthode qui gère la tolérance pour les erreurs d'arrondi, comme `assertEquals` avec un écart acceptable.

2. 
   - `assertEquals` compare le contenu des objets pour l'égalité logique, en utilisant la méthode `equals`. Cela fonctionne bien pour la plupart des objets, y compris les objets dont les valeurs sont égales mais qui ne référencent pas le même objet en mémoire.
   
   - `assertSame` compare les références d'objets, vérifiant s'ils pointent vers le même emplacement en mémoire. Il ne se soucie pas de l'égalité logique des contenus, mais seulement de l'identité des objets.

   Exemple :
   ```java
   String str1 = new String("Hello");
   String str2 = new String("Hello");
   
   assertEquals(str1, str2); // Les contenus sont égaux, cela réussira
   assertSame(str1, str2);    // Les références ne sont pas les mêmes, cela échouera
   ```

3.

   `fail` peut être utilisé pour marquer délibérément des parties de code qui ne sont pas encore implémentées. Cela peut être utile lors du développement de nouvelles fonctionnalités pour indiquer clairement qu'une certaine section de code n'est pas encore écrite.

   Exemple :
   ```java
   public int multiply(int a, int b) {
       if (a == 0 || b == 0) {
           fail("Not yet implemented: multiplication by zero");
       }
       return a * b;
   }
   ```

4. 
   L'utilisation de `assertThrows` dans JUnit 5 offre plusieurs avantages :
   - **Clarté du code :** La vérification des exceptions est séparée du code principal du test, ce qui rend le code plus lisible et compréhensible.
   - **Flexibilité :** `assertThrows` permet des assertions plus complexes sur l'exception, comme la vérification du message d'erreur ou d'autres propriétés de l'exception.
   - **Meilleure séparation des préoccupations :** Les tests peuvent se concentrer sur la logique métier, tandis que la gestion des exceptions est traitée de manière explicite, favorisant une meilleure modularité.
   - **Facilité de migration :** Si le framework JUnit est mis à jour, les tests utilisant `assertThrows` sont moins susceptibles de nécessiter des modifications par rapport aux tests utilisant des annotations spécifiques pour les exceptions.