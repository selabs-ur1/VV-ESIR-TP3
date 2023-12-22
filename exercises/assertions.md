# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

## 1-
L'échec se produit en raison de la précision des calculs en virgule flottante. Dans de nombreux langages de programmation, les nombres en virgule flottante ne peuvent pas être représentés de manière exacte. Dans ce cas, 3 * 0,4 pourrait ne pas être exactement égal à 1,2 en raison des erreurs d'arrondi. Lorsque l'on travaille avec des nombres en virgule flottante, il vaut mieux utiliser une valeur delta pour vérifier une égalité approximative.

Nous vous présentons cet exemple : `assertTrue(Math.abs(3 * 0,4 - 1,2) < 0,0001);`

`0,0001` est une petite valeur delta pour tenir compte des variations infimes dans les calculs en virgule flottante.


## 2-

- assertEquals vérifie si deux objets sont égaux en termes de contenu.
- assertSame vérifie si deux références pointent exactement vers la même instance d'objet.

###### Scénarios :
- Produire le même résultat :
````java
    String str1 = "Bonjour";
    String str2 = new String("Bonjour");
    
    assertEquals(str1, str2); // Même contenu, objets différents
    assertNotSame(str1, str2); // Références différentes
```` 

- Ne pas produire le même résultat :
  
```java
    String str1 = "Bonjour";
    String str2 = str1;
    assertSame(str1, str2); // Même référence
    assertEquals(str1, str2); // Même contenu, même objet
```

## 3- 
###### Autres utilisations de fail dans JUnit :

La méthode fail peut être utilisée pour :
- marquer du code incomplet ou intentionnellement inaccessible, 
- ou comme espace réservé pour du code qui ne devrait pas être exécuté dans certaines conditions.

###### Exemple :
```java
    public void someMethod(int value) {
        if (value < 0) { // Certaines conditions spécifiques où la méthode ne devrait pas se poursuivre
            fail("Entrée invalide : la valeur doit être non négative");
        }
        // Reste de la logique de la méthode pour une entrée valide
    }

```


## 4- 
###### Avantages de assertThrows dans JUnit 5 :
- Explicité : L'utilisation de assertThrows indique clairement qu'une exception est attendue, améliorant la lisibilité du code.

- Type d'exception : Vous pouvez spécifier explicitement le type d'exception attendu, rendant le test plus robuste.

- Expression lambda : Il vous permet d'utiliser des expressions lambda pour encapsuler le code qui devrait lever une exception, offrant une syntaxe plus concise.

###### Exemple:
````java
    @Test
    public void testException() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Code censé lever IllegalArgumentException
            someObject.methodThatThrowsException();
        });
    }
````
Cette approche est plus expressive et flexible que la gestion des exceptions basée sur les annotations de JUnit 4.







