# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

##Explication de l'échec de l'assertion : 
L'assertion assertTrue(3 * 0,4 == 1,2) échoue car l'arithmétique des flottants peut introduire des erreurs de précision. Dans ce cas, 3 * 0,4 peut ne pas donner exactement 1,2 en raison de la façon dont les nombres flottants sont représentés dans les ordinateurs. Pour comparer des flottants, il est préférable d'utiliser une valeur epsilon (une petite différence acceptable) pour tenir compte des erreurs d'arrondi. Par exemple :

```
assertTrue(Math.abs(3 * 0.4 - 1.2) < 0.000001);
```

##Différence entre assertEquals et assertSame :
assertEquals est utilisé pour vérifier si deux valeurs sont égales en fonction de leur contenu.
assertSame est utilisé pour vérifier si deux références pointent exactement vers le même objet.

##Scénarios où ils produisent le même résultat :
Pour les types primitifs tels que int, assertEquals et assertSame produisent le même résultat.

Lors de la comparaison de références vers le même objet.

##Scénarios où ils ne produisent pas le même résultat :
- Lors de la comparaison de références vers des objets différents avec un contenu égal, assertEquals réussira, mais assertSame échouera.
Autres utilisations de fail :
- Échec conditionnel :
On peut utiliser fail pour marquer explicitement le code qui ne devrait pas être atteint dans certaines conditions, fournissant une indication claire d'un flux de programme inattendu.
Avantages de assertThrows dans JUnit 5 :
- Amélioration de la lisibilité : L'utilisation de assertThrows offre une manière claire et précise d'exprimer l'attente d'une exception. Cela améliore la lisibilité du code, indiquant clairement qu'une exception spécifique est prévue.
- Vérification du type d'exception : Avec assertThrows, on peut spécifier le type d'exception attendu.

