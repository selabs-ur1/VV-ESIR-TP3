# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?


## Answer


1. L'assertion assertTrue(3 * .4 == 1.2) échoue à cause des problèmes de précision des nombres à virgule flottante.
   Dans ce cas, 3 * .4 pourrait ne pas être exactement égal à 1.2, mais quelque chose comme 1.2000000000000002.

   Pour comparer des nombres à virgule flottante, on peut utiliser une tolérance pour vérifier si les deux valeurs sont proches l'une de l'autre. 
   on peut donc réécrire la commande comme ceci: assertEquals(1.2, 3 * 0.4, 1e-9); avec comme tolérence 1e-9.

2. Différence entre `assertEquals` et `assertSame`:
    assertEquals : Compare les valeurs de deux objets pour vérifier leur égalité à l'aide de la méthode .equals().
    assertSame : Vérifie si les deux références pointent vers le même objet (si elles sont identiques en mémoire).

   Scenario où ils produisent le même résultat:

    String comp1 = "Scenario";
    String comp2 = "Scenario";
    assertEquals(comp1, comp2);  Vrai
    assertSame(comp1, comp2);   Vrai

   Scenario où ils produisent le même résultat:

    String comp1 = new String("Scenario");
    String comp2 = new String("Scenario");
    assertEquals(comp1, comp2);  Vrai
    assertSame(comp1, comp2);    Faux


3.  
    1.  fail() peut être utiliser dans le cas où quelque chose aurait mal tourné, c'est à dire si une condition n'est pas respecté et donc que 
        la logique de test n'est pas valide, alors fail() permet d'entraîner immédiatement l'échec du test avec la possibilité d'afficher un message pour infiquer l'erreur.

        Exemple: 

        @Test
        public void testObject() {
            if(obj == null) {
                fail("obj ne devrait pas être null");
            }
            //....
        }

    2. §§§§§§§§§§§§§§§§§§§§§§ Autre cas d'utilisation à faire §§§§§§§§§§§§§§§§§§§§§§§§§



4.   Avantages de assertThrows par rapport à @Test(expected) :

    1. assertThrows est plus explicite en définissant le bloc de code exact où l'exception est attendue. Avec @Test(expected), si une exception est levée avant l'endroit attendu, le test peut toujours réussir, ce qui peut donner des résultats trompeurs.

    2. assertThrows permet de se concentrer sur des parties spécifiques du code où une exception est attendue, offrant un meilleur contrôle.

    3. assertThrows renvoie l'exception levée, ce qui permet de vérifier des éléments supplémentaires, comme le message d'erreur de l'exception.

    Exemple avec assertThrows :

        @Test
            public void testDivisionParZero() {
                Calculatrice calculatrice = new Calculatrice();

                assertThrows(IllegalArgumentException.class, () ->
                        calculatrice.diviser(10, 0));
            }

    assertThrows est utilisée pour vérifier qu'une IllegalArgumentException est levée lorsque la méthode diviser(10, 0) est appelée.
    Ce type de test est très utile pour vérifier que les cas d'erreurs sont correctement gérés dans une application.

    