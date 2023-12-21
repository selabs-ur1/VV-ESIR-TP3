# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1. l'assertion échoue car la multiplication 3 * .4 ne donne pas 1.2 mais 1.2000000000000002. Cela est du à une mauvaise conversion de .4. Afin de pouvoir vérifier l'assertion, il est donc préférable de déclarer les membres utiliser lors de l'assertion avant.

2. assertEquals vérifie que les valeurs des objets soient les mêmes (appel à la fonction .equals des objets). Tandis que assertSame vérifie que les deux objets font référence au même objet. Exemple : assertEquals(1,1) = assertSame(1,1) mais assertEquals(128,128) != assertsame(128,128) car en java les entiers superieur à 127 sont instancier dans des objets, les deux 128 sont donc deux instances différentes possédants la même valeur comme seul attribut.

3. "fail" peut être utilisé afin marquer les tests incomplets et à finir. Il peut aussi être utilisé pour vérifier des conditions afin de savoir si le test a été correctement initialisé par exemple.

4. Les avantages de assertThrows comparé aux @test sont qu'il permet de tester plusieurs exceptions dans un même test. Il permet aussi d'accéder plus facilement aux propriétés de l'exception. 
