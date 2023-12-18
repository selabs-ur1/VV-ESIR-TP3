# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

Parmi les règles présentes dans pmd-documentation, nous avons en avons reconnu plusieurs dont nous avons parlé en cours. Par exemple, il ne faut pas oublier d'utiliser les décorateurs @After et @Before dans les méthodes setUp() et tearDown(), c'est ce que vérifient les règles JUnit4TestShouldUseBeforeAnnotation et JUnit4TestShouldUseAfterAnnotation. La règle DetachedTestCase vérifie qu'il n'y a bien qu'un seul cas de test par bloc @Test, afin de bien savoir quel est le bug si le test ne passe pas.  

A l'aide de la règle DetachedTestCase, nous avons trouvé un cas de test sans le décorateur @Test. Pour éliminer l'erreur, nous avons ajouté ce décorateur.
~~~
    @Test
    public void testConcatenateSingle() {
        final double[] x = new double[] {0, 1, 2};
        Assert.assertArrayEquals(x, MathArrays.concatenate(x), 0);
    }

    
    public void testConcatenateEmptyArguments() {
        final double[] x = new double[] {0, 1, 2};
        final double[] y = new double[] {3};
        final double[] z = new double[] {};
        final double[] u = new double[] {0, 1, 2, 3};
        Assert.assertArrayEquals(u,  MathArrays.concatenate(x, z, y), 0);
        Assert.assertArrayEquals(u,  MathArrays.concatenate(x, y, z), 0);
        Assert.assertArrayEquals(u,  MathArrays.concatenate(z, x, y), 0);
        Assert.assertEquals(0,  MathArrays.concatenate(z, z, z).length);
    }
~~~
~~~
    @Test
    public void testConcatenateSingle() {
        final double[] x = new double[] {0, 1, 2};
        Assert.assertArrayEquals(x, MathArrays.concatenate(x), 0);
    }

    @Test
    public void testConcatenateEmptyArguments() {
        final double[] x = new double[] {0, 1, 2};
        final double[] y = new double[] {3};
        final double[] z = new double[] {};
        final double[] u = new double[] {0, 1, 2, 3};
        Assert.assertArrayEquals(u,  MathArrays.concatenate(x, z, y), 0);
        Assert.assertArrayEquals(u,  MathArrays.concatenate(x, y, z), 0);
        Assert.assertArrayEquals(u,  MathArrays.concatenate(z, x, y), 0);
        Assert.assertEquals(0,  MathArrays.concatenate(z, z, z).length);
    }
~~~
