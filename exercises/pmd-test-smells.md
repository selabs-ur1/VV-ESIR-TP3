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

Nous utiliserons le projet Apache Common Math
A la ligne 712 du fichier 'commons-math-legacy-core/src/test/java/org/apache/commons/math4/legacy/core/MathArraysTest.java', On a un classe de test n'ayant pas été annoté par @Test ce qui à été détecté par PMD comme étant un 'DetachedTestCase' Comme présenté sur l'image 1(Voir fichier image1 joint).
La solution la plus simple ici serait d'annoter le Test avec '@Test' Comme suit:
Code avant:
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
Code Après:
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

